package com.plantapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.exception.PlantExeption;
import com.plantapp.exception.PlanterException;
import com.plantapp.model.Plant;
import com.plantapp.model.Planter;
import com.plantapp.repository.PlantDao;
import com.plantapp.repository.PlanterDao;



@Service
public class PlantServiceImpl implements PlantService {

	@Autowired
	private PlantDao dao;
	
	@Autowired
	private PlanterDao planterdao;
	
	@Override
	public Plant addPlant(Plant plant) throws PlantExeption {
		 Plant addPlant=dao.save(plant);

	        if(addPlant!=null)
	        {
	        	return addPlant;
	        }
	         
	        
	        else {
	        throw new PlantExeption("Plant details are empty........");
			}
	}

	@Override
	public Plant updatePlant(Plant plant) throws PlantExeption {
    Optional<Plant>opt=dao.findById(plant.getPlantId());
		
		if(opt.isPresent())
		{
			Plant pl=dao.save(plant);
			return pl;
		}
	
	
	else {
        throw new PlantExeption("Plant with given id is not presesnt........");

	}
		
	       
	}

	@Override
	public Plant deletePlant(Integer plantId) throws PlantExeption {
	
		Optional<Plant> opt= dao.findById(plantId);
		if(opt.isPresent()) {
			Plant  existingPlant=opt.get();
			dao.delete(existingPlant);
			
			return existingPlant;
		}
		else {
			throw new PlantExeption("Student does not exist with Roll :"+plantId);
			
		}
		
		
	}
	

	@Override
	public Plant viewPlant(Integer plantId) throws PlantExeption{
		Plant obj= dao.findById(plantId).orElseThrow(() -> new PlantExeption("Plant does not exist with Plant Id "+plantId) );
	
		return obj;
	}

	@Override
	public List<Plant> viewPlant(String commonName) throws PlantExeption {

		List<Plant> plants= dao.findByCommonName(commonName);
		
		if(plants.size() > 0)
			return plants;
		else
			throw new PlantExeption("Plant does not exist with Name "+commonName);
		
	}

	@Override
	public List<Plant> viewAllPlants() throws PlantExeption {
		
List<Plant> plants= dao.findAll();
		
		if(plants.size() > 0)
			return plants;
		else
			throw new PlantExeption("No Plant found..");
		
		
	}

	

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) throws PlantExeption {
		List<Plant> plants= dao.findByTypeOfPlant(typeOfPlant);
		
		if(plants.size() > 0)
			return plants;
		else
			throw new PlantExeption("Plant does not exist with Type "+typeOfPlant);
	}

	@Override
	public Planter addPlantToPlanter(Integer PlanterId, Integer PlantId) throws PlanterException, PlantExeption {
		
		Optional<Planter> planter=planterdao.findById(PlanterId);
		Optional<Plant> plant=dao.findById(PlantId);
		
		if(!planter.isPresent()) {
			
			throw new PlanterException("Planter Not found...");
		}
		if(!plant.isPresent()) {
			throw new PlantExeption("Plant Not found...");
		}
	Planter pltr=	planter.get();
	Plant plt=	plant.get();
	
	pltr.getPlants().add(plt);
	plt.setPlanter(pltr);
	return  planterdao.save(pltr);
	
	}
   
}
