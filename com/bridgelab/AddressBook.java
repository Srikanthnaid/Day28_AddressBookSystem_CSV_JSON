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

	/*
	 * Added Edit Contact Deatils method
	 */

	public void editContactDetails() {
		System.out.println("enter a name for edit:");
		String editName = sc.next();
		for (int i = 0; i < adressBook.size(); i++) {
			if (adressBook.get(i).getFirstName().equals(editName)) {
				System.out.println("select options");
				System.out.println("\n0.First Name\n1.Last Name\n2.Address\n3.City\n4.State\n5.Zip\n6.Phone Number");
				int editOption = sc.nextInt();
				// System.out.println("message"+editOption);
				switch (editOption) {
				case 1:
					System.out.println("Enter a First name:");
					String editFirstName = sc.next();
					adressBook.get(i).setFirstName(editFirstName);
					System.out.println(editFirstName);
					break;
				case 2:
					System.out.print("Enter a Last name:");
					adressBook.get(i).setLastName(sc.next());
					break;
				case 3:
					System.out.print("Enter a Address:");
					adressBook.get(i).setAddress(sc.next());
					break;
				case 4:
					System.out.print("Enter a city:");
					adressBook.get(i).setCity(sc.nextLine());
					break;
				case 5:
					System.out.print("Enter a state:");
					adressBook.get(i).setState(sc.nextLine());
					break;
				case 6:
					System.out.print("Enter a zip code:");
					adressBook.get(i).setZip(sc.nextInt());
					break;
				case 7:
					System.out.print("Enter a phone number:");
					adressBook.get(i).setPhoneNumber(sc.nextLong());
					break;
				case 8:
					System.out.print("Enter a email:");
					adressBook.get(i).setEmail(sc.nextLine());
					break;
				default:
					System.out.println("enter valid contact");
				}
			}
			System.out.println("Edited list is:");
			System.out.println(adressBook);
		}
	}
}
