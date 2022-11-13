package com.plantapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;
	
	@NotEmpty(message = "Common name of seed is missing")
	@Column(unique = true)
	private String commonName;
	
	@NotEmpty(message = "Bloom time for seed need to be mentioned")
	private String bloomTime;
	
	@NotEmpty(message = "Watering process need to be mentioned")
	private String watering;
	
	@NotEmpty(message = "Difficulty level for seed should be there")
	private String difficultyLevel;
	
	@NotEmpty(message = "Temparature need to be mentioned")
	private String temperature;
	
	@NotEmpty(message = "Seed type is missing")
	private String typeOfSeeds;
	
	@NotEmpty(message = "Seed description should not be empty")
	@Size(min = 5, max = 500, message = "Minimun seed description size must be greater than 5 and less than 500")
	private String seedDescription;
	
	@NotNull(message = "Stock size must be there")
	@Min(value = 1, message = "Seed stock must be greate than 0")
	private Integer seedsStock;
	
	@NotNull(message = "Seed cost should be there")
	@Min(value = 1, message = "Seed cost must be greate than 0")
	private double seedsCost;
	
	@NotNull(message = "Seed packet not to be empty")
	@Min(value = 1, message = "Minimun 1 seed required in a packet")
	private Integer seedsPerPacket;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "planterId")
	private Planter planter;

}
