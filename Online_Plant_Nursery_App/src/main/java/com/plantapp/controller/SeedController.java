
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
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.PlantExeption;
import com.plantapp.exception.PlanterException;
import com.plantapp.exception.SeedException;
import com.plantapp.model.Planter;
import com.plantapp.model.Seed;
import com.plantapp.service.SeedService;

@RestController
public class SeedController {
 
	@Autowired
	private SeedService sService;
	
	
	@PostMapping("/seedadd")
	public ResponseEntity<Seed>addSeedHandler(@RequestBody Seed seed) throws SeedException{
		Seed savedSeed=sService.addSeed(seed);
		return new ResponseEntity<Seed>(savedSeed,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/seedupdate")
	public ResponseEntity<Seed>updateSeedHandler(@RequestBody Seed seed) throws SeedException{
		Seed updatedSeed=sService.updateSeed(seed);
		return new ResponseEntity<Seed>(updatedSeed,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/seeddelete")
	public ResponseEntity<Seed>deleteSeedHandler(@RequestBody Seed seed) throws SeedException{
		Seed deletedSeed=sService.deleteSeed(seed);
		return new ResponseEntity<Seed>(deletedSeed,HttpStatus.OK);
	}
	
	
	@GetMapping("/seedid/{seedId}")
	public ResponseEntity<Seed>viewSeedByIdHandler(@PathVariable("seedId") Integer seedId) throws SeedException{
		Seed currentSeed=sService.viewSeedById(seedId);
		return new ResponseEntity<Seed>(currentSeed,HttpStatus.OK);
	}
	
	
	@GetMapping("/seedname/{commonName}")
	public ResponseEntity<Seed>viewSeedByNameHandler(@PathVariable("commonName") String commonName) throws SeedException{
		Seed seed=sService.viewSeedByCommonName(commonName);
		return new ResponseEntity<Seed>(seed,HttpStatus.OK);
	}
	
	
	@GetMapping("/seeds")
	public ResponseEntity<List<Seed>>viewAllSeedsHandler() throws SeedException{
		List<Seed>seeds=sService.viewAllSeeds();
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	
	@GetMapping("/seeds/{typeOfSeed}")
	public ResponseEntity<List<Seed>>viewAllSeedsByTypeHandler(@PathVariable("typeOfSeed") String typeOfSeed) throws SeedException{
		List<Seed>seeds=sService.viewAllSeedsByType(typeOfSeed);
		return new ResponseEntity<List<Seed>>(seeds,HttpStatus.OK);
	}
	
	@GetMapping("/viewPlanter/{PlanterId}/{SeedId}")
	public ResponseEntity<Planter> savePlanterToPlant(@PathVariable("PlanterId") Integer PlanterId, @PathVariable("SeedId") Integer SeedId) throws PlanterException, SeedException{
		Planter planter=
	sService.addSeedToPlanter(PlanterId, SeedId);
	return new ResponseEntity<Planter>(planter,HttpStatus.OK); 
		
	}
}

