package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adoption.entity.Notification;

import jakarta.annotation.Resource;

@Resource
public interface NotificationDao extends JpaRepository<Notification, Integer>{

}
