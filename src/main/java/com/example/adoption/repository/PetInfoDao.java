package com.example.adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.adoption.entity.PetInfo;


@Repository
public interface PetInfoDao extends JpaRepository<PetInfo, String>{
	
	// 找到該user的pet最後一個id
	public PetInfo findTopByUserIdOrderByPetIdDesc(int userId);

	public List<PetInfo> findAllByUserId(int userId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE PetInfo AS pet SET"
			+ " petName = CASE WHEN :petName is null THEN pet.petName ELSE :petName END,"
			+ " petBreed = CASE WHEN :petBreed is null THEN pet.petBreed ELSE :petBreed END,"
			+ " petStatus = CASE WHEN :petStatus is null THEN pet.petStatus ELSE :petStatus END,"
			+ " adoptionStatus = CASE WHEN :adoptionStatus is null THEN pet.adoptionStatus ELSE :adoptionStatus END,"
			+ " age = CASE WHEN :age is null THEN pet.age ELSE :age END,"
			+ " vaccine = CASE WHEN :vaccine is null THEN pet.vaccine ELSE :vaccine END,"
			+ " petProfile = CASE WHEN :petProfile is null THEN pet.petProfile ELSE :petProfile END,"
			+ " ligation = CASE WHEN :ligation is null THEN pet.ligation ELSE :ligation END,"
			+ " type = CASE WHEN :type is null THEN pet.type ELSE :type END,"
			+ " petPhoto = CASE WHEN :petPhoto is null THEN pet.petPhoto ELSE :petPhoto END,"
			+ " location = CASE WHEN :location is null THEN pet.location ELSE :location END"
			+ " WHERE pet.petId = :petId")
	public int updateInfo(
			@Param("petId")String petId,
			@Param("petName")String petName, 
			@Param("petBreed")String petBreed, 
			@Param("petStatus")String petStatus, 
			@Param("adoptionStatus")String adoptionStatus, 
			@Param("age")String age,
			@Param("vaccine")String vaccine, 
			@Param("petProfile")String petProfile, 
			@Param("ligation")boolean ligation, 
			@Param("type")String type, 
			@Param("petPhoto")String petPhoto, 
			@Param("location")String location);
	
}
