package com.example.adoption.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.NewInfo;
import com.example.adoption.repository.NewInfoDao;
import com.example.adoption.service.ifs.NewInfoService;
import com.example.adoption.vo.NewInfoRequest;
import com.example.adoption.vo.NewInfoResponse;

@Service
public class NewInfoServiceImpl implements NewInfoService {

	@Autowired
	private NewInfoDao newInfoDao;

	@Override
	public NewInfoResponse create(NewInfoRequest req) {
		NewInfo newInfo = req.getNewInfo();

		byte[] base64Image = newInfo.getImage(); 

		newInfo.setImage(base64Image);

		NewInfo savedNewInfo = newInfoDao.save(newInfo);

		return new NewInfoResponse(savedNewInfo);

	}

	@Override
	public NewInfoResponse search() {
		List<NewInfo> List = newInfoDao.findAll();
		return new NewInfoResponse(List);
	}

}
