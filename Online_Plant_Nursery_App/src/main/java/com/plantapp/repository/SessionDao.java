package com.plantapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantapp.model.CurrentUserSession;



public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
