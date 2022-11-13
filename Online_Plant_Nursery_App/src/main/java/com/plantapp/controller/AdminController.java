package com.plantapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantapp.exception.LoginException;
import com.plantapp.model.LoginDTO;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@PostMapping("/login")
	public ResponseEntity<String> CheckLogin(@RequestBody LoginDTO logindto) throws LoginException {

		if (logindto.getUserName().equals("admin") && logindto.getPassword().equals("admin@123")) {

			return new ResponseEntity<String>("Login successfull", HttpStatus.OK);
		}

		throw new LoginException("Detail Not Matched");
	}
}
