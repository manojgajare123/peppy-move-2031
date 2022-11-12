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

@Entity
public class PlantOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;

	private String name;

	private LocalDate orderDate;

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

	public PlantOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlantOrder(Integer bookingOrderId, String name, LocalDate orderDate, String transactionMode,
			Integer quantity, Double totalCost, Customer customer, Planter planter) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.name = name;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.customer = customer;
		this.planter = planter;
	}

	@Override
	public String toString() {
		return "PlantOrder [bookingOrderId=" + bookingOrderId + ", name=" + name + ", orderDate=" + orderDate
				+ ", transactionMode=" + transactionMode + ", quantity=" + quantity + ", totalCost=" + totalCost
				+ ", customer=" + customer + ", planter=" + planter + "]";
	}

	public Integer getBookingOrderId() {
		return bookingOrderId;
	}

	public void setBookingOrderId(Integer bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Planter getPlanter() {
		return planter;
	}

	public void setPlanter(Planter planter) {
		this.planter = planter;
	}

}
