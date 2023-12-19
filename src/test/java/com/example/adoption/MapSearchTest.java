package com.example.adoption;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.MapSearch;
import com.example.adoption.service.ifs.MapSearchService;
import com.example.adoption.vo.MapSearchReq;
import com.example.adoption.vo.MapSearchRes;

@SpringBootTest
public class MapSearchTest {

	@Autowired
	MapSearchService mapSearchService;

	@Test
	public void create() {
		MapSearch mapSearch = new MapSearch();
		mapSearch.setArea("南部");
		mapSearch.setCity("台南市");
		mapSearch.setNature("私人");
		mapSearch.setAnimalSpecies("狗");
		mapSearch.setInstitutionName("徐文良(徐園長護生園)");
		mapSearch.setAddress("台南市將軍區西湖112號");
		mapSearch.setBusinessHours("12:00–17:00 ，周一到周五公休");
		mapSearch.setPhone("0989 546 228");
		mapSearch.setWebsite("https://hapatc.org.tw/?fbclid=IwAR3C_Nsti_a18XJP4JaBU4JXgJWWIW4aG-CCEvFagiCn6NwMEQ3R93nOMMs");
//		mapSearch.setImg(null);
		MapSearchRes res = mapSearchService.create(new MapSearchReq(mapSearch));

	}

	@Test
	public void searchAll() {
		MapSearchRes res = mapSearchService.searchAll();
		List<MapSearch> mapSearchList = res.getMapSearchList();
		for (MapSearch mapSearch : mapSearchList) {
			System.out.println(mapSearch.getArea());
			System.out.println(mapSearch.getCity());
			System.out.println(mapSearch.getNature());
			System.out.println(mapSearch.getAnimalSpecies());
			System.out.println(mapSearch.getInstitutionName());
			System.out.println("===================================");
		}
	}

	@Test
	public void search() {
		MapSearchRes res = mapSearchService.search(null, null, null, null, "園");
		List<MapSearch> mapSearchList = res.getMapSearchList();
		for (MapSearch mapSearch : mapSearchList) {
			System.out.println(mapSearch.getArea());
			System.out.println(mapSearch.getCity());
			System.out.println(mapSearch.getNature());
			System.out.println(mapSearch.getAnimalSpecies());
			System.out.println(mapSearch.getInstitutionName());
			System.out.println("=====================================================");
		}
		System.out.println(mapSearchList.size());
	}

}
