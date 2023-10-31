package com.angular.ojt.AngularBackend.exceptionHandler;


import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		HashMap<String, String> map = new HashMap<>();
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> list = bindingResult.getFieldErrors();
		for (FieldError fieldError : list) {
			map.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return map;
		
	}
	
	
}
