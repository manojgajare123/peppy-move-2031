package com.plantapp.model;

import javax.persistence.*;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
  private Integer seedId;
  private  String commonName;
  private String bloomTime;
  private String watering;
  private String difficultyLevel;
  private String temperature;
  private String typeOfSeeds;
  private String seedDescription;
  private Integer seedsStock;
  private double seedsCost;
  private Integer seedsPerPacket;
  
  @JsonIgnore
	@ManyToOne (cascade = CascadeType.ALL)
	private Planter planter;
	
  
  
}
