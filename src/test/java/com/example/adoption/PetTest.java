package com.example.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.PetInfo;
import com.example.adoption.service.ifs.PetInfoService;
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
		
		PetInfo pet = new PetInfo(8, "小花", "三花", "健康", 
				"正常", "五個月", "三合一疫苗;狂犬病疫苗", null, 
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
	
}
