package com.example.persistence;

import java.util.List;

import com.example.domain.Application;
import com.example.domain.RegistCourseInfo;

public interface ApplyMapper {

	public List<RegistCourseInfo> getApplyList();
	
	public void insertApplication(Application application);
	
	public void insertApplyInfo(Application application);
	
	
}
