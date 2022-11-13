package com.plantapp.service;

import java.util.List;

import com.plantapp.exception.LoginException;
import com.plantapp.exception.OrderException;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.PlantOrder;

public interface OrderService {

	public PlantOrder placeOrder(CustomerDTO cdto, String key) throws OrderException, LoginException;

	public PlantOrder getorderbyId(Integer id, String key) throws OrderException, LoginException;

	public PlantOrder deleteOrder(Integer id) throws OrderException;

	public List<PlantOrder> viewAllOrder() throws OrderException;

	

}
