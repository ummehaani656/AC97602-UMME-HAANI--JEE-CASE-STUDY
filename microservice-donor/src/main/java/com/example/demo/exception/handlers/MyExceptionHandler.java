package com.example.demo.exception.handlers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exception.ErrorHandler;

@RestControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ErrorHandler handleAllExceptions(Exception ex,WebRequest req) {
		return  new ErrorHandler(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
	}

}
