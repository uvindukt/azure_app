/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.training.openapi.dto.ResponseDTO;
import com.nagarro.training.openapi.exception.FacadeException;
import com.nagarro.training.openapi.exception.ServiceException;

/**
 * Exception handler fot all controllers
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler({ EntityNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ResponseDTO> handleNotFound(RuntimeException e) {

		ResponseDTO response = new ResponseDTO();
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.message(e.getMessage());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler({ ServiceException.class, FacadeException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ResponseDTO> handleServerError(RuntimeException e) {

		ResponseDTO response = new ResponseDTO();
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.message(e.getMessage());

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ResponseDTO> handleBadRequest(RuntimeException e) {

		ResponseDTO response = new ResponseDTO();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.message(e.getMessage());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}
