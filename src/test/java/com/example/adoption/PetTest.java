package com.example.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.PetInfo;
import com.example.adoption.service.ifs.PetAdoptionService;
import com.example.adoption.service.ifs.PetInfoService;
import com.example.adoption.vo.PetAdoptionResponse;
import com.example.adoption.vo.PetInfoListResponse;
import com.example.adoption.vo.PetInfoRequest;
import com.example.adoption.vo.PetInfoResponse;

@SpringBootTest
public class PetTest {

	
	@Autowired
	private PetInfoService petService;
	
	
	@Test
	public void createTest() {
		
//		userId, petName, petBreed, petStatus, 
//		adoptionStatus, age, vaccine, petProfile, 
//		ligation, type, petPhoto, petOtherPhoto, locaiton
		
		PetInfo pet = new PetInfo(52, "小花", "三花貓", "健康", 
				"送養中", "五個月", "狂犬病疫苗", null, 
				false, "貓", null, null);
		PetInfoRequest req = new PetInfoRequest(pet);
		PetInfoResponse res = petService.createPet(req);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	
	@Test
	public void getPetListTest() {
		int findUserId = 9;
		PetInfoListResponse res = petService.getPetList(findUserId);
		System.out.println(res.getRtnCode().getMessage());
		if(res.getPetInfoList() == null) {
			return;
		}
		System.out.println(res.getPetInfoList().size());
		
	}
	
	@Test
	public void updateTest() {
		
		PetInfo pet = new PetInfo("P801", 8, "花花", "三花", "健康", 
				"正常", "", "五個月", "三合一疫苗;狂犬病疫苗", null, 
				false, "貓", null, null, "高雄市");
		PetInfoRequest req = new PetInfoRequest(pet);
		PetInfoResponse res = petService.updatePet(req);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	@Test
	public void deleteTest() {
		PetInfoResponse res = petService.deletePet("P805", 8);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	
	
	// adopt
	
	
	@Test
	public void adoptPetTest() {
		PetInfoResponse res = petService.adoptPet("P5202", 57);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	
	@Test
	public void getAdoptPetListTest() {
		int userId = 4;
		PetInfoListResponse res = petService.getAdoptPetList(userId);
		System.out.println(res.getRtnCode().getMessage());
		System.out.println(res.getPetInfoList().size());
		
	}
	
	@Test
	public void getAdoptablePetListTest() {
		PetInfoListResponse res = petService.getAdoptablePetList(null, null);
		System.out.println(res.getRtnCode().getMessage());
		System.out.println(res.getPetInfoList().size());
	}
	
	
	// adopter quit
	@Test
	public void quitAdoptPetTest() {
		PetInfoResponse res = petService.quitAdoptPet("P5202", 57);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	
	// owner reject
	@Test
	public void rejectAdoptPetTest() {
		PetInfoResponse res = petService.rejectAdoptPet("P5202", 52, 7);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	
	
	// ======================================
	// pet_adoption
	
	
	@Autowired
	private PetAdoptionService petAdoptionService;
	
	@Test
	public void ownerConfirmTest() {
		PetAdoptionResponse res = petAdoptionService.ownerConfirm("P5204", 52, 57);
		System.out.println(res.getRtnCode().getMessage());
	}
	
	@Test
	public void adopterConfirmTest() {
		PetAdoptionResponse res = petAdoptionService.adopterConfirm("P5204", 52, 57, 1);
		System.out.println(res.getRtnCode().getMessage());
	}
	

	
}
