package com.example.adoption.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PetInfo;
import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.PetInfoDao;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.PetInfoService;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.PetInfoAndUserInfoResponse;
import com.example.adoption.vo.PetInfoAndUserInfoVo;
import com.example.adoption.vo.PetInfoListResponse;
import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;
import com.example.adoption.vo.UserInfoResponse;


@Service
public class PetInfoServiceImpl implements PetInfoService {

	@Autowired
	private PetInfoDao petDao;

	@Autowired
	private UserInfoDao userDao;

	// create
	@Override
	public PetInfoResponse createPet(PetInfoRequest req) {

		PetInfo pet = req.getPetInfo();

		// check parameters
		if (pet.getUserId() == 0 || pet.getUserId() < 0 || !StringUtils.hasText(pet.getPetName())
				|| !StringUtils.hasText(pet.getAdoptionStatus()) || !StringUtils.hasText(pet.getType())) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}

		// check if the user exist
		Optional<UserInfo> check = userDao.findById(pet.getUserId());
		if (check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}

		// 設定pet id
		PetInfo lastPet = petDao.findTopByUserIdOrderByPetIdDesc(pet.getUserId());
		System.out.println(lastPet);
		if (lastPet == null) {
			pet.setPetId("P" + pet.getUserId() + "01");
		} else {
			String lastPetId = lastPet.getPetId();
			String numericPart = lastPetId.substring(1);// 获取字符串的第二个字符开始的部分
			long lastPetIdLong = Long.parseLong(numericPart); // 将提取的字符串部分转换为 long 类型
			pet.setPetId("P" + (lastPetIdLong + 1));
		}

		// save to DB
		// use try/catch
		try {
			petDao.save(pet);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
		}

