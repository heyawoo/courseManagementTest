package com.example.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.CourseInfo;
import com.example.domain.RegistCourseInfo;
import com.example.persistence.ApplyMapper;

@Service
public class UserService {

	@Autowired
	ApplyMapper mapper;
	
	@Transactional
	public List<RegistCourseInfo> getList() {
		
		List<RegistCourseInfo> list = mapper.getApplyList();
		try {
			for (RegistCourseInfo c : list) {
				SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd", Locale.JAPAN);
				String weekday = simple.format(simple.parse(c.getThedate()));
				Date date = simple.parse(weekday);
				simple = new SimpleDateFormat("E");
				weekday = simple.format(date);
				c.setWeekday("("+weekday+")");
				
				String[] dates = c.getThedate().split("-");
				c.setThedate(dates[0]+"年"+dates[1]+"月"+dates[2]+"日");

				if (Integer.parseInt(c.getExtra())==0) {
					c.setExtra("満席");
				}else {
					c.setExtra("残"+c.getExtra()+"席");
				}
				
				System.out.println("get List : "+c.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
