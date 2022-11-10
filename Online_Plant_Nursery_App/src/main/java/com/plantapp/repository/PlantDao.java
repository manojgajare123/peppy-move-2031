package com.plantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantapp.model.Plant;

@Repository
public interface PlantDao extends JpaRepository<Plant, Integer>  {

	List<Plant> findByCommonName(String commonName);

	List<Plant> findByTypeOfPlant(String typeOfPlant);

}
