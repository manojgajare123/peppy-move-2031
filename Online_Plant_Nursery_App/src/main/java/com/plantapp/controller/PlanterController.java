package com.plantapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.PlanterException;
import com.plantapp.model.Planter;
import com.plantapp.service.PlanterService;

@RestController
public class Controller {

	@Autowired
	private PlanterService planterService;
	
	
	
}
