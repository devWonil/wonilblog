package com.tencoding.wonilblog.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = IllegalArgumentException.class)
	public String illegalArgumentException(IllegalArgumentException e) {
		System.out.println(" ApiControllerAdvice 호출() : ");
		return "<h1>" + e.getMessage() + "</h1>";
	}
}
