package com.example.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.example.domain.CourseInfo;
import com.example.web.form.SearchCourseForm;

public interface CourseInfoMapper {
	
	public void insert(CourseInfo info);
	
	public void deleteApply(String courseNo);
	
	public void deleteCourse(String courseNo);
	
	public void update(CourseInfo info);
	
	public List<CourseInfo> search();
	
	public CourseInfo nocheck(@Param("courseNo") String courseNo);
	
	public List<CourseInfo> getList(SearchCourseForm sform);
	
}
