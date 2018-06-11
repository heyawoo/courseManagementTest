package com.example.domain;

import java.util.Arrays;

public class CourseApply {

	private String id;
	private String idApplication;
	private String[] courseNo;
	
	public CourseApply() {
	}

	public CourseApply(String id, String idApplication, String[] courseNo) {
		super();
		this.id = id;
		this.idApplication = idApplication;
		this.courseNo = courseNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdApplication() {
		return idApplication;
	}

	public void setIdApplication(String idApplication) {
		this.idApplication = idApplication;
	}

	public String[] getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String[] courseNo) {
		this.courseNo = courseNo;
	}

	@Override
	public String toString() {
		return "CourseApply [id=" + id + ", idApplication=" + idApplication + ", courseNo=" + Arrays.toString(courseNo)
				+ "]";
	}

	
	
	
}
