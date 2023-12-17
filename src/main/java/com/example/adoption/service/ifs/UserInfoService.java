package com.example.adoption.service.ifs;

import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

public interface UserInfoService {

	// ���U�޿� (for user or admin
	public UserInfoResponse create(UserInfoRequest req);

	// ���U�޿� +�[�J���{�ҽX
	public UserInfoResponse compareAuthenticationCode(UserInfoRequest req);

	// ����H���C��j�M (for admin
	public UserInfoResponse search();

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
