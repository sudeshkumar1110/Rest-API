package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="eventdetails")
public class EventEntity {
	@Id
	private int customerId;
	private String customerName,eventType;
	private Date eventDate;
	private long eventBudget;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="VenueId")
	public VenueDetails vd;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public long getEventBudget() {
		return eventBudget;
	}
	public void setEventBudget(long eventBudget) {
		this.eventBudget = eventBudget;
	}
	public VenueDetails getVd() {
		return vd;
	}
	public void setVd(VenueDetails vd) {
		this.vd = vd;
	}
	public EventEntity(int customerId, String customerName, String eventType, Date eventDate, long eventBudget,
			VenueDetails vd) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventBudget = eventBudget;
		this.vd = vd;
	}
	public EventEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
