package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.UserInfo;

//@Repository   //¼È®É¤£¥Î
//public interface UserInfoDao extends JpaRepository<UserInfo, UserInfoId> {
//
//}

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

	UserInfo findByAccount(String account);

	UserInfo findByEmail(String email);

}
