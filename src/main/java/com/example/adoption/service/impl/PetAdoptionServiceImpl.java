package com.example.adoption.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PetAdoption;
import com.example.adoption.entity.PetInfo;
import com.example.adoption.repository.PetAdoptionDao;
import com.example.adoption.repository.PetInfoDao;
import com.example.adoption.service.ifs.PetAdoptionService;
import com.example.adoption.service.ifs.PetInfoService;
import com.example.adoption.vo.PetAdoptionResponse;
import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;


@Service
public class PetAdoptionServiceImpl implements PetAdoptionService {

	@Autowired
	private PetInfoDao petInfoDao;

	@Autowired
	private PetAdoptionDao petAdoptionDao;

	@Autowired
	private PetInfoService petInfoService;

	@Override
	public PetAdoptionResponse ownerConfirm(String petId, int ownerId, int adopterId) {

		String petPattern = "^P\\d{1,}\\d{2}$";

		// check parameters
		if (!StringUtils.hasText(petId) || !petId.matches(petPattern) || ownerId == 0 || ownerId < 0 || adopterId == 0
				|| adopterId < 0) {
			return new PetAdoptionResponse(null, RtnCode.PARAM_ERROR);
		}

		// check if the pet is exist
		Optional<PetInfo> findPet = petInfoDao.findById(petId);

		if (findPet.isEmpty()) {
			return new PetAdoptionResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		// check if there's final adopter id
		PetInfo pet = findPet.get();
		if(pet.getFinalAdopterId() > 0) {
			return new PetAdoptionResponse(null, RtnCode.CAN_ONLY_CHOOSE_ONE_ADOPTER);
		}
		

		// check if the adopter is in the adopter list
		String strUserId = Integer.toString(adopterId);

		int checkAdopterId = petInfoDao.findByPetIdAndAdopterIdListContaining(petId, strUserId);
		if (checkAdopterId == 0) {
			return new PetAdoptionResponse(null, RtnCode.THE_ADOPTER_IS_NOT_IN_THE_LIST);
		}

		// set a new pet adoption DB
		PetAdoption adoption = new PetAdoption(petId, ownerId, adopterId, 1, 0);

		// save to DB
		// use try/catch
		try {
			petInfoDao.updateFinalAdopterId(petId, adopterId);
			petAdoptionDao.save(adoption);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PetAdoptionResponse(null, RtnCode.SAVE_DB_ERROR);
		}

		return new PetAdoptionResponse(adoption, RtnCode.SUCCESSFUL);
	}

	
	
	
	
	
	@Override
	public PetAdoptionResponse adopterConfirm(String petId, int ownerId, int adopterId, int adopterRes) {
		
		String petPattern = "^P\\d{1,}\\d{2}$";
		
		// check parameters
		if( !StringUtils.hasText(petId) || !petId.matches(petPattern)
				|| ownerId == 0 || ownerId < 0 || adopterId == 0 || adopterId < 0) {
			return new PetAdoptionResponse(null, RtnCode.PARAM_ERROR);
		}
		
		
		// check if the pet is exist
		Optional<PetInfo> findPet = petInfoDao.findById(petId);
		if(findPet.isEmpty()) {
			return new PetAdoptionResponse(null, RtnCode.ID_NOT_FOUND);
		}
		PetInfo pet = findPet.get();
		
		
		// check if there's data in DB
		PetAdoption adoption = petAdoptionDao.findByPetIdAndOwnerIdAndAdopterIdAndAdopterConfirm(petId, ownerId, adopterId, 0);
		
		if(adoption == null) {
			return new PetAdoptionResponse(null, RtnCode.NOT_FOUND);
		}
		
		
		// save to DB
		// use try/catch
		try {
			petAdoptionDao.updateAdoptionConfirm(adoption.getSerialNo(), 1, adopterRes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new PetAdoptionResponse(null, RtnCode.SAVE_DB_ERROR);
		}
		
		// if the adopter reject the adoption, let the final_adopter_id to 0
		if(adopterRes == 2) {
			try {
				petInfoService.quitAdoptPet(petId, adopterId);
				petInfoDao.updateFinalAdopterId(petId, 0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new PetAdoptionResponse(null, RtnCode.SAVE_DB_ERROR);
			}
			return new PetAdoptionResponse(adoption, RtnCode.SUCCESSFUL);
		}

		// check if the two users all confirm to adopt
		if(adoption.getOwnerConfirm() == 1 && adopterRes == 1) {
			System.out.println("entered");
			try {
				petInfoDao.updateFinalAdopterIdAndAdoptionStatus(petId, adopterId, "已送養");
				// save the new pet info to the adopter's pet list
				PetInfo newPet = new PetInfo(adopterId, pet.getPetName(), pet.getPetBreed(), "正常", 
						pet.getAge(), pet.getVaccine(), pet.isLigation(), pet.getType(), pet.getPetPhoto());
				PetInfoRequest req = new PetInfoRequest(newPet);
				PetInfoResponse res = petInfoService.createPet(req);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new PetAdoptionResponse(null, RtnCode.SAVE_DB_ERROR);
			}
		}
		
		return new PetAdoptionResponse(adoption, RtnCode.SUCCESSFUL);
	}

	

}
