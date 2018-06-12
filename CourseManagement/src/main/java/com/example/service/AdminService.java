package com.example.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CourseInfo;
import com.example.domain.CourseSearch;
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
	
	public ArrayList<CourseSearch> getList(SearchCourseForm sform){
		
		ArrayList<CourseSearch> list = new ArrayList<>();
		List<CourseInfo> slist = mapper.getList(sform);

		try {
			
			for (CourseInfo c : slist) {
				CourseSearch cs = new CourseSearch();
				BeanUtils.copyProperties(c, cs);
				// date処理
				SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:ss");
				Date present = simple.parse(simple.format(new Date()));
				Date start = simple.parse(c.getTheDate()+" "+c.getStartTime());
				Date end = simple.parse(c.getTheDate()+" "+c.getEndTime());
				
				int n = present.compareTo(start);
				int m = present.compareTo(end);
				
				if (n < 0) {
					cs.setStatus("開催予定");
				}
				if (n >= 0 && m <= 0) {
					cs.setStatus("開催中");
				}
				if (m > 0) {
					cs.setStatus("終了");
				}
				simple = new SimpleDateFormat("(E)");
				cs.setWeekday(simple.format(start));
				
				list.add(cs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Transactional
	public void delete(CourseInfo courseInfo) {
		mapper.deleteApply(courseInfo.getCourseNo());
		mapper.deleteCourse(courseInfo.getCourseNo());
	}
}
