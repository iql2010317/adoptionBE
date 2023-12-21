package com.example.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.adoption.entity.NewInfo;
import com.example.adoption.repository.NewInfoDao;

@SpringBootApplication
public class NewInfoTest {

	@Autowired
	 private NewInfoDao newInfoDao;
	
	@Test
	public void test() {

		this.newInfoDao.update("55555555555555", null, null, null, "我不要我要更新再更新");
	
	}
}
