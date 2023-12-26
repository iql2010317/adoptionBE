package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.ForumEntrance;

@Repository
public interface ForumEntranceDao extends JpaRepository<ForumEntrance, Integer> {

}
