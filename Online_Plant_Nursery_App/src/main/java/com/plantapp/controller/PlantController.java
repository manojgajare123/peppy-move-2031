package com.plantapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.PlantException;
import com.plantapp.model.Plant;
import com.plantapp.service.PlantService;

@RestController
public class PlantController {
	@Autowired
	private PlantService plantservice;

	@PostMapping("/admin")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws PlantException {
//	Plant plant1=	plantservice.addPlant(plant);
		System.out.println(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);

	}
}
