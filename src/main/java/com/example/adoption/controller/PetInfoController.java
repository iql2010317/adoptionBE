package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.PetInfoService;
import com.example.adoption.vo.PetIdUserIdVo;
import com.example.adoption.vo.PetInfoListResponse;
import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class PetInfoController {

	@Autowired
	private PetInfoService petInfoService;
	
	
	
	// create pet info
	@PostMapping(value = "api/adoption/petInfo/createPetInfo")
	public PetInfoResponse createPet(@RequestBody PetInfoRequest req) {
		return petInfoService.createPet(req);
	}
	
	
	// get the user's pet list
	@GetMapping(value = "api/adoption/petInfo/getPetInfo")
	public PetInfoListResponse getPetList(@RequestParam(value = "userId") int userId) {
		return petInfoService.getPetList(userId);
	}
	
	
	// update the pet's info
	@PostMapping(value = "api/adoption/petInfo/updatePetInfo")
	public PetInfoResponse updatePet(@RequestBody PetInfoRequest req) {
		return petInfoService.updatePet(req);
	}
	
	
	
	// delete the pet's info
	@PostMapping(value = "api/adoption/petInfo/deletePetInfo")
	public PetInfoResponse deletePet(@RequestBody PetIdUserIdVo vo) {
		return petInfoService.deletePet(vo.getPetId(), vo.getUserId());
	}
	
	
	
}
