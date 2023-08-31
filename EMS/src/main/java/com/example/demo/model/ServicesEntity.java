package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServicesEntity {
	@Id
	private int serviceId;
	private String providerName;
	public ServicesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServicesEntity(int serviceId, String providerName) {
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
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
}
