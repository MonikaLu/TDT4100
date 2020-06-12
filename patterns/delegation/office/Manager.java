package patterns.delegation.office;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	private List<Employee> employees;
	private int taskCount = 0;
	
//	throws illegalArgumentException if the employees is empty.
//	needs to delegate tasks fairly.
//	this class has more resources than Clerk.
	public Manager(List<Employee> employees) {
		if (employees.isEmpty()) {
			throw new IllegalArgumentException("Employees are required.");
		}
		this.employees = new ArrayList<Employee>(employees);
	}
	
	public Employee getDivided() {
		return this.employees.get(taskCount % employees.size());
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return this.getDivided().doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		taskCount++;
		this.getDivided().printDocument(document);
		
	}

	@Override
	public int getTaskCount() {
		return employees.stream().mapToInt(employee->employee.getTaskCount()).sum(); 
	}

	@Override
	public int getResourceCount() {
		return employees.stream().mapToInt(Employee::getResourceCount).reduce(1, Integer::sum);
	}
	
	
//	forstod ikke hva som skulle i main-metoden :(
	public static void main(String[] args) {
		Manager manager = new Manager(Clerk);
		
	}

}
