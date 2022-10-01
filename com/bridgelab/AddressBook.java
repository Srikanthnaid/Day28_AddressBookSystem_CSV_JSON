package com.bridgelab;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Person> adressBook = new ArrayList<Person>();

	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Problem");
		System.out.println("Enter a first name:");
		String firstName = sc.next();
		System.out.println("Enter a last name:");
		String lastName = sc.next();
		System.out.println("Enter a Address:");
		String address = sc.next();
		System.out.println("Enter a City name:");
		String city = sc.next();
		System.out.println("Enter a state:");
		String state = sc.next();
		System.out.println("Enter a email:");
		String email = sc.next();
		System.out.println("Enter a zip code:");
		int zip = sc.nextInt();
		System.out.println("Enter a phone number:");
		long phoneNumber = sc.nextLong();

		Person details1 = new Person(firstName, lastName, address, city, state, email, zip, phoneNumber);
		adressBook.add(details1);
		System.out.print(adressBook);
		System.out.println("succesfully created contacts");
	}
}
