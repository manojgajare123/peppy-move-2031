package com.plantapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.plantapp.exception.SeedException;
import com.plantapp.model.Seed;
import com.plantapp.repository.SeedRepo;

@Service
public class SeedServiceImpl implements SeedService{
   
	@Autowired
	private SeedRepo sRepo;
	
	@Override
	public Seed addSeed(Seed seed)throws SeedException {
		Seed savedSeed=sRepo.save(seed);
		return savedSeed;
		
	}

	@Override
	public Seed updateSeed(Seed seed)throws SeedException {
		Optional<Seed>opt=sRepo.findById(seed.getSeedId());
		if(opt.isPresent()) {
			
			Seed seed1=sRepo.save(seed);
			return seed1;
		}else {
			throw new SeedException("Seed Doesn't Exist ! ");
		}
		
	}

	@Override
	public Seed deleteSeed(Seed seed)throws SeedException {
	Optional<Seed>opt=sRepo.findById(seed.getSeedId());
	if(opt.isPresent()) {
		sRepo.delete(seed);
		return seed;
	}else {
		throw new SeedException("Seed Doesn't Exist ! ");
	}
		
	}

	@Override
	public Seed viewSeedById(Integer seedId)throws SeedException {
		Optional<Seed>opt=sRepo.findById(seedId);
		if(opt.isPresent()) {
			Seed presentseed=opt.get();
			return presentseed;
		}else {
			throw new SeedException("Seed Doesn't Exist with Id!: "+seedId);
		}
		
	}

	@Override
	public Seed viewSeedByCommonName(String commonName)throws SeedException {
		Seed seed=sRepo.findBycommonName(commonName);
		if(seed!=null) {
			return seed;	
		}else {
			throw new SeedException("Seed Doesn't Exist with commonName!: "+commonName);	
		}
		
	}

	@Override
	public List<Seed> viewAllSeeds()throws SeedException {
		List<Seed>seedlist=sRepo.findAll();
		if(seedlist.size()!=0) {
			return seedlist;	
		}else {
			throw new SeedException("Seeds Not Found !");
		}
		
	}

	@Override
	public List<Seed> viewAllSeedsByType(String typeOfSeeds)throws SeedException {
		List<Seed>seeds=sRepo.findBytypeOfSeeds(typeOfSeeds);
		if(seeds.size()!=0) {
			return seeds;
		}else {
			throw new SeedException("Seeds Not Found !");
		}
	
	
}
		

}
