package com.assignment.java_assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
*/
//@Entity
public class User {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private Long id;
	//@Column
	@JsonProperty
    private String name;
	//@Column  
	@JsonProperty
    private String username;
	//@Column  
	@JsonProperty
    private String email;
	//@Column  
	@JsonProperty
    private String phone;
	//@Column  
	@JsonProperty
    private String website;
	//@Column  
	@JsonProperty
    private Address address;
	//@Column  
	@JsonProperty
    private Company company;
	
	public User() {
        super();
    }

	public User(Long id, String name, String username, String email, String phone, String website, Address address,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.address = address;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone
				+ ", website=" + website + ", address=" + address + ", company=" + company + "]";
	}

}
