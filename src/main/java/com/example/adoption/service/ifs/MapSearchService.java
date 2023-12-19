package com.example.adoption.service.ifs;

import com.example.adoption.vo.MapSearchReq;
import com.example.adoption.vo.MapSearchRes;

public interface MapSearchService {

	public MapSearchRes create(MapSearchReq req);

	public MapSearchRes searchAll();

	public MapSearchRes search(String area, String city, String nature, String animalSpecies, String institutionName);

	public MapSearchRes search1(String area);

}
