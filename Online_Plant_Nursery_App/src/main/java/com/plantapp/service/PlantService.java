package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.PlantExeption;
import com.plantapp.exception.PlanterException;
import com.plantapp.model.Plant;
import com.plantapp.model.Planter;



public interface PlantService {
	
	public Plant addPlant(Plant plant)throws PlantExeption;
	public Plant updatePlant(Plant plant)throws PlantExeption;
	public Plant deletePlant(Integer  plantId) throws PlantExeption;
	public Plant viewPlant(Integer plantId)throws PlantExeption;
	public List<Plant> viewPlant(String commonName)throws PlantExeption;
	public List<Plant> viewAllPlants()throws PlantExeption ;
	public List<Plant> viewAllPlants(String typeOfPlant)throws PlantExeption ;
	public Planter addPlantToPlanter(Integer PlanterId, Integer PlantId) throws PlanterException,PlantExeption;
	

}