package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServicesEntity {
	@Id
	private int serviceId;
	private int providerName;
	public ServicesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServicesEntity(int serviceId, int providerName) {
		super();
		this.serviceId = serviceId;
		this.providerName = providerName;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getProviderName() {
		return providerName;
	}
	public void setProviderName(int providerName) {
		this.providerName = providerName;
	}
	
}
