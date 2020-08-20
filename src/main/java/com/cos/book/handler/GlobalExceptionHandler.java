package com.cos.book.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.book.dto.ResponseDTO;



//모든 Exception이 발생했을 때 해당클래스로 옴
@ControllerAdvice
//data만 리턴
@RestController
public class GlobalExceptionHandler {
	
	// 모든 Exception이 발생했을때
	@ExceptionHandler(value = Exception.class)
	public ResponseDTO<String> handleArgumentException(Exception e) {
		return new ResponseDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()); //500
	}

}
