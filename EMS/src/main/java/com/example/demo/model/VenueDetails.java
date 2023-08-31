package com.example.demo.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class VenueDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int VenueId;
	private String Venue;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<ServicesEntity> ser;
	public VenueDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VenueDetails(int venueId, String venue, List<ServicesEntity> ser) {
		super();
		VenueId = venueId;
		Venue = venue;
		this.ser = ser;
	}
	public int getVenueId() {
		return VenueId;
	}
	public void setVenueId(int venueId) {
		VenueId = venueId;
	}
	public String getVenue() {
		return Venue;
	}
	public void setVenue(String venue) {
		Venue = venue;
	}
	public List<ServicesEntity> getSer() {
		return ser;
	}
	public void setSer(List<ServicesEntity> ser) {
		this.ser = ser;
	}
	
}
