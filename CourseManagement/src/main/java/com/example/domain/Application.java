package com.example.domain;

import java.io.Serializable;

public class Application implements Serializable {

	private String id;
	private String name;
	private String furigana;
	private String mail;
	private String sex;
	private String birthday;
	private String tel;
	private String remarks;
	
	public Application() {
	}

	public Application(String id, String name, String furigana, String mail, String sex, String birthday, String tel,
			String remarks) {
		super();
		this.id = id;
		this.name = name;
		this.furigana = furigana;
		this.mail = mail;
		this.sex = sex;
		this.birthday = birthday;
		this.tel = tel;
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFurigana() {
		return furigana;
	}

	public void setFurigana(String furigana) {
		this.furigana = furigana;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", furigana=" + furigana + ", mail=" + mail + ", sex=" + sex
				+ ", birthday=" + birthday + ", tel=" + tel + ", remarks=" + remarks + "]";
	}
	
	
	
}
