package com.bridgelab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookMain {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private Map<String, Person> contactMap;

	/**
	 * Create Class AddressBookMain
	 */

	public AddressBookMain() {
		contactMap = new HashMap<>();
	}

	/**
	 * Create the method and passing the Parameters
	 * 
	 * @param fname
	 * @param lname
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phno
	 * @param email
	 */

	public void addDetails(String fname, String lname, String address, String city, String state, String zip,
			String phno, String email) {
		Person p = new Person(fname, lname, address, city, state, zip, phno, email);
		String name = fname + " " + lname;
		contactMap.put(name, p);
	}

	/**
	 * Create ViewDetails method to Display the Person details
	 */

	public void viewDetails() {
		System.out.println(contactMap.size() + " entries");
		for (Map.Entry<String, Person> m : contactMap.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
	}

	/**
	 * Create ViewDetails method to Display the viewSortedDetails Person details
	 */

	public void viewSortedDetails() {
		Map<String, Person> sortedMap = contactMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		for (Map.Entry<String, Person> sm : sortedMap.entrySet()) {
			System.out.println(sm.getKey());
			System.out.println(sm.getValue());
		}
	}

	/**
	 * Create the class viewSortedCityDetails
	 */

	public void viewSortedCityDetails() {
		Map<String, Person> sortedCityMap = contactMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.comparing(Person::getCity))).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		for (Map.Entry<String, Person> sm : sortedCityMap.entrySet()) {
			System.out.println(sm.getValue().city);
			System.out.println(sm.getValue());
		}
	}

	/**
	 * Returns a Set view of the mappings contained in this map and edited details
	 * 
	 * @param fname
	 * @param lname
	 */

	public void editDetails(String fname, String lname) {
		for (Map.Entry<String, Person> m : contactMap.entrySet()) {
			if (m.getValue().fName.equals(fname) && m.getValue().lName.equals(lname)) {
				Person editedDetails = new Person(fname, lname, "Rachoti sm", "Gadag", "basva", "R111", "9868127",
						"rachotism@.com");
				contactMap.replace(m.getKey(), editedDetails);
				System.out.println("Edited Details of " + fname + " " + lname + ": " + editedDetails);
			}
		}
	}

	/**
	 * Returns a Set view of the mappings contained deleteDetails
	 * 
	 * @param fname
	 * @param lname
	 */

	public void deleteDetails(String fname, String lname) {
		for (Map.Entry<String, Person> m : contactMap.entrySet()) {
			if (m.getValue().fName.equals(fname) && m.getValue().lName.equals(lname)) {
				System.out.println("Deleted " + fname + " " + lname + " address");
				contactMap.remove(m.getKey());
				return;
			}
		}
	}

	/**
	 * Returns a Set view of the mappings contained viewPersonByState list of the
	 * Person
	 * 
	 * @param statename
	 */

	public void viewPersonByState(String statename) {
		List<Person> stateList = contactMap.values().stream().filter(p -> statename.equals(p.state))
				.collect(Collectors.toList());
		Map<String, List<Person>> personByState = stateList.stream().collect(Collectors.groupingBy(Person::getState));
		for (Map.Entry<String, List<Person>> m : personByState.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
		System.out.println("Number of person conatcts in " + statename + " is: " + stateList.stream().count());
	}

	public void viewPersonByCity(String cityname) {
		List<Person> cityList = contactMap.values().stream().filter(p -> cityname.equals(p.city))
				.collect(Collectors.toList());
		Map<String, List<Person>> personByCity = cityList.stream().collect(Collectors.groupingBy(Person::getCity));
		for (Map.Entry<String, List<Person>> m : personByCity.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());
		}
		System.out.println("Number of person conatcts in " + cityname + " is: " + cityList.stream().count());
	}

	/**
	 * writing address details using FILE_IO
	 */
	public void fileIOAddressBook() {
		AddressBookFileIO addressBookFile = new AddressBookFileIO(contactMap);
		addressBookFile.writeAddressBookFile(IOService.FILE_IO);
	}

	/**
	 * Counting Number of entries in file
	 */
	public void countAddressEntries() {
		AddressBookFileIO addressBookFile = new AddressBookFileIO(contactMap);
		addressBookFile.countEntries(IOService.FILE_IO);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addBook = new AddressBookMain();
		/**
		 * Writing address details in File
		 */
		addBook.addDetails("Rachoti", "Minajagii", "Kali Marg 257", "Karnataka", "Gadag", "582101", "9686124142",
				"rachotism@gmail.com");
		addBook.addDetails("Cristiano", "Ronaldoo", "Hollywood street101", "Porctuagal", "California", "C54106",
				"9948934563", "Cr7@gmail.com");
		addBook.viewDetails();
		System.out.println("--------Writing and reading address details in File--------");
		addBook.fileIOAddressBook();
		addBook.countAddressEntries();

		/**
		 * Counting Number of entries in file
		 */

		System.out.println("--------Writing and reading address details in CSV File--------");
		new PersonContactCsvFile().csvWriter();
		new PersonContactCsvFile().csvReader();
		/**
		 * Print the of Person details
		 */
		boolean flag = true;
		System.out.println("1. Edit address detail based on person name");
		System.out.println("2. Delete address detail based on person name");
		System.out.println("3. View person names by state");
		System.out.println("4. View person names by city");
		System.out.println("5. View sorted address details by person name");
		System.out.println("6. View sorted address details by city");
		System.out.println("7. Exit");

		/**
		 * Switch statement it display the Person Details Based on Condition
		 */
		while (flag) {

			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter name to edit its address");
				String fname = sc.next();
				String lname = sc.next();
				addBook.editDetails(fname, lname);
				break;
			case 2:
				System.out.println("Enter name to delete its address");
				String fdname = sc.next();
				String ldname = sc.next();
				addBook.deleteDetails(fdname, ldname);
				break;
			case 3:
				System.out.println("Enter the state name");
				sc.nextLine();
				String spname = sc.nextLine();
				addBook.viewPersonByState(spname);
				break;
			case 4:
				System.out.println("Enter the city name");
				sc.nextLine();
				String cpname = sc.nextLine();
				addBook.viewPersonByCity(cpname);
				break;
			case 5:
				System.out.println("Alphabetically sorted details");
				addBook.viewSortedDetails();
				break;
			case 6:
				System.out.println("sorted details by city");
				addBook.viewSortedCityDetails();
				break;
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Enter valid option");
			}
		}
		System.out.println("New address details");
		addBook.viewDetails();

	}
}
