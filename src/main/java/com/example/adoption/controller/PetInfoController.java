package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.PetAdoptionService;
import com.example.adoption.service.ifs.PetInfoService;
import com.example.adoption.vo.PetAdoptionRequest;
import com.example.adoption.vo.PetAdoptionResponse;
import com.example.adoption.vo.PetIdAndOwnerIdAndAdopterIdVo;
import com.example.adoption.vo.PetIdAndUserIdVo;
import com.example.adoption.vo.PetInfoAndUserInfoResponse;
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
	public PetInfoResponse deletePet(@RequestBody PetIdAndUserIdVo vo) {
		return petInfoService.deletePet(vo.getPetId(), vo.getUserId());
	}
	
	
	// get the pet info of adopted pet
	@GetMapping(value = "api/adoption/petInfo/getAdoptPetInfoAndUserInfo")
	public PetInfoAndUserInfoResponse getAdoptPetInfoAndUserInfo(@RequestParam(value = "petId") String petId) {
		return petInfoService.getAdoptPetInfoAndUserInfo(petId);
	}
	
	
	
	// =================================
	// adoption
	
	
	// add the user to adopter id list
	@PostMapping(value = "api/adoption/petInfo/adoptPet")
	public PetInfoResponse adoptPet(@RequestBody PetIdAndUserIdVo vo) {
		return petInfoService.adoptPet(vo.getPetId(), vo.getUserId());
	}
	
	// the user's adopt pet list
	@GetMapping(value = "api/adoption/petInfo/getAdoptPetList")
	public PetInfoListResponse getAdoptPetList(@RequestParam(value = "userId") int userId) {
		return petInfoService.getAdoptPetList(userId);
	}
	
	// all adoptable pets
	@GetMapping(value = "api/adoption/petInfo/getAdoptablePetList")
	public PetInfoListResponse getAdoptablePetList(@RequestParam(value = "type") String type,@RequestParam(value = "location") String location) {
		return petInfoService.getAdoptablePetList(type, location);
	}
	
	
	
	// ===================================
	// adoption application
	
	
	// adopter quit
	@PostMapping(value = "api/adoption/petInfo/quitAdoptPet")
	public PetInfoResponse quitAdoptPet(@RequestBody PetIdAndUserIdVo vo) {
		return petInfoService.quitAdoptPet(vo.getPetId(), vo.getUserId());
	}
	
	
	
	// owner reject
	@PostMapping(value = "api/adoption/petInfo/rejectAdoptPet")
	public PetInfoResponse rejectAdoptPet(@RequestBody PetIdAndOwnerIdAndAdopterIdVo vo) {
		return petInfoService.rejectAdoptPet(vo.getPetId(), vo.getOwnerId(), vo.getAdopterId());
	}
	
	
	@Autowired
	private PetAdoptionService petAdoptionService;
	
	
	// owner confirm the apply of adoption
	@PostMapping(value = "api/adoption/petInfo/ownerConfirm")
	public PetAdoptionResponse ownerConfirm(@RequestBody PetAdoptionRequest req) {
		return petAdoptionService.ownerConfirm(req.getPetId(), req.getOwnerId(), req.getAdopterId());
	}
	
	
	// adopter confirm the apply of adoption
	@PostMapping(value = "api/adoption/petInfo/adopterConfirm")
	public PetAdoptionResponse adopterConfirm(@RequestBody PetAdoptionRequest req) {
		return petAdoptionService.adopterConfirm(req.getPetId(), req.getOwnerId(), req.getAdopterId(), req.getAdopterRes());
	}

	
	
}
