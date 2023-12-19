package com.example.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adoption.service.ifs.MapSearchService;
import com.example.adoption.vo.MapSearchRes;

@RestController
@CrossOrigin
public class MapSearchController {

	@Autowired
	MapSearchService mapSearchService;

	// String area, String city, String nature, String animalSpecies, String
	// institutionName
	@GetMapping(value = "api/adoption/search")
	public MapSearchRes search(//
			@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "nature", required = false) String nature,
			@RequestParam(name = "animalSpecies", required = false) String animalSpecies,
			@RequestParam(name = "institutionName", required = false) String institutionName) {
		return mapSearchService.search(area, city, nature, animalSpecies, institutionName);

	}

}
