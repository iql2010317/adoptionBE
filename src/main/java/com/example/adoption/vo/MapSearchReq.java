package com.example.adoption.vo;

import java.util.List;

import com.example.adoption.entity.MapSearch;

public class MapSearchReq {
	
private List<MapSearch> mapSearchList;
	
	private MapSearch mapSearch;
	
	//area//city//nature//animalSpecies//institutionName//address//business_hours//phone//website//img
	private String area;
	
	private String city;
	
	private String nature;
	
	private String animalSpecies;
	
	private String institutionName;
	
	private String address;
	
	private String businessHours;
	
	private String phone;
	
	private String website;
	
	private String img;

	public MapSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapSearchReq(List<MapSearch> mapSearchList) {
		super();
		this.mapSearchList = mapSearchList;
	}

	public MapSearchReq(MapSearch mapSearch) {
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getAnimalSpecies() {
		return animalSpecies;
	}

	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



}
