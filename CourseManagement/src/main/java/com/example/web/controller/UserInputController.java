package com.example.web.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Application;
import com.example.domain.RegistCourseInfo;
import com.example.service.UserService;
import com.example.web.form.InputApplyForm;

@Controller
public class UserInputController {

	@Autowired
	UserService service;
	
	@ModelAttribute("apply")
	public InputApplyForm setForm() {
		return new InputApplyForm();
	}
	
	@RequestMapping("/uinput")
	public String userInputPage(Model model) {
		
		List<RegistCourseInfo> registList = service.getList();		
		model.addAttribute("registList", registList);
		
		return "user/userInput";
	}
	
	@RequestMapping("/uinput-conf")
	public String userInputConfPage(@ModelAttribute("apply") InputApplyForm form, Model model) {
		System.out.println("uinput form : "+form.toString());
		
		model.addAttribute("apply", form);
		
		return "user/userInputConf";
	}
	
	@RequestMapping("/uinput-end")
	public String userInputEndPage(@ModelAttribute("apply") InputApplyForm form) {
		
		Application application = new Application();
		
		BeanUtils.copyProperties(form, application);
		
		System.out.println("apply insert : "+application.toString());
		
		return "user/userInputEnd";
	}
	
	
}