		return new PetInfoResponse(pet, RtnCode.SUCCESSFUL);
	}

	// get the user's pet list
	@Override
	public PetInfoListResponse getPetList(int userId) {

		// check parameters
		if (userId == 0 || userId < 0) {
			return new PetInfoListResponse(null, RtnCode.PARAM_ERROR);
		}

		// check if the userId is exiest
		Optional<UserInfo> check = userDao.findById(userId);
		if (check.isEmpty()) {
			return new PetInfoListResponse(null, RtnCode.ID_NOT_FOUND);
		}

		List<PetInfo> res = petDao.findAllByUserId(userId);

		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public PetInfoResponse updatePet(PetInfoRequest req) {

		PetInfo pet = req.getPetInfo();

		// check parameters
		if (pet.getUserId() == 0 || pet.getUserId() < 0 || !StringUtils.hasText(pet.getPetName())
				|| !StringUtils.hasText(pet.getAdoptionStatus()) || !StringUtils.hasText(pet.getType())) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}

		// check if the pet id is exist
		Optional<PetInfo> check = petDao.findById(pet.getPetId());
		if (check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		if (check.get().getUserId() != pet.getUserId()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}

		// save to DB
		// use try/catch
		try {
			petDao.updateInfo(
					pet.getPetId(), pet.getPetName(), pet.getPetBreed(), pet.getPetStatus(), 
					pet.getAdoptionStatus(), pet.getAge(), pet.getVaccine(), pet.getPetProfile(), 
					pet.isLigation(), pet.getType(), pet.getPetPhoto(), pet.getLocation()
					);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
		}
		
		System.out.println(pet);
		
		return new PetInfoResponse(pet, RtnCode.SUCCESSFUL);
	}

	// delete
	@Override
	public PetInfoResponse deletePet(String petId, int userId) {

		// check parameters
		if (!StringUtils.hasText(petId) || userId == 0 || userId < 0) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}

		// save to DB
		// use try/catch
		try {
			petDao.deleteById(petId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
		}

		return new PetInfoResponse(null, RtnCode.SUCCESSFUL);
	}
	
	
	
	
	//==========================
	
	
	
	
	
	@Override
	public PetInfoResponse adoptPet(String petId, int userId) {

		// check parameters
		if (userId == 0 || userId < 0) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}

		// check if the pet info exist
		Optional<PetInfo> check = petDao.findById(petId);
		if (check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}

		// check if the pet can be adopted
		PetInfo pet = check.get();
		if (!pet.getAdoptionStatus().equals("送養中")) {
			return new PetInfoResponse(null, RtnCode.THE_PET_CANNOT_BE_ADOPTED);
		}

		if (pet.getUserId() == userId) {
			return new PetInfoResponse(null, RtnCode.ADOPT_ERROR);
		}

		// set the user id to the adopter id list
		String strUserId = Integer.toString(userId);
		
		
        String strAdopterIdList = pet.getAdopterIdList();
        if(!StringUtils.hasText(strAdopterIdList)) {
        	pet.setAdopterIdList(strUserId);
        } else {
        	// 1. 將用逗號分隔開的字串轉成陣列
	        String[] strArray = strAdopterIdList.split(",");
	        
	        // 2. 檢查陣列中是否包含該user id
	        if (Arrays.asList(strArray).contains(strUserId)) {
	        	// 如果有包含，返回訊息
	        	return new PetInfoResponse(pet, RtnCode.THE_USER_HAS_ALREADY_ADOPTED_THE_PET);
	        } else {
	        	// 如果沒有包含，新增到陣中
	            String[] newArray = Arrays.copyOf(strArray, strArray.length + 1);
	            newArray[newArray.length - 1] = strUserId;

	            // 將陣列轉回字串
	            String newStr = String.join(",", newArray);
	            
	            // 存回pet
	            pet.setAdopterIdList(newStr);
	            
	        }
	        
        }
        
        
        // sysout the pet
        System.out.println("adopter id list of the pet: " + pet.getAdopterIdList());
        
        // save to DB
 		// use try/catch
 		try {
 			petDao.save(pet);
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
 		}
		
		
		return new PetInfoResponse(pet, RtnCode.SUCCESSFUL);
	}
	
	
	

	@Override
	public PetInfoListResponse getAdoptPetList(int userId) {

		// check parameters
		if (userId == 0 || userId < 0) {
			return new PetInfoListResponse(null, RtnCode.PARAM_ERROR);
		}

		String StrId = Integer.toString(userId);

		List<PetInfo> res = petDao.findAllByAdopterIdListContaining(StrId);

		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}
	
	
	

	@Override
	public PetInfoListResponse getAdoptablePetList(String status, String type, String area, String location) {
		
		String searchType = type;
		String searchArea = area;
		List<String> searchLocation = new ArrayList<>();

		// check if the parameter is null, set ""
		if (type == null) {
			searchType = "";
		}
		if (area == null) {
			searchArea = "";
		}
		if (location != null && location.trim() != "") {
			searchLocation.add(location);
		} else if (searchArea != null){
			switch (searchArea) {
		        case "北部":
		        	searchLocation = Arrays.asList("台北市","新北市","基隆市","新竹市","桃園市","新竹縣","宜蘭縣");
		        	break;
		        case "中部":
		        	searchLocation = Arrays.asList("台中市","苗栗縣","彰化縣","南投縣","雲林縣");
		        	break;
		        case "南部":
		        	searchLocation = Arrays.asList("高雄市","台南市","嘉義市","嘉義縣","屏東縣","澎湖縣");
		        	break;
		        case "東部":
		        	searchLocation = Arrays.asList("花蓮縣", "台東縣");
		        	break;
		        default:
		        	searchLocation = Arrays.asList("台北市","新北市","基隆市","新竹市","桃園市","新竹縣","宜蘭縣",
		        		"台中市","苗栗縣","彰化縣","南投縣","雲林縣",
	                    "高雄市","台南市","嘉義市","嘉義縣","屏東縣","澎湖縣",
	                    "花蓮縣","台東縣", "");
		    }
		}

		List<PetInfo> res = petDao.findAllByAdoptionStatusAndTypeContainingAndLocationIn(status, searchType, searchLocation);

		if (res.isEmpty()) {
			return new PetInfoListResponse(res, RtnCode.NOT_FOUND);
		}

		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}
	
	
	
	
	// =================================

	@Override
	public PetInfoResponse quitAdoptPet(String petId, int userId) {
		
		// check parameters
		if(userId == 0 || userId < 0) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}
		
		// check if the pet info exist
		Optional<PetInfo> check = petDao.findById(petId);
		if(check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		
		// reset the adopter id list
		PetInfo pet = check.get();
		
		// let the string change the type to array
		String strAdopterIdList = pet.getAdopterIdList();
		String strUserId = Integer.toString(userId);
		
		// 1. 将逗号分隔的字符串拆分为数组
        String[] strArray = strAdopterIdList.split(",");
        
        // 2. 移除指定值
        String strToRemove = strUserId;
        List<String> list = new ArrayList<>(Arrays.asList(strArray));
        list.remove(strToRemove);

        // 3. 將array轉回string
        String newStr = String.join(",", list.toArray(new String[0]));

        
        pet.setAdopterIdList(newStr);
        
        
        // sysout the pet
        System.out.println("adopter id list of the pet: " + pet.getAdopterIdList());
        
        // save to DB
 		// use try/catch
 		try {
 			petDao.save(pet);
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
 		}
		
		
		return new PetInfoResponse(pet, RtnCode.SUCCESSFUL);
	}



	// owner reject
	@Override
	public PetInfoResponse rejectAdoptPet(String petId, int ownerId, int adopterId) {
		
		
		// check parameters, or if the owner id = adopter id
		if( !StringUtils.hasText(petId) || ownerId == 0 || ownerId < 0 || adopterId == 0 || adopterId < 0 || ownerId == adopterId) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}
		
		// check if the pet info exist
		Optional<PetInfo> check = petDao.findById(petId);
		if(check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		PetInfo pet = check.get();
		
		// check if the owner id is the pet's user id
		if(pet.getUserId() != ownerId) {
			return new PetInfoResponse(null, RtnCode.REJECT_ERROR);
		}
		
		// let the string change the type to array
		String strAdopterIdList = pet.getAdopterIdList();
		String strUserId = Integer.toString(adopterId);
		
		// 1. 将逗号分隔的字符串拆分为数组
        String[] strArray = strAdopterIdList.split(",");
        
        // 2. 移除指定值
        List<String> list = new ArrayList<>(Arrays.asList(strArray));
        list.remove(strUserId);
        

        // 3. 將array轉回string
        String newStr = String.join(",", list.toArray(new String[0]));
		
        // set the new adopter id list back to the pet
        pet.setAdopterIdList(newStr);
        
        
        // sysout the pet
        System.out.println("adopter id list of the pet: " + pet.getAdopterIdList());
        
        
        // save to DB
 		// use try/catch
 		try {
 			petDao.save(pet);
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
 		}
		
		return new PetInfoResponse(pet, RtnCode.SUCCESSFUL);
	}



	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	public PetInfoAndUserInfoResponse getAdoptPetInfoAndUserInfo(String petId) {
		
		// check the parameter
		if(!StringUtils.hasText(petId)) {
			return new PetInfoAndUserInfoResponse(null, RtnCode.PARAM_ERROR);
		}
		
		// check if the pet id exist
		Optional<PetInfo> check = petDao.findById(petId);
		if(check.isEmpty()) {
			return new PetInfoAndUserInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		// get the pet info
		PetInfo pet = check.get();
		
		// get the user
		UserInfoResponse userRes = userInfoService.searchById(pet.getUserId());
		UserInfo user = userRes.getUserInfo();
		
		// set the pet info and the user info to the vo
		PetInfoAndUserInfoVo vo = new PetInfoAndUserInfoVo(pet, user);
		
		return new PetInfoAndUserInfoResponse(vo, RtnCode.SUCCESSFUL);
	}


	
	
	
	// =================================================
	

	
	@Override
	public PetInfoListResponse getAdoptedPetList() {
		
		List<PetInfo> res = new ArrayList<>();
		
		try {
			res = petDao.findAllByAdoptionStatus("已送養");
		} catch (Exception e) {
			System.out.println(e.getMessage());
 			return new PetInfoListResponse(null, RtnCode.SAVE_DB_ERROR);
		}
		
		
		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}
	

}
