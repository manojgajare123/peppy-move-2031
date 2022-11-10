package com.plantapp.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.exception.PlanterException;
import com.plantapp.model.Planter;
import com.plantapp.repository.PlanterDao;


@Service
public class PlanterServiceImpl implements PlanterService{

	@Autowired
	private PlanterDao planterDao;
	
	
	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		Planter addPlanter=planterDao.save(planter);

        if(addPlanter!=null)
        {
        	return addPlanter;
        }
         
        
        else {
        throw new PlanterException("Plant details are empty........");
		}

	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		
		planterDao.findById(planter.getPlanterId()).orElseThrow(() -> new PlanterException("Planter  not found"));
        
		return planterDao.save(planter);
	        
	}

	@Override
	public Planter deletePlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter viewPlanterById(Integer planterId) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters(Double minCost, Double maxCost) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}