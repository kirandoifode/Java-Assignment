package com.assignment.java_assignment.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.java_assignment.controller.AdminController;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AdminController.class);
	private String BAD_REQUEST = "BAD_REQUEST";
	private String NOT_FOUND = "NOT_FOUND";

	@ExceptionHandler(EmptyInputFieldException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException(EmptyInputFieldException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(BAD_REQUEST, details);
		LOGGER.error("Error occurred during request processing. ", error);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(NOT_FOUND, details);
		LOGGER.error("Error occurred during request processing. ", error);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
