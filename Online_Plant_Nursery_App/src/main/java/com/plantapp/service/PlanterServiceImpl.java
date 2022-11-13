package com.plantapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.exception.PlanterException;
import com.plantapp.model.Plant;
import com.plantapp.model.Planter;
import com.plantapp.model.Seed;
import com.plantapp.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService {

	@Autowired
	private PlanterDao planterDao;

	@Override
	public Planter addPlanter(Planter planter) throws PlanterException {

		List<Plant> plant = planter.getPlants();

		List<Seed> seeds = planter.getSeeds();

		if (!seeds.isEmpty()) {

			for (Seed s : seeds) {

				s.setPlanter(planter);
			}

		}

		if (!plant.isEmpty()) {

			for (Plant p : plant) {

				p.setPlanter(planter);
			}

		}

		Planter addPlanter = planterDao.save(planter);

		if (addPlanter != null) {
			return addPlanter;
		}

		else {
			throw new PlanterException("Plant details are empty........");
		}

	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {

		List<Plant> plant = planter.getPlants();

		List<Seed> seeds = planter.getSeeds();

		if (!seeds.isEmpty()) {

			for (Seed s : seeds) {

				s.setPlanter(planter);
			}

		}

		if (!plant.isEmpty()) {

			for (Plant p : plant) {

				p.setPlanter(planter);
			}

		}
		planterDao.findById(planter.getPlanterId()).orElseThrow(() -> new PlanterException("Planter  not found"));

		return planterDao.save(planter);

	}


	@Override
	public Planter viewPlanterById(Integer planterId) throws PlanterException {

		Optional<Planter> opt = planterDao.findById(planterId);

		return opt.orElseThrow(() 
				-> new PlanterException("Planter not exist with Id :" + planterId));
	}

	@Override
	public List<Planter> viewPlanterByShape(String planterShape) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {

		List<Planter> planters = planterDao.findAll();

		if (planters.size() > 0) {
			return planters;
		} else {
			throw new PlanterException("No Planters Found");
		}
	}

	@Override
	public List<Planter> viewAllPlanters(Double minCost, Double maxCost) throws PlanterException {

		List<Planter> planters= planterDao.getAllPlanterByCost(minCost, maxCost);
		
		if(planters.size() > 0)
			return planters;
		else
			throw new PlanterException("No Planters found within "+minCost+" And "+ maxCost);
	}

	@Override
	public Planter deletePlanter(Integer PlanterId) throws PlanterException {
		Planter planterObj= 
				planterDao.findById(PlanterId).orElseThrow(
						() -> new PlanterException("Planter does not exist with Plant Id " + PlanterId));
				
	
				planterDao.delete(planterObj);
		
				return planterObj;
	}
}

	

