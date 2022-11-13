package com.plantapp.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlantOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;

	@NonNull
	private String name;

	@NonNull
	private LocalDate orderDate;

	@NonNull
	private String transactionMode;

	private Integer quantity;

	private Double totalCost;

	@ManyToOne
	@JoinColumn(name = "cid")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Customer customer;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Planter planter;

	
}
