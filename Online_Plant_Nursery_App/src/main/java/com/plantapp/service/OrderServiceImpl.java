package com.plantapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.model.Customer;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.Plant;
import com.plantapp.model.PlantOrder;
import com.plantapp.model.Planter;
import com.plantapp.model.Seed;
import com.plantapp.repository.CustomerRepo;
import com.plantapp.repository.OrderRepo;
import com.plantapp.repository.PlanterDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo oRepo;

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	private PlanterDao planterRepo;

	@Override
	public List<Planter> placeOrder(CustomerDTO cdto) {

		List<Planter> plist = planterRepo.findAll();

		for (Planter p : plist) {

			List<Plant> plants = p.getPlants();

			List<Seed> seeds = p.getSeeds();

			System.out.println(plants);
			System.out.println(seeds);

		}

		return plist;
	}

	public Customer getCustomer(Integer cid) {

		Optional<Customer> opt = cRepo.findById(cid);

		if (opt.isPresent())
			return opt.get();

		return null;

	}

}
