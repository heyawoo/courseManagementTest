package com.example.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CourseInfo;
import com.example.domain.CourseSearch;
import com.example.service.AdminService;
import com.example.web.form.SearchCourseForm;

@Controller
public class SearchController {

	@Autowired
	AdminService service;
	
	@ModelAttribute("sform")
	public SearchCourseForm setForm() {
		return new SearchCourseForm();
	}

	@ModelAttribute("cinfo")
	public CourseInfo setForm2() {
		return new CourseInfo();
	}
	
	@RequestMapping("/search")
	public String searchPage() {
		return "admin/adminSearch";
	}
	
	@RequestMapping("/search-list")
	public String searchConf(@ModelAttribute("sform")SearchCourseForm form, Model model, @Param("btn")String btn) {
		
		if (btn != null && !btn.equals("")) {
			form = new SearchCourseForm();
		}
		
		form = nullCheck(form);
		
		ArrayList<CourseSearch> list = service.getList(form);
		model.addAttribute("list", list);
		
		return "admin/adminSearchList";
	}
	
	//================= DELETE =====================
	@RequestMapping("/delete-conf")
	public String deleteConf(@ModelAttribute("cinfo")CourseInfo form) {
		return "admin/adminDeleteConf";
	}
	
	@RequestMapping("/delete-end")
	public String deleteEnd(@ModelAttribute("cinfo")CourseInfo form, @Param("btn")String btn) {
		service.delete(form);
		return "admin/adminDeleteEnd";
	}
	
	//================= MODIFY =====================
	@RequestMapping("/modify")
	public String modify(@ModelAttribute("cinfo")CourseInfo form) {
		return "admin/adminModify";
	}
	
	@RequestMapping("/modify-conf")
	public String modifyConf() {
		return "admin/adminModifyConf";
	}
	
	@RequestMapping("/modify-end")
	public String modifyEnd() {
		return "admin/adminModifyEnd";
	}
	
	
	public SearchCourseForm nullCheck(SearchCourseForm form) {
		
		if (form.getCourseNo() == null) {form.setCourseNo("");}
		if (form.getCourseName() == null) {form.setCourseName("");}
		if (form.getYear() == null) {form.setYear("");}
		if (form.getMonth() == null) {form.setMonth("");}
		if (form.getDay() == null) {form.setDay("");}
		if (form.getStartHour() == null) {form.setStartHour("");}
		if (form.getStartMinute() == null) {form.setStartMinute("");}
		if (form.getEndHour() == null) {form.setEndHour("");}
		if (form.getEndMinute() == null) {form.setEndMinute("");}
		if (form.getStatus() == null) {form.setStatus("");}
		if (form.getCapacity() == null) {form.setCapacity("");}
		
		return form;
	}
	
}
