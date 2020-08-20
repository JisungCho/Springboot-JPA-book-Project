package com.cos.book.controller.api;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.book.dto.ResponseDTO;
import com.cos.book.model.RoleType;
import com.cos.book.model.User;
import com.cos.book.repository.UserRepository;
import com.cos.book.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth/joinProc")
	public  ResponseDTO<Integer> save(@RequestBody User user){
		System.out.println("UserApiController : Save호출됨");
		userService.save(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}	
	
}
