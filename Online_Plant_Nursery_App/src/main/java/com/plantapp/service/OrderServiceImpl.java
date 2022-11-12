package com.plantapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.exception.OrderException;
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
	public PlantOrder placeOrder(CustomerDTO cdto, String uid) throws OrderException {
		
		
		

		PlantOrder order = new PlantOrder();

		boolean flag = false;

		List<Planter> plist = planterRepo.findAll();

//		System.out.println(plist);
//
		for (Planter p : plist) {
//
			List<Plant> plants = p.getPlants();

			List<Seed> seeds = p.getSeeds();
//			
//			
			System.out.println(plants);
//
			for (Plant a : plants) {
//
				if (a.getCommonName().equals(cdto.getProductName())) {
//
					if (a.getPlantStock() >= cdto.getProductQty()) {
//
						a.setPlantStock(a.getPlantStock() - cdto.getProductQty());
//
						order.setTotalCost(a.getPlantCost() * cdto.getProductQty());
						order.setOrderDate(LocalDate.now());
						order.setQuantity(cdto.getProductQty());
						order.setTransactionMode(cdto.getTranscationMode());
						order.setPlanter(p);
						order.setName(cdto.getProductName());

//
						flag = true;
						break;
					}
				}
//
			}

			for (Seed a : seeds) {
				//
				if (a.getCommonName().equals(cdto.getProductName())) {
					//
					if (a.getSeedsStock() >= cdto.getProductQty()) {
						//
						a.setSeedsStock(a.getSeedsStock() - cdto.getProductQty());
						//
						order.setTotalCost(a.getSeedsCost() * cdto.getProductQty());
						order.setOrderDate(LocalDate.now());
						order.setQuantity(cdto.getProductQty());
						order.setTransactionMode(cdto.getTranscationMode());
						order.setPlanter(p);
						order.setName(cdto.getProductName());

						//
						flag = true;
						break;
					}
				}
				//
			}

		}

		if (flag) {

			PlantOrder p = oRepo.save(order);

			return p;

		} else
			throw new OrderException("No Detail found ");

	}

	public Customer getCustomer(Integer cid) {

		Optional<Customer> opt = cRepo.findById(cid);

		if (opt.isPresent())
			return opt.get();

		return null;

	}

	@Override
	public PlantOrder deleteOrder(Integer id) throws OrderException {

		Optional<PlantOrder> opt = oRepo.findById(id);

		if (opt.isPresent()) {

			PlantOrder p = opt.get();

			oRepo.delete(p);

			return p;

		}

		throw new OrderException("No Order Found wth this id" + id);

	}

	@Override
	public List<PlantOrder> viewAllOrder() throws OrderException {

		List<PlantOrder> orderList = oRepo.findAll();

		if (!orderList.isEmpty())
			return orderList;

		throw new OrderException("No Order History Found");

	}

}
