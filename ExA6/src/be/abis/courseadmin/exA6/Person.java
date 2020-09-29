package be.abis.courseadmin.exA6;

import java.time.LocalDate;

public class Person {
	int personNumber;
	String firstName;
	String lastName;
	LocalDate birthdate;
	Company company;

	public Person(int personNumber, String firstName, String lastName, LocalDate birthdate, Company company) {
		super();
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.company = company;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthdate) {
		this(personNumber, firstName, lastName, birthdate, null);
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String toString() {
		String returnString = firstName + " " + lastName + "(" + calculateAge() + " years old)";
		if (company != null) {
			returnString += " works for " + company.getName() + " in " + company.getAddress().getTown();
		} else {
			returnString += " is not employed for the moment";

		}

		return returnString;
	}

	public int calculateAge() {
		return LocalDate.now().getYear() - birthdate.getYear();
	}
}
