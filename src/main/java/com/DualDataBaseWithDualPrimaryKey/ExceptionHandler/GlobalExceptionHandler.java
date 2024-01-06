package com.DualDataBaseWithDualPrimaryKey.ExceptionHandler;

import java.util.NoSuchElementException;

import javax.management.AttributeNotFoundException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<String> handleDuplicateKeyException(DuplicateKeyException duplicateKeyException) {
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(duplicateKeyException.getMessage());
	}

	@ExceptionHandler(AttributeNotFoundException.class)
	public ResponseEntity<String> handleAttributeNotFoundException(
			AttributeNotFoundException attributeNotFoundException) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(attributeNotFoundException.getMessage());
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(noSuchElementException.getMessage());

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	}
}
