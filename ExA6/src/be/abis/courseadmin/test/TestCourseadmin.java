package be.abis.courseadmin.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import be.abis.courseadmin.model.Address;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Person;

public class TestCourseadmin {

	public static void main(String[] args) {	
		Address address1 = new Address("Stationstraat", "5", "3000", "Leuven", "Belgium", "BE");
		Company company1 = new Company("ABIS", address1);
		Person person1 = new Person(5, "Ann", "Smits", LocalDate.of(1984, 9, 30), company1);
		Person person2 = new Person(5, "John", "Doe", LocalDate.of(1966, 5, 10));

		System.out.println("Person1:" + person1);
		System.out.println("Person2:" + person2);
		
		try {
			BufferedWriter bw = Files.newBufferedWriter(Paths.get("personinfo.txt"));
			bw.write ("Person1:" + person1 + "\n");
			bw.write ("Person2:" + person2 + "\n");
			bw.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
