package com.example.web.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class InputCourseForm {

	@NotEmpty
	private String courseNo;
	@NotEmpty
	private String courseName;
	private String year;
	private String month;
	private String day;
	private String starthour;
	private String startminute;
	private String endhour;
	private String endminute;
	@NotEmpty
	@Digits(fraction = 0, integer = 11, message="{error.admin.input.capacity.parse}")
	@Range(min=1, max=50, message="{error.admin.input.capacity.range}")
	private String capacity;
	
	public InputCourseForm() {
	}

	public InputCourseForm(String courseNo, String courseName, String year, String month, String day, String starthour,
			String startminute, String endhour, String endminute, String capacity) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.year = year;
		this.month = month;
		this.day = day;
		this.starthour = starthour;
		this.startminute = startminute;
		this.endhour = endhour;
		this.endminute = endminute;
		this.capacity = capacity;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getStarthour() {
		return starthour;
	}

	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}

	public String getStartminute() {
		return startminute;
	}

	public void setStartminute(String startminute) {
		this.startminute = startminute;
	}

	public String getEndhour() {
		return endhour;
	}

	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}

	public String getEndminute() {
		return endminute;
	}

	public void setEndminute(String endminute) {
		this.endminute = endminute;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "InputCourseForm [courseNo=" + courseNo + ", courseName=" + courseName + ", year=" + year + ", month="
				+ month + ", day=" + day + ", starthour=" + starthour + ", startminute=" + startminute + ", endhour="
				+ endhour + ", endminute=" + endminute + ", capacity=" + capacity + "]";
	}


}
