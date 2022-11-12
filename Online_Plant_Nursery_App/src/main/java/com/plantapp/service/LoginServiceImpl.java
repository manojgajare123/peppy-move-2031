package com.plantapp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String logIntoAccount(com.plantapp.model.LoginDTO dto) throws com.plantapp.exception.LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logOutFromAccount(String key) throws com.plantapp.exception.LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
