package com.pathshala.schedule.syllabus.exam.examschedule.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @author kapoor_tirumala
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler  {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArguement(MethodArgumentNotValidException ex){
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult()
			.getFieldErrors()
			.forEach(
					error -> errorMap.put(error.getField(), error.getDefaultMessage()) 
					);
		return errorMap;
	}

}
