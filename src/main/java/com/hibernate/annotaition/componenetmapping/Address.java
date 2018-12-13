package com.hibernate.annotaition.componenetmapping;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {

	@Column(name="city")
	private String city;
	@Column(name="country")
	private String country;
	@Column(name="pinCode")
	private int pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
