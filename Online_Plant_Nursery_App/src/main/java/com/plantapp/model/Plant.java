package com.plantapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;

	private Integer plantHeight;

	private String plantSpread;

	private String commonName;

	private String bloomTime;

	private String medicinalOrCulinaryUse;

	private String temparature;

	private String typeOfPlant;

	private String plantDescription;
	private Integer plantStock;
	private Double plantCost;
	
	@JsonIgnore
	@ManyToOne (cascade = CascadeType.ALL)
	private Planter planter;
	
}
	
	

	