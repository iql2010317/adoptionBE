package com.example.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.adoption.entity.UserInfo;

//@Repository   //�Ȯɤ���
//public interface UserInfoDao extends JpaRepository<UserInfo, UserInfoId> {
//
//}

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {

	UserInfo findByAccount(String account);

	UserInfo findByEmail(String email);
	
	@Query(value = "SELECT * FROM user_info u WHERE u.user_id = :userId", nativeQuery = true)
	public UserInfo selectByUserId(@Param("userId")int userId);

	UserInfo findByUserId(int userId);

}
