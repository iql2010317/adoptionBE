package com.example.adoption.service.ifs;

import com.example.adoption.vo.NewInfoRequest;
import com.example.adoption.vo.NewInfoResponse;

public interface NewInfoService {

	public NewInfoResponse create(NewInfoRequest req);
	
	public NewInfoResponse search();

}
