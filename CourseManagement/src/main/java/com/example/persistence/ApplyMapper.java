package com.example.persistence;

import java.util.List;

import com.example.domain.Application;
import com.example.domain.CourseApply;
import com.example.domain.CourseInfo;
import com.example.domain.RegistCourseInfo;
import com.example.web.form.InputApplyForm;

public interface ApplyMapper {

	public List<RegistCourseInfo> getApplyList();
	
	public void insertApplication(Application application);
	
	public void insertCourseApply(CourseApply courseApply);
	
	public void delete(String courseNo);
	
}
