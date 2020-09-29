package be.abis.courseadmin.test;

import java.io.IOException;

import be.abis.courseadmin.model.Course;
import be.abis.courseadmin.model.Instructor;

public class TestCourseadmin {
	public static void main(String[] args) {
		Instructor instructor1 = new Instructor("Geert", "Lambrechts", 52, 16, 1000);
		Instructor instructor2 = new Instructor("Sandy", "Example", 65, 23, 2000);
		Instructor instructor3 = new Instructor("Piet", "Abis", 30, 20, 5000);

		Course course1 = new Course("JAVA", 10, 500, false);
		course1.addInstructor(instructor1);
		course1.addInstructor(instructor2);

		Course course2 = new Course("HTML", 5, 400, true);
		course2.addInstructor(instructor3);
		try {
			course1.printInfo();
			course2.printInfo();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
