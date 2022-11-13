package com.plantapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyErrorDetails {

	private LocalDateTime localDateTime;
	private String message;
	private String details;
	
	
}
