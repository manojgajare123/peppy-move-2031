package com.plantapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.model.Customer;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.PlantOrder;
import com.plantapp.model.Planter;
import com.plantapp.service.OrderService;
import com.plantapp.service.PlanterService;

@RestController

public class OrderController {

	@Autowired
	private OrderService oService;

	@Autowired
	private PlanterService pservice;

	@PostMapping("/addorder")
	public List<Planter> saveOrder(@RequestBody CustomerDTO cdto) {

		return oService.placeOrder(cdto);
		
	}

}
