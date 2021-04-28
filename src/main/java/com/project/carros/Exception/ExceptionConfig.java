package com.project.carros.Exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.google.common.net.HttpHeaders;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler{
	 
	 @ExceptionHandler({
		 EmptyResultDataAccessException.class
	 })
	 public ResponseEntity<?> errorNotFound(Exception e) {
 		 return ResponseEntity.notFound().build();
	 }	 
	 
	 
	 @ExceptionHandler({
		 IllegalArgumentException.class
	 })
	 public ResponseEntity<?> erroBadRequest(Exception ex) {
		 return ResponseEntity.badRequest().build();
	 }
	 
	 protected ResponseEntity<Object> HttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders header) {
		 return new ResponseEntity<>(new ErroException("Operação não permitida forma de requisição incorreta"),HttpStatus.METHOD_NOT_ALLOWED);
	 }
}


