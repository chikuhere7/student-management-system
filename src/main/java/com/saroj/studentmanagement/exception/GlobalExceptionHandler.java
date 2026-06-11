package com.saroj.studentmanagement.exception;

import java.util.HashMap;

import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    return errors;
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public Map<String, String> handleStudentNotFoundException(
	        StudentNotFoundException ex) {

	    Map<String, String> error = new HashMap<>();

	    error.put("message", ex.getMessage());

	    return error;
	}
}
