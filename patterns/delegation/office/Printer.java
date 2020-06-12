package patterns.delegation.office;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Printer {
	
	
		private Map<Employee, Collection<String>> printHistory = new HashMap<>();

//		The method will print the document.
//		if the dictionary doesn't contain the key employee,
//		then the method puts employee as a key to the dictionary,
//		and gives it the value of an arraylist.
//		Then it will get the value corresponding the key "employee",
//		and add document to the historylist.
		
		public void printDocument(String document, Employee employee) {
			System.out.println(document);
			
			if (!printHistory.containsKey(employee)) {
				printHistory.put(employee, new ArrayList<String>());
			}
			
			this.printHistory.get(employee).add(document);
		}
		
//		return a list with all the printed documents, in chronological order.
//		if the printHistory dictionary doesn't have a key named employee
//		then it will return an immutable list.
//		It will then return the value of employee.

		public List<String> getPrintHistory(Employee employee) {
			if (!printHistory.containsKey(employee)) {
				return Collections.emptyList();
			}
			return new ArrayList<>(printHistory.get(employee));
		}
}
