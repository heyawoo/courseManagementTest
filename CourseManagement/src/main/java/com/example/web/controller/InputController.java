package com.example.web.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CourseInfo;
import com.example.service.AdminService;
import com.example.web.form.InputCourseForm;

@Controller
public class InputController {

	@Autowired
	AdminService service;
	
	@ModelAttribute("icf")
	public InputCourseForm setForm() {
		return new InputCourseForm();
	}
	
	@RequestMapping("/input")
	public String inputPage(InputCourseForm form) {
		return "admin/adminInput";
	}

	@RequestMapping("/input-conf")
	public String inputConf(@Validated @ModelAttribute("icf") InputCourseForm form, BindingResult result) {
		
		// validation self check
		result = validate(form, result);
		
		// errorがある場合
		if (result.hasErrors()) {
			return "admin/adminInput";
		}
		
		// errorがない場合
		return "admin/adminInputConf";
	}
	
	@RequestMapping("/input-end")
	public String inputeEnd(InputCourseForm form) {
		// 新しいdomain object 生成
		CourseInfo info = new CourseInfo();
		// 値setting
		String thedate = form.getYear()+form.getMonth()+form.getDay();
		String starttime = form.getStarthour()+":"+form.getStartminute();
		String endtime = form.getEndhour()+":"+form.getEndminute();
		//　field　copy
		BeanUtils.copyProperties(form, info);
		info.setTheDate(thedate);
		info.setStartTime(starttime);
		info.setEndTime(endtime);
		
		// DB 登録
		service.inputCourse(info);
		
		return "admin/adminInputEnd";
	}
	
	// self validation method
	public BindingResult validate(InputCourseForm form, BindingResult result) {
		String startTime = "";
		String endTime = "";
		
		// no check
		if (!form.getCourseNo().isEmpty()) {
			if (service.noCheck(form.getCourseNo())) {
				result.reject("error.admin.input.no.exist");
			}
		}
		
		// the date
		if (form.getYear().isEmpty()||form.getMonth().isEmpty()||form.getDay().isEmpty()) {
			result.reject("error.admin.input.thedate.required");
		}
		
		// start time
		if (form.getStarthour().isEmpty()||form.getStartminute().isEmpty()) {
			result.reject("error.admin.input.starttime.required");
		} else {
			startTime = form.getStarthour()+":"+form.getStartminute();
		}
		
		// end time
		if (form.getEndhour().isEmpty()||form.getEndminute().isEmpty()) {
			result.reject("error.admin.input.endtime.required");
		} else {
			endTime = form.getEndhour()+":"+form.getEndminute();
		}
		
		// time compare
		if (!startTime.isEmpty()&&!endTime.isEmpty()) {
			SimpleDateFormat simple = new SimpleDateFormat("HH:mm");
			try {
				Date start = simple.parse(startTime);
				Date end = simple.parse(endTime);
				if (start.compareTo(end) >= 0) {
					result.reject("error.admin.input.time.irony");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	

}
