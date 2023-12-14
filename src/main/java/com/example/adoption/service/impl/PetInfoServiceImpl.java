package com.example.adoption.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.adoption.constants.RtnCode;
import com.example.adoption.entity.PetInfo;
import com.example.adoption.repository.PetInfoDao;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.PetInfoService;
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
		if(userDao.findById(pet.getUserId()) == null) {
			return new PetInfoResponse(null, RtnCode.ID_NOT_FOUND);
		}
		
		pet.setPetId("P" + pet.getUserId() + "0" + Integer.toString(petDao.findAllByUserId(pet.getUserId()).size()+1));
		
		System.out.println(pet.getPetId());
		
		
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

}
