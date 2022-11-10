package com.plantapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.PlanterException;
import com.plantapp.model.Planter;
import com.plantapp.service.PlanterService;

@RestController
public class PlanterController {

	@Autowired
	private PlanterService planterService;
	
	@PostMapping("/admin/addplanter")
	public  ResponseEntity<Planter> addPlanterHandler(@RequestBody Planter planter) throws PlanterException{
		
	Planter planter1=planterService.addPlanter(planter);

	return new ResponseEntity<Planter>(planter1,HttpStatus.OK);
	}
	
	@PutMapping("/admin/updateplanter")
	public ResponseEntity<Planter> updatePlanterHandler(@RequestBody Planter planter) throws PlanterException{
		
		Planter planter2=planterService.updatePlanter(planter);

		return new ResponseEntity<Planter>(planter2,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
}
