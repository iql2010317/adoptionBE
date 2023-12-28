package com.example.adoption.constants;

public enum RtnCode {

	
	/* 列舉：呼叫的項目(code, message)*/ // 每句後面加上"//"是為了格式刷新時前後兩句不連接
	SUCCESSFUL(200, "Successful!!"), //
	PARAM_ERROR(400, "Param eroor!!"), //
	ID_HAS_EXISTED(400, "Id has existed!!"), //
	ID_NOT_FOUND(404, "Id not found!!"), //
	PASSWORD_ERROR(400, "Password error!!"), //
	DEPARTMENT_NOT_FOUND(404, "Department not found!!"), //
	PLEASE_LOGIN_FIRST(400, "Please login firse!!"), //
	CHANGE_PASSWORD_ERROR(400, "Change password error!!"),
	FORGOT_PASSWORD_ERROR(400, "Forgot password error!!"),//
	OLD_PASSWORD_AND_NEW_PASSWORD_ARE_IDENTICAL(400, "Old password and newpassword are identical!!"), //
	AUTH_CODE_NOT_MATCHED(400, "Auth code not matched!!"), //
	AUTH_CODE_EXPIRED(400, "Auth code expired!!"), //
	UPDATE_FAILED(400, "Update failed!!"), //
	UPDATE_ERROR(400, "DB error!!"),//
	ACCOUNT_DEACTIVATE(400, "Account deactivate!!"), //
	SAVE_DB_ERROR(400, "Save DB error!!"), //
	THE_PET_CANNOT_BE_ADOPTED(400, "The pet cannot be adopted!!"), //
	ADOPT_ERROR(400, "Adopt error!!"), //
	NOT_FOUND(404, "Not found!!"), //
	THE_ADOPTER_IS_NOT_IN_THE_LIST(400, "The adopter is not in the list!!"), //
	THE_USER_HAS_ALREADY_ADOPTED_THE_PET(400, "The user has already adopted the pet!!"), //
	REJECT_ERROR(400, "Reject error!!"),//
	DATA_NOT_FOUNT(404,"Data not fount!!"), //
	CAN_ONLY_CHOOSE_ONE_ADOPTER(400, "Can only choose one adopter!!"), //
	INSUFFICIENT_PERMISSIONS(400, "Insufficient permissions!");

	


	/* 宣告兩項（必做） */
	private int code; // 一開始建立時會報錯，是因為上面沒有列舉
	
	private String message;

	
	/* constructor */
	// 無法建立預設建構方法，只建立建構方法即可
	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}


	/* getter */
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
