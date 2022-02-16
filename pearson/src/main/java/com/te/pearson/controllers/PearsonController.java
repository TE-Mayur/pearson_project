package com.te.pearson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.pearson.beans.StoresResponse;
import com.te.pearson.services.StoresServicesImpl;

@RestController
@RequestMapping("/pearson")
public class PearsonController {

	@Autowired
	private StoresServicesImpl impl;

	@GetMapping("/getall/")
	public ResponseEntity<StoresResponse> getDetails(@RequestParam String option) {
		StoresResponse response = new StoresResponse(false, impl.fetch(option));
		return new ResponseEntity<StoresResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/getdata/{store_id}")
	public ResponseEntity<StoresResponse> getData(@PathVariable String store_id) {
		StoresResponse response = new StoresResponse(false, impl.getData(store_id));
		return new ResponseEntity<StoresResponse>(response, HttpStatus.OK);
	}
}
