package com.example.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.PetInfo;
import com.example.adoption.service.ifs.PetInfoService;
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
		
		PetInfo pet = new PetInfo(8, "小黑", "米克斯", "健康", 
				"正常", "三個月", "五合一疫苗;狂犬病疫苗", null, 
				true, "貓", null, "台南市");
		PetInfoRequest req = new PetInfoRequest(pet);
		PetInfoResponse res = petService.createPet(req);
		System.out.println(res.getRtnCode().getMessage());
	}
	
}
