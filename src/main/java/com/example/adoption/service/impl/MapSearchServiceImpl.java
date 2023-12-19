package com.example.adoption.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.adoption.entity.MapSearch;
import com.example.adoption.repository.MapSearchDao;
import com.example.adoption.service.ifs.MapSearchService;
import com.example.adoption.vo.MapSearchReq;
import com.example.adoption.vo.MapSearchRes;

import jakarta.persistence.criteria.Predicate;

@Service
public class MapSearchServiceImpl implements MapSearchService {

	@Autowired
	MapSearchDao mapSearchDao;

	@Override
	public MapSearchRes create(MapSearchReq req) {
		MapSearch mapSearch = req.getMapSearch();
		MapSearch saveMapSearch = mapSearchDao.save(mapSearch);
		return new MapSearchRes(saveMapSearch);
	}

	@Override
	public MapSearchRes searchAll() {
		List<MapSearch> mapSearchList = mapSearchDao.findAll();
		return new MapSearchRes(mapSearchList);
	}

	@Override
	public MapSearchRes search(String area, String city, String nature, String animalSpecies, String institutionName) {
		List<MapSearch> mapSearchList;

		Specification<MapSearch> spec = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.hasText(area)) {
				predicates.add(cb.equal(root.get("area"), area));
			}

			if (StringUtils.hasText(city)) {
				predicates.add(cb.equal(root.get("city"), city));
			}

			if (StringUtils.hasText(nature)) {
				predicates.add(cb.equal(root.get("nature"), nature));
			}

			if (StringUtils.hasText(animalSpecies)) {
				predicates.add(cb.equal(root.get("animalSpecies"), animalSpecies));
			}

			if (StringUtils.hasText(institutionName)) {
				predicates.add(cb.like(root.get("institutionName"), "%" + institutionName + "%"));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};

		mapSearchList = mapSearchDao.findAll(spec);

		return new MapSearchRes(mapSearchList);
	}

//	@Override
//	public MapSearchRes search(String area, String city, String nature, String animalSpecies, String institutionName) {
//		area = StringUtils.hasText(area) ? area : "";
//		city = StringUtils.hasText(city) ? city : "";
//		nature = StringUtils.hasText(nature) ? nature : "";
//		animalSpecies = StringUtils.hasText(animalSpecies) ? animalSpecies : "";
//		institutionName = StringUtils.hasText(institutionName) ? institutionName : "";
//		List<MapSearch> mapSearchList = mapSearchDao
//				.findByAreaAndCityAndNatureAndAnimalSpeciesAndInstitutionNameContaining(area, city, nature,
//						animalSpecies, institutionName);// Containing
//		return new MapSearchRes(mapSearchList);
//	}

	@Override
	public MapSearchRes search1(String area) {
		if (area == null) {
			List<MapSearch> allMapSearchList = mapSearchDao.findAll();
			return new MapSearchRes(allMapSearchList);
		} else {
			area = StringUtils.hasText(area) ? area : "";
			List<MapSearch> mapSearchList = mapSearchDao.findByArea(area);
			return new MapSearchRes(mapSearchList);
		}
	}

}
