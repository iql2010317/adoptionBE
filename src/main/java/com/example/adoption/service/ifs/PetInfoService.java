package com.example.adoption.service.ifs;

import com.example.adoption.vo.PetInfoListResponse;
import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;

public interface PetInfoService {

	// create
	public PetInfoResponse createPet(PetInfoRequest req);
	
	// get the user's pet list
	public PetInfoListResponse getPetList(int userId);
	
	// update the pet's info
	public PetInfoResponse updatePet(PetInfoRequest req);
	
	// delete the pet's info
	public PetInfoResponse deletePet(String petId, int userId);
	
	
}
