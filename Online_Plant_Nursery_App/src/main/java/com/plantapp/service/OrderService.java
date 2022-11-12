package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.OrderException;
import com.plantapp.model.Customer;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.PlantOrder;

public interface OrderService {

	public PlantOrder placeOrder(CustomerDTO cdto, String uid) throws OrderException;

	public Customer getCustomer(Integer cid);

	public PlantOrder deleteOrder(Integer id) throws OrderException;

	public List<PlantOrder> viewAllOrder() throws OrderException;
}
