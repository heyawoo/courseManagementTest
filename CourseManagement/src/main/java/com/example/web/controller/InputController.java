package com.example.web.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CourseInfo;
import com.example.servise.AdminService;
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
		System.out.println("go input : "+form.toString());
		return "admin/adminInput";
	}

	@RequestMapping("/input-conf")
	public String inputConf(@ModelAttribute("icf") InputCourseForm form, BindingResult result) {
		
		System.out.println("input form conf : "+form.toString());
		
		if (form.getCourseName() == null) {
			result.reject("error.admin.input.aa");
		}
		
		if (result.hasErrors()) {
			return "admin/adminInput";
		}
		
		return "admin/adminInputConf";
	}
	
	@RequestMapping("/input-end")
	public String inputeEnd(InputCourseForm form) {
		CourseInfo info = new CourseInfo();
		
		String thedate = form.getYear()+form.getMonth()+form.getDay();
		String starttime = form.getStarthour()+":"+form.getStartminute();
		String endtime = form.getEndhour()+":"+form.getEndminute();
		
		BeanUtils.copyProperties(form, info);
		info.setTheDate(thedate);
		info.setStartTime(starttime);
		info.setEndTime(endtime);
		System.out.println("insert domain setting : "+info.toString());
		
		return "admin/adminInputEnd";
	}
	

}
