package com.assignment.java_assignment.model;

import java.math.BigDecimal;

public class Geo {
	private BigDecimal lat;
	private BigDecimal lng;
	
	public Geo() {}
	
	public Geo(BigDecimal lat, BigDecimal lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "Geo [lat=" + lat + ", lng=" + lng + "]";
	}
}
