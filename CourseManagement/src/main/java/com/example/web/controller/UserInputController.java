package com.example.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Application;
import com.example.domain.CourseApply;
import com.example.domain.RegistCourseInfo;
import com.example.service.UserService;
import com.example.web.form.InputApplyForm;
import com.example.web.form.InputCourseForm;

@Controller
public class UserInputController {

	@Autowired
	UserService service;
	
	@ModelAttribute("apply")
	public InputApplyForm setForm() {
		InputApplyForm apply = new InputApplyForm();
		apply.setSex("3");
		return apply;
	}
	
	@RequestMapping("/uinput")
	public String userInputPage(Model model, HttpSession session) {
		
		// DBから講座リスト取得
		List<RegistCourseInfo> registList = service.getList();		
		// sessionにリスト保存
		session.setAttribute("registList", registList);
		
		return "user/userInput";
	}
	
	@RequestMapping("/uinput-conf")
	public String userInputConfPage(@Validated @ModelAttribute("apply") InputApplyForm form, BindingResult result, Model model) {
		
		// self validation
		result = validate(form, result);
		
		// modelにform保存
		model.addAttribute("apply", form);
		// errorがある場合、戻る
		if (result.hasErrors()) {
			return "user/userInput";
		}
		// errorがない場合確認画面に移動
		return "user/userInputConf";
	}
	
	@RequestMapping("/uinput-end")
	public String userInputEndPage(@ModelAttribute("apply") InputApplyForm form, HttpSession session) {
		// DBに登録するapplicaion object 生成
		Application application = new Application();
		
		//applicationにfield　copy and setting
		BeanUtils.copyProperties(form, application);
		application.setBirthday(form.getYear()+form.getMonth()+form.getDay());
		// DB登録
		service.insertApplication(application);
		
		//　DBに登録するcourse_apply object 生成
		CourseApply courseApply = new CourseApply();
		// field値 setting
		courseApply.setCourseNo(form.getApplied());
		// DB登録
		service.insertCourseApply(courseApply);
		
		// sessionにある登録講座リスト削除
		session.removeAttribute("registList");
		
		return "user/userInputEnd";
	}
	
	
	public BindingResult validate(InputApplyForm form, BindingResult result) {
		
		// birthday
		if (form.getYear().isEmpty()||form.getMonth().isEmpty()||form.getDay().isEmpty()) {
			result.reject("error.user.input.birthday.required");
		}
		
		// tel
		if (!form.getTel().isEmpty()) {
			String tel = form.getTel();
			if (tel.contains("-")) {
				tel.replaceAll("-", "");
			}
			tel.trim();
			try {
				long telnum = Long.parseLong(tel);
			} catch (NumberFormatException e) {
				result.reject("error.user.input.tel.parse");
			}
		}
		
		return result;
	}
	
}
