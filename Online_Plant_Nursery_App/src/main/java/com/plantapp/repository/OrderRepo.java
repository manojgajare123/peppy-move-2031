package com.plantapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantapp.model.PlantOrder;

@Repository
public interface OrderRepo extends JpaRepository<PlantOrder, Integer> {

}
