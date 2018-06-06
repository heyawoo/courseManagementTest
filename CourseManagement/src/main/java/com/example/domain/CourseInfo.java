package com.example.domain;

public class CourseInfo {

	private String courseNo;
	private String courseName;
	private String theDate;
	private String startTime;
	private String endTime;
	private String capacity;
	
	public CourseInfo() {
	}

	public CourseInfo(String courseNo, String courseName, String theDate, String startTime, String endTime,
			String capacity) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.theDate = theDate;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public String getTheDate() {
		return theDate;
	}

	public void setTheDate(String theDate) {
		this.theDate = theDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "CourseInfo [courseNo=" + courseNo + ", courseName=" + courseName + ", theDate=" + theDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", capacity=" + capacity + "]";
	}

	
}
