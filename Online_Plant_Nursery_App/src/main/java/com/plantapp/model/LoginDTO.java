package com.plantapp.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDTO {

	@NotNull(message = "Username should not null")
	private String userName;
	@NotNull(message = "Password should not be null")
	private String password;

}
