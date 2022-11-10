package com.plantapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.PlantExeption;
import com.plantapp.model.Plant;
import com.plantapp.service.PlantService;

@RestController
@RequestMapping(value = "/admin")
public class PlantController {
	@Autowired
	private PlantService plantservice;

	@PostMapping("/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws PlantExeption {
	Plant plant1=	plantservice.addPlant(plant);
//		System.out.println(plant);
		return new ResponseEntity<Plant>(plant1, HttpStatus.OK);

	}
	
	@PutMapping("/update")
	public ResponseEntity<Plant> UpdatePlant(@RequestBody Plant plant) throws PlantExeption{
		Plant plant1=	plantservice.updatePlant(plant);

		return new ResponseEntity<Plant>(plant1,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{plantId}")
	public ResponseEntity<Plant> DeletePlant(@PathVariable ("plantId") Integer id ) throws PlantExeption{
		Plant plant1=plantservice.deletePlant(id);
		return new ResponseEntity<Plant>(plant1,HttpStatus.OK);
	}
	
	@GetMapping("/viewplantById/{id}")
	public ResponseEntity<Plant> GetPlantById(@PathVariable("id") Integer id) throws PlantExeption{
		Plant plant1 =plantservice.viewPlant(id);
		
		return new ResponseEntity<Plant>(plant1,HttpStatus.OK);
	}
	@GetMapping("/viewplantByName/{commonName}")
	public ResponseEntity<List<Plant>> GetPlantcommonName(@PathVariable("commonName") String plantcommonName) throws PlantExeption{
		List<Plant> plant1= plantservice.viewPlant(plantcommonName);
		return new ResponseEntity<List<Plant>>(plant1,HttpStatus.OK);
	}
	
	@GetMapping("/viewplants")
	public ResponseEntity<List<Plant>> ShowPlants() throws PlantExeption{
	List<Plant> plants=	plantservice.viewAllPlants();
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
	}
	
	
	@GetMapping("/viewplantsByType/{type}")
	public ResponseEntity<List<Plant>> ViewPlantsByType(@PathVariable("type") String type) throws PlantExeption{
		List<Plant> plant=	plantservice.viewAllPlants(type);
		return new ResponseEntity<List<Plant>>(plant,HttpStatus.OK);
	}
}
