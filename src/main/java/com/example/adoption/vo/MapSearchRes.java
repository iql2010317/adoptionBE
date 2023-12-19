package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.MapSearch;

public class MapSearchRes {

	private List<MapSearch> mapSearchList;
	
	private MapSearch mapSearch;

	public MapSearchRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapSearchRes(List<MapSearch> mapSearchList) {
		super();
		this.mapSearchList = mapSearchList;
	}

	public MapSearchRes(MapSearch mapSearch) {
		super();
		this.mapSearch = mapSearch;
	}

	public List<MapSearch> getMapSearchList() {
		return mapSearchList;
	}

	public void setMapSearchList(List<MapSearch> mapSearchList) {
		this.mapSearchList = mapSearchList;
	}

	public MapSearch getMapSearch() {
		return mapSearch;
	}

	public void setMapSearch(MapSearch mapSearch) {
		this.mapSearch = mapSearch;
	}
}
