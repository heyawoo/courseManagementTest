package com.example.domain;

public class UserInfo {

	private String id;
	private String userId;
	private String passwd;
	private String authority;

	public UserInfo() {
	}

	public UserInfo(String id, String userId, String passwd, String authority) {
		super();
		this.id = id;
		this.userId = userId;
		this.passwd = passwd;
		this.authority = authority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userId=" + userId + ", passwd=" + passwd + ", authority=" + authority + "]";
	}
	
}
