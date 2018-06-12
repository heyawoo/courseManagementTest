package com.example.persistence;

import java.util.List;

import com.example.domain.Application;
import com.example.domain.CourseApply;
import com.example.domain.CourseInfo;
import com.example.domain.RegistCourseInfo;
import com.example.domain.UserInfo;
import com.example.web.form.InputApplyForm;
import com.example.web.form.UserForm;

public interface ApplyMapper {

	public List<RegistCourseInfo> getApplyList();
	
	public void insertApplication(Application application);
	
	public void insertCourseApply(CourseApply courseApply);
	
	public void delete(String courseNo);
	
	public UserInfo loginCheck(UserForm userForm);
	
	public String idCheck(UserForm userForm);
	
	public void insertUser(UserForm userForm);
}
