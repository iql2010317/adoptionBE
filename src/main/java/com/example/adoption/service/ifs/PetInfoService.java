package com.example.adoption.service.ifs;

import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;

public interface PetInfoService {

	// create
	public PetInfoResponse createPet(PetInfoRequest req);
	
}
