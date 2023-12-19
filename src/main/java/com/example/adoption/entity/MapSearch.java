package com.example.adoption.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "map_search")
public class MapSearch {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "serial_no")
	private int serialNo;

	@Column(name = "area")
	private String area;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "nature")
	private String nature;
	
	@Column(name = "animal_species")
	private String animalSpecies;
	
	@Column(name = "institution_name")
	private String institutionName;
	
	//address//business_hours//phone//website//img
	@Column(name = "address")
	private String address;
	
	@Column(name = "business_hours")
	private String businessHours;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "img")
	private String img;

	public MapSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapSearch(String area, String city, String nature, String animalSpecies, String institutionName,
			String address, String businessHours, String phone, String website, String img) {
		super();
		this.area = area;
		this.city = city;
		this.nature = nature;
		this.animalSpecies = animalSpecies;
		this.institutionName = institutionName;
		this.address = address;
		this.businessHours = businessHours;
		this.phone = phone;
		this.website = website;
		this.img = img;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
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
