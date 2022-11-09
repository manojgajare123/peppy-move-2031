package com.plantapp.service;
import java.util.List;

import com.plantapp.exception.SeedException;
import com.plantapp.model.Seed;
public interface SeedService {
  
	public Seed addSeed(Seed seed)throws SeedException;
	public Seed updateSeed(Seed seed)throws SeedException;
	public Seed deleteSeed(Seed seed)throws SeedException;
	public Seed viewSeedById(Integer seedId)throws SeedException;
	public Seed viewSeedByCommonName(String commonName)throws SeedException;
	public List<Seed>viewAllSeeds()throws SeedException;
	public List<Seed>viewAllSeedsByType(String typeOfSeeds)throws SeedException;
}
