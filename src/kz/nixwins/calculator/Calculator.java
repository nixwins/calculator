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

	public static void init(Map<String, String> expMap) {
		
		Calculator calc = new Calculator();
		calc.operandLeft = Integer.valueOf(expMap.get("operandLeft"));
		calc.operandRight = Integer.valueOf(expMap.get("operandRight"));
		calc.arithmeticOperator = expMap.get("operator");
		
		calc.calculate();
	}
	
	private void calculate() {
		
		switch(arithmeticOperator) {
		
		case "+":
			System.out.println("output: " + add(operandLeft, operandRight));
			break;
		case "-":
			System.out.println("output: " + substraction(operandLeft, operandRight));
			break;
		case "*":
			System.out.println("output: " + multiplication(operandLeft, operandRight));
			break;
		case "/":
			System.out.println("output: " + division(operandLeft, operandRight));
			break;
			
		default:
			break;
		}
	}
}
