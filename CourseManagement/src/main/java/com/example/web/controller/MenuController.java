package com.example.web.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	@Autowired
	HttpSession session;
	
	@RequestMapping({"/main", "/menu"})
	public String menuPage() {
		return "main";
	}

	@RequestMapping({"/login"})
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/mkCalendar")
	public String mkCal(@Param("btn") String btn) {
		
		Calendar cal = Calendar.getInstance();
		ArrayList<String> year = new ArrayList<>();
		ArrayList<String> month = new ArrayList<>();
		ArrayList<String> day = new ArrayList<>();
		ArrayList<String> hour = new ArrayList<>();
		ArrayList<String> minute = new ArrayList<>();
		
		for (int i = cal.get(Calendar.YEAR); i < cal.get(Calendar.YEAR)+5; i++) {
			year.add(i+"");
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
		session.setAttribute("monthlist", month);
		session.setAttribute("daylist", day);
		session.setAttribute("hourlist", hour);
		session.setAttribute("minutelist", minute);
		
		return "redirect:"+btn;
	}
	
}
