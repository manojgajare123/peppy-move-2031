package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.PlanterException;
import com.plantapp.model.Planter;


public interface PlanterService {

	Planter updatePlanter(Planter planter) throws PlanterException;

	Planter addPlanter(Planter planter) throws PlanterException;
	


			
}


