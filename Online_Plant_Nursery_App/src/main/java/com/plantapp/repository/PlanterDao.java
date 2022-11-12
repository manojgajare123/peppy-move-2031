package com.plantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.plantapp.model.Planter;

@Repository
public interface PlanterDao extends JpaRepository<Planter, Integer> {

	
		
//	@Query("select p from Planter p where p.planterCost between =?1 AND p.planterCost=?2")
//	public List<Planter> findByPriceBetween(Integer start, Integer End);

	@Query("select p from Planter p where p.planterCost > ?1 AND p.planterCost < ?2")
    public List<Planter> getAllPlanterByCost(Double minCost, Double maxCost);
	
		
}

