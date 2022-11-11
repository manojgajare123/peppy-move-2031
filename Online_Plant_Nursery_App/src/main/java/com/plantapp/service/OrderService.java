package com.plantapp.service;

import java.util.List;

import com.plantapp.model.Customer;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.PlantOrder;
import com.plantapp.model.Planter;

public interface OrderService {

	public List<Planter> placeOrder(CustomerDTO cdto);

	public Customer getCustomer(Integer cid);
}
