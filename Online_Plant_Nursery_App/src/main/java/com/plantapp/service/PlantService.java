package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.PlantExeption;
import com.plantapp.model.Plant;



public interface PlantService {
	
	public Plant addPlant(Plant plant)throws PlantExeption;
	public Plant updatePlant(Plant plant)throws PlantExeption;
	public Plant deletePlant(Integer  plantId) throws PlantExeption;
	public Plant viewPlant(Integer plantId)throws PlantExeption;
	public List<Plant> viewPlant(String commonName)throws PlantExeption;
	public List<Plant> viewAllPlants()throws PlantExeption ;
	public List<Plant> viewAllPlants(String typeOfPlant)throws PlantExeption ;
	
	

}