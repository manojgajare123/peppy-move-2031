package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.PlantException;
import com.plantapp.model.Plant;



public interface PlantService {
	
	public Plant addPlant(Plant plant)throws PlantException;
//	public Plant updatePlant(Plant plant)throws PlantException;
//	public Plant deletePlant(Plant plant)throws PlantException;
//	public Plant viewPlant(Integer plantId)throws PlantException;
//	public List<Plant> viewPlant(String commonName)throws PlantException;
//	public List<Plant> viewAllPlants()throws PlantException ;
//	public List<Plant> viewAllPlants(String typeOfPlant)throws PlantException ;

}