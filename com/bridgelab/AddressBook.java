package com.bridgelab;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> adressBook = new ArrayList<Person>();

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Problem");
		AddressBook addressBookList = new AddressBook();
		addressBookList.addContactDetails();
	}

	/*
	 * create Add contact details method
	 */
	public void addContactDetails() {
		Person details = new Person();
		System.out.println("Enter a first name:");
		String firstName = sc.next();
		details.setFirstName(sc.next());
		System.out.println("Enter a last name:");
		String lastName = sc.next();
		details.setLastName(sc.next());
		System.out.println("Enter a Address:");
		String address = sc.next();
		details.setAddress(sc.next());
		System.out.println("Enter a City name:");
		String city = sc.next();
		details.setCity(sc.next());
		System.out.println("Enter a state:");
		String state = sc.next();
		details.setState(sc.next());
		System.out.println("Enter a email:");
		String email = sc.next();
		details.setEmail(sc.next());
		System.out.println("Enter a zip code:");
		int zip = sc.nextInt();
		details.setZip(sc.nextInt());
		System.out.println("Enter a phone number:");
		long phoneNumber = sc.nextLong();
		details.setPhoneNumber(sc.nextLong());

		adressBook.add(details);
		Person details1 = new Person(firstName, lastName, address, city, state, email, zip, phoneNumber);
		adressBook.add(details1);
		System.out.print(adressBook);
		System.out.println("succesfully added person new contacts");
	}
}
