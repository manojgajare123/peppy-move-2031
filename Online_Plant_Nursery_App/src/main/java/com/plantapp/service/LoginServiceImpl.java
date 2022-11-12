package com.plantapp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantapp.model.CurrentUserSession;
import com.plantapp.repository.CustomerRepo;
import com.plantapp.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepo cDao;

	@Autowired
	private SessionDao sDao;

	@Override
	public String logIntoAccount(com.plantapp.model.LoginDTO dto) throws com.plantapp.exception.LoginException {

		com.plantapp.model.Customer existingCustomer = cDao.findByCusername(dto.getUserName());

		if (existingCustomer == null) {

			throw new com.plantapp.exception.LoginException("Please Enter a valid user name");

		}

		Optional<CurrentUserSession> validCustomerSessionOpt = sDao.findById(existingCustomer.getCid());

		if (validCustomerSessionOpt.isPresent()) {

			throw new com.plantapp.exception.LoginException("User already Logged In with this username");

		}

		if (existingCustomer.getCpassword().equals(dto.getPassword())) {

			String key = RandomString.make(6);

//			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCid(), key,
//					LocalDateTime.now());

			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCid(), key,
					dto.getUserName(), LocalDateTime.now());

			sDao.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new com.plantapp.exception.LoginException("Please Enter a valid password");

	}

	@Override
	public String logOutFromAccount(String key) throws com.plantapp.exception.LoginException {
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new com.plantapp.exception.LoginException("User Not Logged In with this User name");

		}

		sDao.delete(validCustomerSession);

		return "Logged Out !";

	}

}
