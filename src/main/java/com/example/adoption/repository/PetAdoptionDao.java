package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.adoption.entity.PetAdoption;


@Repository
public interface PetAdoptionDao extends JpaRepository<PetAdoption, Integer>{

	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE PetAdoption AS pet SET"
			+ " ownerConfirm = CASE WHEN :ownerConfirm is null THEN pet.ownerConfirm ELSE :ownerConfirm END,"
			+ " adopterConfirm = CASE WHEN :adopterConfirm is null THEN pet.adopterConfirm ELSE :adopterConfirm END"
			+ " WHERE pet.serialNo = :serialNo")
	public int updateAdoptionConfirm(
			@Param("serialNo")int serialNo,
			@Param("ownerConfirm")int ownerConfirm,
			@Param("adopterConfirm")int adopterConfirm);
	
	
	public PetAdoption findByPetIdAndOwnerIdAndAdopterId(String petId, int ownerId, int adopterId);
}
