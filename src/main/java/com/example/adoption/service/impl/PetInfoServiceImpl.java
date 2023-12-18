package com.example.adoption.service.impl;

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
import com.example.adoption.vo.PetInfoListResponse;
import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;


@Service
public class PetInfoServiceImpl implements PetInfoService{

	
	@Autowired
	private PetInfoDao petDao;
	
	@Autowired
	private UserInfoDao userDao;
	
	
	
	// create
	@Override
	public PetInfoResponse createPet(PetInfoRequest req) {
		
		PetInfo pet = req.getPetInfo();
		
		// check parameters
		if( pet.getUserId() == 0 || pet.getUserId() < 0
				|| !StringUtils.hasText(pet.getPetName()) || !StringUtils.hasText(pet.getAdoptionStatus())
				|| !StringUtils.hasText(pet.getType())) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}
		
		// check if the user exist
		Optional<UserInfo> check = userDao.findById(pet.getUserId());
		if(check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}


		// 設定pet id
		PetInfo lastPet = petDao.findTopByUserIdOrderByPetIdDesc(pet.getUserId());
		System.out.println(lastPet);
		if(lastPet == null) {
			pet.setPetId("P" + pet.getUserId() + "01");
		} else {
			String lastPetId = lastPet.getPetId();
			String numericPart = lastPetId.substring(1);// 获取字符串的第二个字符开始的部分
			long lastPetIdLong = Long.parseLong(numericPart); // 将提取的字符串部分转换为 long 类型
			pet.setPetId("P" + (lastPetIdLong+1) );
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
		if(userId == 0 || userId < 0) {
			return new PetInfoListResponse(null, RtnCode.PARAM_ERROR);
		}
		
		// check if the userId is exiest
		Optional<UserInfo> check = userDao.findById(userId);
		if(check.isEmpty()) {
			return new PetInfoListResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		List<PetInfo> res = petDao.findAllByUserId(userId);
		
		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}



	@Override
	public PetInfoResponse updatePet(PetInfoRequest req) {
		
		PetInfo pet = req.getPetInfo();
		
		// check parameters
		if( pet.getUserId() == 0 || pet.getUserId() < 0
				|| !StringUtils.hasText(pet.getPetName()) || !StringUtils.hasText(pet.getAdoptionStatus())
				|| !StringUtils.hasText(pet.getType())) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}
		
		
		// check if the pet id is exist
		Optional<PetInfo> check = petDao.findById(pet.getPetId());
		if(check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		if(check.get().getUserId() != pet.getUserId()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		
		// save to DB
		// use try/catch
		try {
			petDao.updateInfo(
					pet.getPetId(), pet.getPetName(), pet.getPetBreed(), pet.getPetStatus(), 
					pet.getAdoptionStatus(), pet.getAge(), pet.getVaccine(), pet.getPetProfile(), 
					pet.isLigation(), pet.getType(), pet.getPetPhoto(), pet.getLocaiton()
					);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PetInfoResponse(null, RtnCode.SAVE_DB_ERROR);
		}
		
		
		return new PetInfoResponse(null, RtnCode.SUCCESSFUL);
	}



	@Override
	public PetInfoResponse deletePet(String petId, int userId) {
		
		// check parameters
		if( !StringUtils.hasText(petId) || userId == 0 || userId < 0) {
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
	//尚未寫進controller
	
	
	
	
	
	@Override
	public PetInfoResponse adoptPet(String petId, int userId) {
		

		// check parameters
		if(userId == 0 || userId < 0) {
			return new PetInfoResponse(null, RtnCode.PARAM_ERROR);
		}
		
		// check if the pet info exist
		Optional<PetInfo> check = petDao.findById(petId);
		if(check.isEmpty()) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		// check if the pet can be adopted
		PetInfo pet = check.get();
		if(!pet.getAdoptionStatus().equals("送養中")) {
			return new PetInfoResponse(null, RtnCode.THE_PET_CANNOT_BE_ADOPTED);
		}
		
		if(pet.getUserId() == userId) {
			return new PetInfoResponse(null, RtnCode.ADOPT_ERROR);
		}
		
		// set the user id to the adopter id list
		String strUserId = Integer.toString(userId);
		
		// 1. 将逗号分隔的字符串拆分为数组
        String strAdopterIdList = pet.getAdopterIdList();
        if(!StringUtils.hasText(strAdopterIdList)) {
        	pet.setAdopterIdList(strUserId);
        } else {
	        String[] strArray = strAdopterIdList.split(",");
	
	        // 2. 将要添加的值追加到数组
	        String[] newArray = Arrays.copyOf(strArray, strArray.length + 1);
	        newArray[newArray.length - 1] = strUserId;
	
	        // 3. 如果需要，将数组转换回字符串
	        String newStr = String.join(",", newArray);
	
	        // 打印结果
	        System.out.println("Original String: " + strAdopterIdList);
	        System.out.println("Original Array: " + Arrays.toString(strArray));
	        System.out.println("Value to Add: " + strUserId);
	        System.out.println("New Array: " + Arrays.toString(newArray));
	        System.out.println("New String: " + newStr);
	        
	        pet.setAdopterIdList(newStr);
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
		if(userId == 0 || userId < 0) {
			return new PetInfoListResponse(null, RtnCode.PARAM_ERROR);
		}
		
		String StrId = Integer.toString(userId);
		
		List<PetInfo> res = petDao.findAllByAdopterIdListContaining(StrId);
		
		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}



	@Override
	public PetInfoListResponse getAdoptablePetList(String type, String location) {
		
		String searchType = type;
		String searchLocation = location;
		
		// check if the parameter is null, set ""
		if(type == null) {
			searchType = ""; 
		}
		if(location == null) {
			searchLocation = "";
		}
		
//		List<PetInfo> res = petDao.findAllByAdoptionStatus("送養中");
//		List<PetInfo> res = petDao.findAllByAdoptionStatusAndTypeContaining("送養中", searchType);
		List<PetInfo> res = petDao.findAllByAdoptionStatusAndTypeContainingAndLocationContaining("送養中", searchType, searchLocation);
		
		if(res.isEmpty()) {
			return new PetInfoListResponse(res, RtnCode.NOT_FOUND);
		}
		
		return new PetInfoListResponse(res, RtnCode.SUCCESSFUL);
	}



	

}
