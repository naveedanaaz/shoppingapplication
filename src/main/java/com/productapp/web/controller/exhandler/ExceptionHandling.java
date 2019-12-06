package com.productapp.web.controller.exhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productapp.web.controller.exceptions.ProductNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException ex, WebRequest req) {
		ErrorDetails details = new ErrorDetails("product not found", LocalDateTime.now(), req.getDescription(false),
				"https://www.hcltech.com/support");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleOtherEx(Exception ex, WebRequest req) {

		ErrorDetails details = new ErrorDetails("server side error", LocalDateTime.now(), req.getDescription(false),
				"https://www.hcltech.com/home");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails details = new ErrorDetails("validation error", LocalDateTime.now(),
				ex.getBindingResult().toString(), "https://www.hcltech.com/dbteam/bangalore");

		return new ResponseEntity<Object>(details, HttpStatus.NOT_FOUND);

	}

}
