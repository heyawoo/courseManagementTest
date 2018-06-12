package com.example.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.CourseInfo;
import com.example.domain.CourseSearch;
import com.example.service.AdminService;
import com.example.web.form.InputCourseForm;
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
	public String deleteEnd(@ModelAttribute("cinfo")CourseInfo form) {
		service.delete(form);
		return "admin/adminDeleteEnd";
	}
	
	//================= MODIFY =====================
	@RequestMapping("/modify")
	public String modify(@ModelAttribute("cinfo")CourseInfo form, @ModelAttribute("icf") InputCourseForm icf, Model model) {
		
		if (form.getTheDate() != null) {
			String[] dates = form.getTheDate().split("-");
			icf.setYear(dates[0]);
			icf.setMonth(dates[1]);
			icf.setDay(dates[2]);
			
			String[] start = form.getStartTime().split(":");
			icf.setStarthour(start[0]);
			icf.setStartminute(start[1]);
			
			String[] ends = form.getEndTime().split(":");
			icf.setEndhour(ends[0]);
			icf.setEndminute(ends[1]);
		}
		
		model.addAttribute("icf", icf);
		
		return "admin/adminModify";
	}
	
	@RequestMapping("/modify-conf")
	public String modifyConf(@Validated @ModelAttribute("icf") InputCourseForm icf, BindingResult result) {
			
		// validation self check
		result = validate(icf, result);
		
		// errorがある場合
		if (result.hasErrors()) {
			return "admin/adminModify";
		}

		return "admin/adminModifyConf";
	}
	
	@RequestMapping("/modify-end")
	public String modifyEnd(@ModelAttribute("icf") InputCourseForm icf, @ModelAttribute("cinfo")CourseInfo info) {
		
		BeanUtils.copyProperties(icf, info);
		info.setTheDate(icf.getYear()+icf.getMonth()+icf.getDay());
		info.setStartTime(icf.getStarthour()+":"+icf.getStartminute());
		info.setEndTime(icf.getEndhour()+":"+icf.getEndminute());
		
		service.updateCourse(info);
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
	
	// self validation method
		public BindingResult validate(InputCourseForm form, BindingResult result) {
			String startTime = "";
			String endTime = "";
			
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
