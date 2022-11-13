package com.plantapp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.LoginException;
import com.plantapp.exception.OrderException;
import com.plantapp.model.Customer;
import com.plantapp.model.CustomerDTO;
import com.plantapp.model.PlantOrder;
import com.plantapp.model.Planter;
import com.plantapp.service.OrderService;
import com.plantapp.service.PlanterService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService oService;

	@Autowired
	private PlanterService pservice;

	@PostMapping("/add/{key}")
	public ResponseEntity<PlantOrder> saveOrder(@PathVariable("key") String key, @RequestBody CustomerDTO cdto)
			throws OrderException, LoginException {

		PlantOrder order = oService.placeOrder(cdto, key);

		return new ResponseEntity<>(order, HttpStatus.CREATED);

	}

	@GetMapping("/orders")
	public ResponseEntity<List<PlantOrder>> viewAllorder() throws OrderException {

		List<PlantOrder> order = oService.viewAllOrder();

		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PlantOrder> getOrderbyId(@PathVariable("id") Integer id) throws OrderException {

		PlantOrder order = oService.deleteOrder(id);

		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
	}

	@GetMapping("/view/{id}/{key}")
	public ResponseEntity<PlantOrder> getOrderDetailbyId(@PathVariable("id") Integer id,
			@PathVariable("key") String key) throws OrderException, LoginException {

		PlantOrder order = oService.getorderbyId(id, key);

		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
	}

	

}
