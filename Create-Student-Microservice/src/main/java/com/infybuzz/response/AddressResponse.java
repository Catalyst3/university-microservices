package com.infybuzz.response;
public class AddressResponse {
	private long addressID;
	private String street;
	private String city;
	
	public long getAddressID() {
		return addressID;
	}
	public void setAddressID(long addressID) {
		this.addressID = addressID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
