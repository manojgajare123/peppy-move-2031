package com.plantapp.model;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
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
  
  public Seed() {
	// TODO Auto-generated constructor stub
}

public Seed(Integer seedId, String commonName, String bloomTime, String watering, String difficultyLevel,
		String temperature, String typeOfSeeds, String seedDescription, Integer seedsStock, double seedsCost,
		Integer seedsPerPacket) {
	super();
	this.seedId = seedId;
	this.commonName = commonName;
	this.bloomTime = bloomTime;
	this.watering = watering;
	this.difficultyLevel = difficultyLevel;
	this.temperature = temperature;
	this.typeOfSeeds = typeOfSeeds;
	this.seedDescription = seedDescription;
	this.seedsStock = seedsStock;
	this.seedsCost = seedsCost;
	this.seedsPerPacket = seedsPerPacket;
}

public Integer getSeedId() {
	return seedId;
}

public void setSeedId(Integer seedId) {
	this.seedId = seedId;
}

public String getCommonName() {
	return commonName;
}

public void setCommonName(String commonName) {
	this.commonName = commonName;
}

public String getBloomTime() {
	return bloomTime;
}

public void setBloomTime(String bloomTime) {
	this.bloomTime = bloomTime;
}

public String getWatering() {
	return watering;
}

public void setWatering(String watering) {
	this.watering = watering;
}

public String getDifficultyLevel() {
	return difficultyLevel;
}

public void setDifficultyLevel(String difficultyLevel) {
	this.difficultyLevel = difficultyLevel;
}

public String getTemperature() {
	return temperature;
}

public void setTemperature(String temperature) {
	this.temperature = temperature;
}

public String getTypeOfSeeds() {
	return typeOfSeeds;
}

public void setTypeOfSeeds(String typeOfSeeds) {
	this.typeOfSeeds = typeOfSeeds;
}

public String getSeedDescription() {
	return seedDescription;
}

public void setSeedDescription(String seedDescription) {
	this.seedDescription = seedDescription;
}

public Integer getSeedsStock() {
	return seedsStock;
}

public void setSeedsStock(Integer seedsStock) {
	this.seedsStock = seedsStock;
}

public double getSeedsCost() {
	return seedsCost;
}

public void setSeedsCost(double seedsCost) {
	this.seedsCost = seedsCost;
}

public Integer getSeedsPerPacket() {
	return seedsPerPacket;
}

public void setSeedsPerPacket(Integer seedsPerPacket) {
	this.seedsPerPacket = seedsPerPacket;
}

@Override
public String toString() {
	return "Seeds [seedId=" + seedId + ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering="
			+ watering + ", difficultyLevel=" + difficultyLevel + ", temperature=" + temperature + ", typeOfSeeds="
			+ typeOfSeeds + ", seedDescription=" + seedDescription + ", seedsStock=" + seedsStock + ", seedsCost="
			+ seedsCost + ", seedsPerPacket=" + seedsPerPacket + "]";
}
  
  
  
  
  
}
