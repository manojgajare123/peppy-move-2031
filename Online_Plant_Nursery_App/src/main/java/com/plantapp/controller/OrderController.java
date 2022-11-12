package com.plantapp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.OrderException;
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

	@PostMapping("/addorder/{uuid}")
	public PlantOrder saveOrder(@PathVariable("uuid") String uid, @RequestBody CustomerDTO cdto) throws OrderException {

		PlantOrder order = oService.placeOrder(cdto, uid);

		return order;

	}

	@GetMapping("/viewall")
	public List<PlantOrder> viewAllorder() throws OrderException {

		return oService.viewAllOrder();
	}

	@GetMapping("/order/{id}")
	public PlantOrder getOrderbyId(@PathVariable("id") Integer id) throws OrderException {

		return oService.deleteOrder(id);
	}

}
