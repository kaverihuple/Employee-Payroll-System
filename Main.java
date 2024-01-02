package com.huple;

import java.util.ArrayList;

abstract class Employee{
	private String name;
	
	private int id;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
		
	}
	
	public abstract double CalculateSalary();
	//using toString()method and override
	
	@Override
	
	public String toString() {

		return "Employee[name="+name+", id="+id+", salary="+CalculateSalary()+"]";
	}
	
	}


    
	  class FullTimeEmployee extends Employee{
		private double monthlySalary;
		public FullTimeEmployee(String name, int id, double monthlySalary) {
		
			super(name, id);
			this.monthlySalary = monthlySalary;
		}
		
		@Override
		
		public double CalculateSalary() {
			return monthlySalary;
			
			
		}
		
		
		
	}
	 
	    class PartTimeEmployee extends Employee{
             private int hoursWorked;
          private double hourlyrate;
		public PartTimeEmployee(String name, int id, double hourlyrate, int hoursWorked) {
			super(name, id);
			this.hoursWorked = hoursWorked;
			this.hourlyrate = hourlyrate;
		}
		
		@Override
		public double calculateSalary() {
			
			return hoursWorked * hourlyrate;
		}

		@Override
		public double CalculateSalary() {
			// TODO Auto-generated method stub
			return 0;
		}
		 
	 }
	  
	  class PayrollSystem{
		  private ArrayList<Employee> employeeList;
		  public PayrollSystem() {
			  employeeList = new ArrayList<>();
		  }
		  
		  public void addEmployee(Employee employee) {
			  employeeList.add(employee); // adding value in list
		  }
		  
		  //remove employee value 
		  
		  public void removeEmployee(int id) {
			  Employee employeeToRemove = null;
			  for(Employee employee : employeeList) {
				 if(employee.getId()==id){
					  employeeToRemove = employee;
					  break;
				  }
			  }
			  
			  if(employeeToRemove != null) {
				  employeeList.remove(employeeToRemove);
			  }
		  }
		  
		  public void displayEmployees() {
			  for(Employee employee: employeeList) {
				  System.out.println(employee);
			  }
		  }
	  }

	
public class Main {

	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();

		String name;
		int id;
		double monthlySalary;
		FullTimeEmployee emp1 = new FullTimeEmployee(name = "Huple", id= 1, monthlySalary= 8000.0);
		
		int hoursWorked;
		int hourlyRate;
		PartTimeEmployee emp2 = new PartTimeEmployee(name = "abc", id= 2, hoursWorked= 40, hourlyRate= 100);
		
		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		
		System.out.println("Initial Employee Details: ");
		payrollSystem.displayEmployees();
		
		System.out.println("Removing Employees");
		payrollSystem.removeEmployee(2);
		
		System.out.println("Ermaining Employees details: ");
		payrollSystem.displayEmployees();
		
	}

}


