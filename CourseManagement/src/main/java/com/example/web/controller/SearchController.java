package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CourseInfo;
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
	
	@RequestMapping("/search")
	public String searchPage() {
		return "admin/adminSearch";
	}
	
	@RequestMapping("/search-list")
	public String searchConf(@ModelAttribute("sform")SearchCourseForm form, Model model) {
		
		List<CourseInfo> list = service.getList(form);
		model.addAttribute("list", list);
		
		return "admin/adminSearchList";
	}
	
	//================= DELETE =====================
	@RequestMapping("/delete")
	public String delete() {
		return "admin/adminDeleteConf";
	}
	
	@RequestMapping("/delete-end")
	public String deleteEnd() {
		return "admin/adminDeleteEnd";
	}
	
	//================= MODIFY =====================
	@RequestMapping("/modify")
	public String modify() {
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
}
