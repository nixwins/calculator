package kz.nixwins.calculator;

import java.util.Map;

public class Calculator {

	private Integer operandLeft;
	private Integer operandRight;
	private String arithmeticOperator;
	
	private int add(int operandLeft, int operandRight) {
		return operandLeft+operandRight;
	}
	
	private int substraction(int operandLeft, int operandRight) {
		return operandLeft - operandRight;
	}
	
	private int multiplication(int operandLeft, int operandRight) {
		return operandLeft*operandRight;
	}
	
	private int division(int operandLeft, int operandRight) {
		return operandLeft/operandRight;
	}

	public void init(Map<String, String> expMap) {
		
		
		operandLeft = Integer.valueOf(expMap.get("operandLeft"));
		operandRight = Integer.valueOf(expMap.get("operandRight"));
		arithmeticOperator = expMap.get("operator");
		
		//calc.calculate();
	}
	
	public int calculate() {
		
		switch(arithmeticOperator) {
		
		case "+":
			return add(operandLeft, operandRight);
		case "-":
			return substraction(operandLeft, operandRight);			
		case "*":
			return multiplication(operandLeft, operandRight);
		case "/":
			return division(operandLeft, operandRight);		
		default:
			return 0;
		}
		
		
	}
}
