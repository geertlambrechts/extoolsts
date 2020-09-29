package be.abis.courseadmin.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Instructor {
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private int ageStarted;
	private double salaryStarted;
	
	public Instructor (String firstName, String lastName, LocalDate birthday, int ageStarted, double salaryStarted) throws AgeCannotBeNegativeException { 
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		if (ageStarted < 0) {
			throw new AgeCannotBeNegativeException();
		}
		this.ageStarted = ageStarted;
		this.salaryStarted = salaryStarted;		
	}
	
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
		
		
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday (LocalDate birthday) {
		this.birthday = birthday;
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
	
	public String toString(){
		return "InstructorData\n  firstName     : " + firstName+"\n  lastName      : "+ lastName + "\n  birthday      : "+ birthday.toString()+ "\n  ageStarted    : "+ ageStarted + "\n  salaryStarted : "+ salaryStarted + "\n";
	}
	
	public void printSalaryHistory (String outputfile) {
		  final int MAX_SENIORITY = 35;
		  final double SALARY_INCREASE = 1.03;
		  final int INCREASE_PERIOD = 5;
		  int increasedAge = ageStarted;
		  double increasedSalary = salaryStarted;
		  int currentAge = LocalDate.now().getYear() - birthday.getYear();
		  
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
	
} 
