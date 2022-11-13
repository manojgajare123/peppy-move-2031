package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.PlanterException;
import com.plantapp.model.Planter;


public interface PlanterService {
	
	public Planter addPlanter(Planter planter)throws PlanterException;
	
	public Planter updatePlanter(Planter planter)throws PlanterException;
	
	public Planter deletePlanter(Integer PlanterId)throws PlanterException;
	
	public Planter viewPlanterById(Integer planterId)throws PlanterException;
	
	public List<Planter> viewPlanterByShape(String planterShape)throws PlanterException;
	
	public List<Planter> viewAllPlanters()throws PlanterException ;
	
	//public List<Planter> viewAllPlanters(double min, double max)throws PlanterException ;

//	public List<Planter> viewAllPlanters(double min, double max)throws PlanterException;

	public List<Planter> viewAllPlanters(Double minCost, Double maxCost) throws PlanterException;

	

		
}


