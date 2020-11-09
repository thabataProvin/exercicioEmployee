package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Employee employee;
		List<Employee> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
  
		System.out.println("How many employees will be registered?");
		int numberRegistry = scanner.nextInt();
  
		for(int i =0 ; i<numberRegistry; i++) {
			System.out.println();
			System.out.println("Employee #" + (i+1) + ":");
	  
			System.out.print("Id: ");
			Integer id = scanner.nextInt();
			
			while(hasId(list,id)){
				System.out.println("Try again: ");
				id = scanner.nextInt();
			}
	  
			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
		  
			System.out.print("Salary: ");
			Double salary = scanner.nextDouble();
		  
			employee = new Employee(id,name,salary);
			list.add(employee);
		}
		
		System.out.println();
		System.out.println("Enter the employee id that will have salary increase: ");
		Integer idIncrease = scanner.nextInt();
		System.out.println();
		employee = list.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		if(employee == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.println("Enter the percentage: ");
			double percentage = scanner.nextDouble();
			employee.increaseSalary(percentage); 		 
		}
		System.out.println("List of employees: ");
		for (Employee emp: list) {
			System.out.println(emp);
    	}
		scanner.close();
  
	}
	//para retry
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp !=null;
	}

}
