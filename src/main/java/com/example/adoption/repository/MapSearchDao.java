package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.MapSearch;

@Repository

public interface MapSearchDao extends JpaRepository<MapSearch, String>, JpaSpecificationExecutor<MapSearch> {
//public interface MapSearchDao extends JpaRepository<MapSearch,String>{

	public List<MapSearch> findByArea(String area);

	public List<MapSearch> findByCity(String city);

	public List<MapSearch> findByNature(String nature);

	public List<MapSearch> findByAnimalSpecies(String animalSpecies);

	public List<MapSearch> findByInstitutionNameContaining(String institutionName);

	public List<MapSearch> findByAreaAndCityAndNatureAndAnimalSpeciesAndInstitutionNameContaining(String area,
			String city, String nature, String animalSpecies, String institutionName);

}
