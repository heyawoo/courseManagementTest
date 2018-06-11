package com.example.web.form;

public class SearchCourseForm {

	private String courseNo;
	private String courseName;
	private String year;
	private String month;
	private String day;
	private String startHour;
	private String startMinute;
	private String endHour;
	private String endMinute;
	private String capacity;
	private String status;
	
	public SearchCourseForm() {
	}

	public SearchCourseForm(String courseNo, String courseName, String year, String month, String day, String startHour,
			String startMinute, String endHour, String endMinute, String capacity, String status) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.year = year;
		this.month = month;
		this.day = day;
		this.startHour = startHour;
		this.startMinute = startMinute;
		this.endHour = endHour;
		this.endMinute = endMinute;
		this.capacity = capacity;
		this.status = status;
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

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(String startMinute) {
		this.startMinute = startMinute;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SearchCourseForm [courseNo=" + courseNo + ", courseName=" + courseName + ", year=" + year + ", month="
				+ month + ", day=" + day + ", startHour=" + startHour + ", startMinute=" + startMinute + ", endHour="
				+ endHour + ", endMinute=" + endMinute + ", capacity=" + capacity + ", status=" + status + "]";
	}

}
