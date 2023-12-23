package com.example.adoption.service.ifs;

import java.util.List;

import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

public interface UserInfoService {

	// sg
	public UserInfoResponse create(UserInfoRequest req);
	
	public UserInfoResponse createFakeUser(UserInfoRequest req);

	// ���U�޿� +�[�J���{�ҽX
	public UserInfoResponse compareAuthenticationCode(UserInfoRequest req);

	// ����H���C��j�M (for admin
	public UserInfoResponse search();
	
	// for pet search user
	public UserInfoResponse searchById(int userId);
	
	// for pet info check the adopters
	public UserInfoResponse getAdoptersInfo(String idList);

	// �n�J�޿� (for user or admin
	public String userLogin(String email, String password);

	// ��s�޿� (for user or admin
	public UserInfoResponse update(UserInfoRequest req);

	// �Τ� �ѰO�K�X
	public String userFogetPassword(String email);

	// ���U�Τ� �o�e�{�ҽX
	public String sendAuthenticationCode(String email);

	// �w���U�Τ� �ѰO�K�X 
	//�ϥ�6���H���X�n�J�� �j����K�X
	public String forceChangePassword(String email, String newPassword, String confirmPassword);
	

}
