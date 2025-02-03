package com.dhagakart.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dhagakart.exception.DuplicatePriceException;
import com.dhagakart.exception.InvalidTokenException;
import com.dhagakart.exception.PriceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ProblemDetail handleUnhandledException(Exception exception) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage());

		problemDetail.setTitle("Internal server error");
		problemDetail.setProperty("error category", "Generic");
		problemDetail.setProperty("timestamp", Instant.now());

		return problemDetail;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleMethodArgumentNotValidException(
			MethodArgumentNotValidException methodArgumentNotValidException) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Invalid Request data");

		List<String> errors = new ArrayList<>();

		List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

		for (FieldError fieldError : fieldErrors) {
			errors.add(fieldError.getDefaultMessage());
		}

		problemDetail.setTitle("Bad Request");
		problemDetail.setProperty("error category", "Generic");
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setProperty("errors", errors);

		return problemDetail;
	}

	@ExceptionHandler(PriceNotFoundException.class)
	public ProblemDetail handlePriceNotFoundException(PriceNotFoundException priceNotFoundException) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
				priceNotFoundException.getMessage());

		problemDetail.setTitle("Not Found");
		problemDetail.setProperty("error category", "Generic");
		problemDetail.setProperty("timestamp", Instant.now());

		return problemDetail;
	}

	@ExceptionHandler(DuplicatePriceException.class)
	public ProblemDetail handleDuplicatePriceException(DuplicatePriceException duplicatePriceException) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
				duplicatePriceException.getMessage());

		problemDetail.setTitle("Duplicate Price");
		problemDetail.setProperty("error category", "Generic");
		problemDetail.setProperty("timestamp", Instant.now());

		return problemDetail;
	}

	@ExceptionHandler(InvalidTokenException.class)

	public ProblemDetail handleInvalidToken(InvalidTokenException ex) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, ex.getMessage());

		problemDetail.setTitle("Unauthorized Acess");
		problemDetail.setProperty("error category", "Generic");
		problemDetail.setProperty("timestamp", Instant.now());

		return problemDetail;
	}

}
