package com.plantapp.service;

import com.plantapp.exception.LoginException;
import com.plantapp.model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
