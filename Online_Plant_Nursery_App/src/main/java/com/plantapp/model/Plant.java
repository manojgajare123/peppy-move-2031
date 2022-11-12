package com.plantapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;

	private Integer plantHeight;

	private String plantSpread;
	
	@Column(unique = true)
	private String commonName;

	private String bloomTime;

	private String medicinalOrCulinaryUse;

	private String temparature;
	
	private String typeOfPlant;

	private String plantDescription;
	private Integer plantStock;
	private Double plantCost;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="planterId")
	@JsonIgnore
	private Planter planter;
	
}
	
	

	