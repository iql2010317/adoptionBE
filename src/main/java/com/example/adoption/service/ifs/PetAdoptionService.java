package com.example.adoption.service.ifs;

import com.example.adoption.vo.PetAdoptionResponse;




public interface PetAdoptionService {

	// owner confirm the apply of adoption
	public PetAdoptionResponse ownerConfirm(String petId, int ownerId, int adopterId);
	
	
	// adopter confirm the apply of adoption
	public PetAdoptionResponse adopterConfirm(String petId, int ownerId, int adopterId, int adopterRes);
}
