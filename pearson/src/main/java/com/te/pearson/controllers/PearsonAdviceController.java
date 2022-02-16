package com.te.pearson.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.pearson.beans.StoresResponse;
import com.te.pearson.customexceptions.CustomException;

@RestControllerAdvice
public class PearsonAdviceController {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<StoresResponse> handler(CustomException exception) {
		StoresResponse response = new StoresResponse(true, exception.getMessage());
		return new ResponseEntity<StoresResponse>(response, HttpStatus.NOT_FOUND);
	}
}
