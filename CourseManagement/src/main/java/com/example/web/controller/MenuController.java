package com.example.web.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.UserInfo;
import com.example.service.UserService;
import com.example.web.form.UserForm;

@Controller
public class MenuController {

	@Autowired
	HttpSession session;
	
	@Autowired
	UserService service;
	
	@ModelAttribute("userForm")
	public UserForm setForm() {
		return new UserForm();
	}
	
	@RequestMapping({"/main", "/menu"})
	public String menuPage() {
		return "main";
	}

	@RequestMapping({"/login"})
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login-check")
	public String loginCheck(@Validated @ModelAttribute("userForm")UserForm userForm, BindingResult result, Model model) {
		
		if (result.hasErrors()) { return "/login"; }
		
		UserInfo user = service.loginCheck(userForm);
		// error
		if (user == null) {
			result.reject("error.user.login.no.account");
		}
		if (result.hasErrors()) {
			return "/login";
		}
		
		// login
		session.setAttribute("user", user);
		
		return "redirect:/mkCalendar";
	}
	
	@RequestMapping("/signup")
	public String signUpPage(@ModelAttribute("userForm")UserForm userForm, Model model) {
		return "user/signUp";
	}

	@RequestMapping("/signup-conf")
	public String signUpConf(@Validated @ModelAttribute("userForm")UserForm userForm, BindingResult result) {
		
		if (result.hasErrors()) { return "user/signup"; }
		
		if (service.idCheck(userForm)) { result.reject("error.user.signup.id.exist"); }
		if (!userForm.getPasswd().equals(userForm.getPasswd2())) { result.reject("error.user.signup.pw.unmatch"); }
		
		if (result.hasErrors()) { return "user/signup"; }
		
		return "user/signUpConf";
	}
	
	@RequestMapping("/signup-end")
	public String signUpEnd(@ModelAttribute("userForm")UserForm userForm) {
		
		service.insertUser(userForm);
		UserInfo user = service.loginCheck(userForm);
		session.setAttribute("user", user);
		
		return "user/signUpEnd";
	}

	@RequestMapping({"/logout"})
	public String logout() {
		session.invalidate();
		
		return "redirect:/login";
	}
	
	@RequestMapping("/mkCalendar")
	public String mkCal(@Param("btn") String btn) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<String> year = new ArrayList<>();
		ArrayList<String> ageyear = new ArrayList<>();
		ArrayList<String> month = new ArrayList<>();
		ArrayList<String> day = new ArrayList<>();
		ArrayList<String> hour = new ArrayList<>();
		ArrayList<String> minute = new ArrayList<>();
		
		for (int i = cal.get(Calendar.YEAR); i < cal.get(Calendar.YEAR)+5; i++) {
			year.add(i+"");
		}
		
		for (int i = cal.get(Calendar.YEAR); i > cal.get(Calendar.YEAR)-90; i--) {
			ageyear.add(i+"");
		}

		for (int i = 1; i <= 12; i++) {
			if (i < 10) {
				month.add("0"+i);
			}else {
				month.add(""+i);
			}
		}

		for (int i = 1; i <= 30; i++) {
			if (i < 10) {
				day.add("0"+i);
			}else {
				day.add(""+i);
			}
		}

		for (int i = 10; i <= 18; i++) {
			hour.add(i+"");
		}

		for (int i = 0; i <= 59; i++) {
			if (i < 10) {
				minute.add("0"+i);
			}else {
				minute.add(""+i);
			}
		}
		
		session.setAttribute("yearlist", year);
		session.setAttribute("ageyearlist", ageyear);
		session.setAttribute("monthlist", month);
		session.setAttribute("daylist", day);
		session.setAttribute("hourlist", hour);
		session.setAttribute("minutelist", minute);
		
		UserInfo user = (UserInfo) session.getAttribute("user");
		
		if (user.getAuthority().equals("0")) {
			if (btn != null && !btn.equals("")) {
				return "redirect:"+btn;
			}
			return "/main";
		} 
		return "redirect:/uinput";
	}
	
}
