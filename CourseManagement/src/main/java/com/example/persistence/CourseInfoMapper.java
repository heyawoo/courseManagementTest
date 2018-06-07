package com.example.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.example.domain.CourseInfo;

public interface CourseInfoMapper {
	
	public void insert(CourseInfo info);
	
	public void delete(String no);
	
	public void update(CourseInfo info);
	
	public List<CourseInfo> search();
	
	public CourseInfo nocheck(@Param("courseNo") String courseNo);
	
}
