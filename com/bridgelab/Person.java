package com.bridgelab;

public class Person {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;

	Person(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber,
			String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		;
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Person() {

	}

	public Person(String firstName2, String lastName2, String address2, String city2, String state2, String email2,
			int zip2, long phoneNumber2) {
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.address = address2;
		this.city = city2;
		this.state = state2;
		this.zip = zip2;
		this.phoneNumber = phoneNumber2;
		this.email = email2;
		// TODO Auto-generated constructor stub
	}

	/**
	 * created method print to display the data
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
}
