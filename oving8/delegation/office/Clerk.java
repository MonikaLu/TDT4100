package patterns.delegation.office;

import java.util.List;
import java.util.function.BinaryOperator;

import javafx.print.Printer;
//fikk ikke brukte noen av metodene fra Printer, forstår ikke hvorfor.
//This class delegates printDocument to Printer. getResourceCount() is always 1, because it only has one employee

public class Clerk implements Employee{
	private Printer printer;
	private int taskCount = 0;
//	Printer printer = new Printer();
	
//	declare the value of printer to the parameter of this method.
	public Clerk(Printer printer) {
		this.printer = printer;
	}
	
//	taskCount increase one by one.
//	applies the values to the binaryoperator.
	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		taskCount++;
		return operation.apply(value1,  value2);
	}

//	
	@Override
	public void printDocument(String document) {
		this.printer.printDocument(document, this);
		
	}

	@Override
	public int getTaskCount() {
		return this.printer.getPrintHistory(this).size() + this.taskCount;
	}

	@Override
	public int getResourceCount() {
		return 1;
	}

}
