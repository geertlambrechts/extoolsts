package be.abis.courseadmin.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Instructor {
	private String firstName;
	private String lastName;
	private int age;
	private int ageStarted;
	private double salaryStarted;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
		
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
		
		
	public int getAge() {
		return age;
	}
	
	public void setAge (int age) {
		this.age = age;
	}
	
			
	public int getAgeStarted() {
		return ageStarted;
	}
	
	public void setAgeStarted (int ageStarted) {
		this.ageStarted = ageStarted;
	}
	
				
	public double getSalaryStarted() {
		return salaryStarted;
	}
	
	public void setSalaryStarted (double salaryStarted) {
		this.salaryStarted = salaryStarted;
	}
	
	public Instructor (String firstName, String lastName, int age, int ageStarted, double salaryStarted) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ageStarted = ageStarted;
		this.salaryStarted = salaryStarted;
		
	}
	
	public void printSalaryHistory (String outputfile) {
		  final int MAX_SENIORITY = 35;
		  final double SALARY_INCREASE = 1.03;
		  final int INCREASE_PERIOD = 5;
		  int increasedAge = ageStarted;
		  double increasedSalary = salaryStarted;
		  int currentAge = age;
		  
		  try {
			    FileWriter fileWriter = new FileWriter(outputfile,true);
				BufferedWriter out = new BufferedWriter(fileWriter);
				
				while (increasedAge <= currentAge && (increasedAge - ageStarted) <= MAX_SENIORITY ) {
					out.write("Salary of " + firstName + " at " + increasedAge + " is " + increasedSalary + "\n");
					increasedAge += INCREASE_PERIOD;
					increasedSalary *= SALARY_INCREASE;
				}
				out.write("Maximum Salary reached\n\n");
				
				out.close();
				
		  }
		  catch(IOException e1) {
			  System.out.println("Error writing file courseinfo.txt");
			  System.out.println(e1.getMessage());
			  return;
	      }
	}
	
	public void printSalaryHistory () {
		printSalaryHistory ("salaryhistory.txt");
	}
	
	
	public String toString(){
		return "InstructorData\n  firstName     : " + firstName+"\n  lastName      : "+ lastName + "\n  age           : "+ age+ "\n  ageStarted    : "+ ageStarted + "\n  salaryStarted : "+ salaryStarted + "\n";
	}
} 
