package com.example.adoption.service.ifs;

import com.example.adoption.vo.PetInfoAndUserInfoResponse;
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
	
	
	
	//==========================
	// impl line 171
	
	
	// add the user to adopter id list
	public PetInfoResponse adoptPet(String petId, int userId);
	
	// the user's adopt pet list
	public PetInfoListResponse getAdoptPetList(int userId);
	
	// all adoptable pets
	public PetInfoListResponse getAdoptablePetList(String type, String location);
	
	
	//==========================
	// impl line 279
	
	
	// adopter quit
	public PetInfoResponse quitAdoptPet(String petId, int userId);
	
	// owner reject
	public PetInfoResponse rejectAdoptPet(String petId, int ownerId, int adopterId);
	
	// get the pet info of adopted pet
	public PetInfoAndUserInfoResponse getAdoptPetInfoAndUserInfo(String petId);
	
	
	
}
