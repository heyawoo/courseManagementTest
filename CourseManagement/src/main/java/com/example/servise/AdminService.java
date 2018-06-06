package com.example.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CourseInfo;
import com.example.persistence.CourseInfoMapper;

@Service
public class AdminService {

	@Autowired
	CourseInfoMapper mapper;
	
	@Transactional
	public void inputCourse(CourseInfo info) {
		mapper.insert(info);
	}
}
