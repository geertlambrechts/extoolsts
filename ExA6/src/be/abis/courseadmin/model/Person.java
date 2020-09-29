package be.abis.courseadmin.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	int personNumber;
	String firstName;
	String lastName;
	LocalDate birthdate;
	Company company;

	public Person(int personNumber, String firstName, String lastName, LocalDate birthdate, Company company) {
		this(personNumber, firstName, lastName, birthdate);
		this.company = company;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthdate) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;	
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
		Period p = Period.between(birthdate, LocalDate.now());
		return p.getYears();
	}
}
