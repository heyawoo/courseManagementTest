package com.example.web.form;

import javax.validation.constraints.NotEmpty;

public class UserForm {

	@NotEmpty(message="{error.user.login.id.pw.required}")
	private String userId;
	@NotEmpty(message="{error.user.login.id.pw.required}")
	private String passwd;
	private String passwd2;
	
	public UserForm() {
	}

	public UserForm(String userId, String passwd, String passwd2) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.passwd2 = passwd2;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd2() {
		return passwd2;
	}

	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}

	@Override
	public String toString() {
		return "UserForm [userId=" + userId + ", passwd=" + passwd + ", passwd2=" + passwd2 + "]";
	}
	
	
	
}
