package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CourseInfo;
import com.example.persistence.CourseInfoMapper;
import com.example.web.form.SearchCourseForm;

@Service
public class AdminService {

	@Autowired
	CourseInfoMapper mapper;
	
	@Transactional
	public void inputCourse(CourseInfo info) {
		mapper.insert(info);
	}
	
	public Boolean noCheck(String courseNo) {
		Boolean result = false;
		CourseInfo check = mapper.nocheck(courseNo);
		
		if (check != null && check.getCourseNo() != null) {
			result = true;
		}
		
		return result;
	}
	
	@Transactional
	public List<CourseInfo> getList(SearchCourseForm sform){
		List<CourseInfo> list = mapper.getList(sform);
		
		return list;
	}
}
