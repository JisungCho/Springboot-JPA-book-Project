package com.cos.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	//회원가입 폼으로 이동
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm"; //jsp 페이지로 이동
	}
	//로그인 폼으로 이동
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm"; //jsp 페이지로 이동
	}
	
	
}
