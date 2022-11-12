package com.plantapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;

	@Min(value = 1, message = "Planter height should be greater than 0")
	@NotNull(message = "Please provide height of planter")
	private Float planterHeight;

	@Min(value = 1, message = "Provided capacity should be atleast 1")
	@NotNull(message = "Please provide capacity of planter")
	private Integer planterCapacity;

	@Min(value = 1, message = "Provide minimum 1 drainage hole")
	@NotNull(message = "missing drainage holes")
	private Integer drainageHoles;

	@NotNull(message = "Provide planter color")
	private String planterColor;

	@NotNull(message = "Provide planter shape")
	private String planterShape;

	@NotNull(message = "Provide planter stock")
	@Min(value = 1, message = "Provide atleast 1 planter Stock")
	private Integer planterStock;

	@NotNull(message = "Provide planter stock")
	@Min(value = 0, message = "Cost should be greater than 0")
	private Integer planterCost;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "planter")
	private List<Plant> plants = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "planter")
	private List<Seed> seeds = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "planter")
	private List<PlantOrder> orders = new ArrayList<>();

}
