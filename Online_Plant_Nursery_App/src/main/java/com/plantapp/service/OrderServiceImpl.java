package com.plantapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.exception.LoginException;
import com.plantapp.exception.OrderException;
import com.plantapp.model.CurrentUserSession;
import com.plantapp.model.Customer;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.Plant;
import com.plantapp.model.PlantOrder;
import com.plantapp.model.Planter;
import com.plantapp.model.Seed;
import com.plantapp.repository.CustomerRepo;
import com.plantapp.repository.OrderRepo;
import com.plantapp.repository.PlantDao;
import com.plantapp.repository.PlanterDao;
import com.plantapp.repository.SeedRepo;
import com.plantapp.repository.SessionDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo oRepo;

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	private PlanterDao planterRepo;

	@Autowired
	private CustomerRepo cDao;

	@Autowired
	private SessionDao sDao;

	@Autowired
	private PlantDao pDao;

	@Autowired
	private SeedRepo seedDao;

	@Override
	public PlantOrder placeOrder(CustomerDTO cdto, String key) throws OrderException, LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {

			throw new LoginException("Please login firset");

		}

		Customer customer = cDao.findByCusername(validCustomerSession.getUsername());

		PlantOrder order = new PlantOrder();

		boolean flag = false;

		List<Planter> plist = planterRepo.findAll();

		for (Planter p : plist) {
			List<Plant> plants = p.getPlants();

			List<Seed> seeds = p.getSeeds();

			if (!flag) {
				for (Plant a : plants) {
					if (a.getCommonName().equals(cdto.getProductName())) {

						if (a.getPlantStock() >= cdto.getProductQty()) {
							a.setPlantStock(a.getPlantStock() - cdto.getProductQty());

							order.setTotalCost(a.getPlantCost() * cdto.getProductQty());
							order.setOrderDate(LocalDate.now());
							order.setQuantity(cdto.getProductQty());
							order.setTransactionMode(cdto.getTranscationMode());
							order.setPlanter(p);
							order.setName(cdto.getProductName());
							order.setCustomer(customer);

							flag = true;

							if (flag) {

								customer.getOrders().add(order);
								PlantOrder detailOrder = oRepo.save(order);

								return detailOrder;

							}

						}
					}

				}

			} else if (!flag) {
				for (Seed a : seeds) {

					if (a.getCommonName().equals(cdto.getProductName())) {
						if (a.getSeedsStock() >= cdto.getProductQty()) {
							a.setSeedsStock(a.getSeedsStock() - cdto.getProductQty());
							order.setTotalCost(a.getSeedsCost() * cdto.getProductQty());
							order.setOrderDate(LocalDate.now());
							order.setQuantity(cdto.getProductQty());
							order.setTransactionMode(cdto.getTranscationMode());
							order.setPlanter(p);
							order.setName(cdto.getProductName());
							order.setCustomer(customer);
							flag = true;

							if (flag) {

								customer.getOrders().add(order);
								PlantOrder detailOrder = oRepo.save(order);

								return detailOrder;

							}

						}
					}
				}

			}
		}

		throw new OrderException("No Detail found ");

	}

	@Override
	public PlantOrder deleteOrder(Integer id) throws OrderException {

		Optional<PlantOrder> opt = oRepo.findById(id);

		boolean flag = false;

		if (opt.isPresent()) {

			PlantOrder p = opt.get();

			String name = opt.get().getName();

			List<Plant> plist = pDao.findByCommonName(name);

			Seed slist = seedDao.findBycommonName(name);

			if (!flag) {
				if (!plist.isEmpty()) {

					plist.get(0).setPlantStock(plist.get(0).getPlantStock() + p.getQuantity());

					pDao.save(plist.get(0));

					flag = true;

				}

			}

			if (!flag) {
				if (slist != null) {

					slist.setSeedsStock(slist.getSeedsStock() + p.getQuantity());

					seedDao.save(slist);

					flag = true;

				}
			}

			if (flag) {

				p.setPlanter(null);

				oRepo.delete(p);

				return p;

			}

		}

		throw new OrderException("No order detail found  this given id");

	}

	@Override
	public List<PlantOrder> viewAllOrder() throws OrderException {

		List<PlantOrder> orderList = oRepo.findAll();

		if (!orderList.isEmpty()) {

			return orderList;

		}

		throw new OrderException("No Order History Found");

	}

	@Override
	public PlantOrder getorderbyId(Integer id, String key) throws OrderException, LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {

			throw new LoginException("Please login firset");

		}

		Optional<PlantOrder> opt = oRepo.findById(id);

		if (opt.isPresent()) {

			return opt.get();

		}

		throw new OrderException("no order found with this id");
	}

}
