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
import org.springframework.web.bind.annotation.RequestParam;
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
	

	@DeleteMapping("admin/deleteplanter/{PlanterId}")
	public ResponseEntity<Planter> deletePlanterHandler(@PathVariable ("PlanterId") Integer PlanterId) throws PlanterException{
		
		Planter planter3=planterService.deletePlanter(PlanterId);
		
		return new ResponseEntity<Planter>(planter3,HttpStatus.OK);
	}
	
	@GetMapping("/viewplanter/{id}")
	public ResponseEntity<Planter> getPlanterByIdHandler(@RequestParam("id") Integer planterId) throws PlanterException{
		
		Planter planter1 =planterService.viewPlanterById(planterId);
		
		return new ResponseEntity<Planter>(planter1,HttpStatus.OK);
	}
	

		
	@GetMapping("/viewAllplanters")
	public ResponseEntity<List<Planter>> showAllPlantersHandler() throws PlanterException{
	
		List<Planter> planters=	planterService.viewAllPlanters();
		
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
	
	@GetMapping("/viewplantersByMinMax/{mincost}/{maxcost}")
	public ResponseEntity<List<Planter>> ViewPlantersByMinMax(@PathVariable("mincost")Double min,@PathVariable("maxcost") Double max) throws PlanterException{
		List<Planter> planters=	planterService.viewAllPlanters(min, max);
		return new ResponseEntity<List<Planter>>(planters,HttpStatus.OK);
	}
	
}
