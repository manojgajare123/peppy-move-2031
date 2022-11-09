package com.plantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantapp.model.Seed;

@Repository
public interface SeedRepo extends JpaRepository<Seed,Integer> {

	Seed findBycommonName(String commonName);
//
//	public Seed findByCommonName(String CommonName);
//	
//	public List<Seed> findAllByType(String typeOfSeeds);

	List<Seed> findBytypeOfSeeds(String typeOfSeeds);
}
