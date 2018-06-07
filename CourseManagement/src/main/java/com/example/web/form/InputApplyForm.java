package com.example.web.form;

import java.util.Arrays;

public class InputApplyForm {

	private String name;
	private String furigana;
	private String mail;
	private String sex;
	private String year;
	private String month;
	private String day;
	private String tel;
	private String[] applied;
	private String remarks;
	
	public InputApplyForm() {
	}

	public InputApplyForm(String name, String furigana, String mail, String sex, String year, String month, String day,
			String tel, String[] applied, String remarks) {
		super();
		this.name = name;
		this.furigana = furigana;
		this.mail = mail;
		this.sex = sex;
		this.year = year;
		this.month = month;
		this.day = day;
		this.tel = tel;
		this.applied = applied;
		this.remarks = remarks;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String[] getApplied() {
		return applied;
	}

	public void setApplied(String[] applied) {
		this.applied = applied;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "InputApplyForm [name=" + name + ", furigana=" + furigana + ", mail=" + mail + ", sex=" + sex + ", year="
				+ year + ", month=" + month + ", day=" + day + ", tel=" + tel + ", applied=" + Arrays.toString(applied)
				+ ", remarks=" + remarks + "]";
	}
	
	
	
}
