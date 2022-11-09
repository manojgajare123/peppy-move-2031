package com.plantapp.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plantapp.exception.PlanterException;
import com.plantapp.model.Planter;
import com.plantapp.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	private PlanterDao planterDao;

	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}
	

	

	
	
}
