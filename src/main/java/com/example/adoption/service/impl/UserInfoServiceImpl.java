package com.example.adoption.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public UserInfoResponse create(UserInfoRequest req) {
		UserInfo userInfo = req.getUserInfo();

		// �B�z �K�X�[�K�޿�
		// �p�Guser���K�X������ �h�[�K
		if (userInfo.getPassword() != null && !userInfo.getPassword().isEmpty()) {
			String encryptedPassword = encoder.encode(userInfo.getPassword());
			userInfo.setPassword(encryptedPassword); // �N�[�K�᪺�K�X�]�w�^UserInfo����
		}

		///// �B�zaccount�޿� �p�G�ϥΪ̨S���]�waccount �h�Q��mail@�e���r���account
		if (userInfo.getAccount() == null || userInfo.getAccount().isEmpty()) {
			String email = userInfo.getEmail();
			String[] emailParts = email.split("@");
			userInfo.setAccount(emailParts[0]); // �ϥ� @ ���e���r��@���b��
		}

		UserInfo saveduserInfo = userInfoDao.save(userInfo);
		return new UserInfoResponse(saveduserInfo);
	}

	@Override
	public UserInfoResponse search() {
		return new UserInfoResponse(userInfoDao.findAll());
	}

	@Override
	public boolean userLogin(String account, String password) {
		
		System.out.println(account);
		System.out.println(password);
		UserInfo userInfo = userInfoDao.findByAccount(account);

		// �䤣��b�� �n�J����
		if (userInfo == null) {
			return false;
		}
		// �K�X���~ �n�J����

		if (!encoder.matches(password, userInfo.getPassword())) {
			return false;
		}

		return true;
	}

	@Override
	public UserInfoResponse update(UserInfoRequest req) {
		UserInfo userInfo = req.getUserInfo();

		Optional<UserInfo> existingUserInfoOptional = userInfoDao.findById(userInfo.getUserId());

		if (existingUserInfoOptional.isPresent()) {
			UserInfo existingUserInfo = existingUserInfoOptional.get();

			////
			if (userInfo.getUserName() != null) {
				existingUserInfo.setUserName(userInfo.getUserName());
			}

			///
			if (userInfo.getAccount() != null) {
				existingUserInfo.setAccount(userInfo.getAccount());
			}

			if (userInfo.getAddress() != null) {
				existingUserInfo.setAddress(userInfo.getAddress());
			}
			if (userInfo.getAge() > 0) {
				existingUserInfo.setAge(userInfo.getAge());
			}
			if (userInfo.getBirthday() != null) {
				existingUserInfo.setBirthday(userInfo.getBirthday());
			}

			if (userInfo.getEmail() != null) {
				existingUserInfo.setEmail(userInfo.getEmail());
			}

			if (userInfo.getFamilyStatus() != null) {
				existingUserInfo.setFamilyStatus(userInfo.getFamilyStatus());
			}

			if (userInfo.getGender() != null) {
				existingUserInfo.setGender(userInfo.getGender());
			}
			if (userInfo.getJobOccupation() != null) {
				existingUserInfo.setJobOccupation(userInfo.getJobOccupation());
			}

			///
			if (userInfo.getPhone() != null) {
				existingUserInfo.setPhone(userInfo.getPhone());
			}

			if (userInfo.getProfile() != null) {
				existingUserInfo.setProfile(userInfo.getProfile());
			}
			if (userInfo.getSentenceToAdopter() != null) {
				existingUserInfo.setSentenceToAdopter(userInfo.getSentenceToAdopter());
			}

			if (userInfo.getUserRealName() != null) {
				existingUserInfo.setUserRealName(userInfo.getUserRealName());
			}

			String base64Photo = userInfo.getUserPhoto();

			if (base64Photo != null && !base64Photo.isEmpty()) {
				// ���r������m
				int commaIndex = base64Photo.indexOf(',');
				if (commaIndex != -1) {
					// �I���r���᪺����
					String base64Image = base64Photo.substring(commaIndex + 1);

					try {
						byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

						String timestamp = String.valueOf(System.currentTimeMillis());
						String imageName = "image_" + timestamp + ".jpg";
						String imagePath = "C:/Users/iql20/OneDrive/�ୱ/htmlfile/2023-12-25/public/" + imageName;

						FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
						fileOutputStream.write(decodedBytes);
						fileOutputStream.close();

						// �N�ɮ׸��|�]�m�� userInfo ��
						existingUserInfo.setUserPhoto(imagePath);
					} catch (IOException e) {
						// �B�z�ҥ~
						e.printStackTrace();
					}
				}
			}

			// �x�s��s�᪺���
			UserInfo savedUserInfo = userInfoDao.save(existingUserInfo);
			return new UserInfoResponse(savedUserInfo);
		} else {
			// �䤣��n��s�����
			return new UserInfoResponse(); // �Ϊ̾A�����~�B�z
		}
	}

//	@Override
//	public UserInfoResponse update(UserInfoRequest req) {
//		UserInfo userInfo = req.getUserInfo();
//
//
//		String base64Photo = userInfo.getUserPhoto();
//		if (base64Photo != null && !base64Photo.isEmpty()) {
//			// ���r������m
//			int commaIndex = base64Photo.indexOf(',');
//			if (commaIndex != -1) {
//				// �I���r���᪺����
//				String base64Image = base64Photo.substring(commaIndex + 1);
//
//				try {
//					byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
//
//					String timestamp = String.valueOf(System.currentTimeMillis());
//					String imageName = "image_" + timestamp + ".jpg";
//					String imagePath = "C:/Users/iql20/OneDrive/�ୱ/pic/" + imageName;
//
//					FileOutputStream fileOutputStream = new FileOutputStream(imagePath);
//					fileOutputStream.write(decodedBytes);
//					fileOutputStream.close();
//
//					// �N�ɮ׸��|�]�m�� userInfo ��
//					userInfo.setUserPhoto(imagePath);
//				} catch (IOException e) {
//					// �B�z�ҥ~
//					e.printStackTrace();
//				}
//			}
//		}
//
//		UserInfo saveduserInfo = userInfoDao.save(userInfo);
//		return new UserInfoResponse(saveduserInfo);
//	}

	// �ˬd�K�X�O�_����諸���U��k
	private boolean isPasswordChanged(UserInfo newUserInfo, UserInfo originalUserInfo) {
		// �ˬd�K�X�O�_�ۦP
		return newUserInfo.getPassword() != null && !newUserInfo.getPassword().isEmpty()
				&& !encoder.matches(newUserInfo.getPassword(), originalUserInfo.getPassword());

	}
}
