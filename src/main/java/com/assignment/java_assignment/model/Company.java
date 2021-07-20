package com.assignment.java_assignment.model;


public class Company {
    private String name;
    private String chatchPhrase;
    private String bs;
	
	public Company() {}
	
	public Company(String name, String chatchPhrase, String bs) {
		super();
		this.name = name;
		this.chatchPhrase = chatchPhrase;
		this.bs = bs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChatchPhrase() {
		return chatchPhrase;
	}
	public void setChatchPhrase(String chatchPhrase) {
		this.chatchPhrase = chatchPhrase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", chatchPhrase=" + chatchPhrase + ", bs=" + bs + "]";
	}
}
