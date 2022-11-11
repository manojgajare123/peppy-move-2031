package com.plantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantapp.model.Plant;
import com.plantapp.model.Planter;
import com.plantapp.model.Seed;

@Repository
public interface PlanterDao extends JpaRepository<Planter, Integer> {

	List<Planter> findByPlanterShape(String planterShape);
	
	

		
		
		
}

