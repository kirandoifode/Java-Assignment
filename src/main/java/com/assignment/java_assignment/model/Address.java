package com.assignment.java_assignment.model;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo gio;
    
    public Address() {}
    
	public Address(String street, String suite, String city, String zipcode, Geo gio) {
		super();
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
		this.gio = gio;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Geo getGio() {
		return gio;
	}
	public void setGio(Geo gio) {
		this.gio = gio;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", zipcode=" + zipcode + ", gio="
				+ gio + "]";
	}

}
