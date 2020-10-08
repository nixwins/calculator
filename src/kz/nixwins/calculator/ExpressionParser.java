package kz.nixwins.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

	private final Validator validator = new Validator();
	
	public Map<String, String> parser(String expStr) throws Throwable {
		
		final Map<String, String> expMap = new HashMap<String, String>();
			
		if(validator.isValidExpLen(expStr)) {
			
			String[] arr = expStr.split("[+*-/]");
			
			if(arr.length == 3) {
				
				Integer operandLeft  = Integer.valueOf(arr[0]);
				Integer oprenadRight = Integer.valueOf(arr[1]);
				
				if(validator.isValidRangeNumber(operandLeft) && validator.isValidRangeNumber(oprenadRight)){
					expMap.put("operandLeft", operandLeft.toString());
					
					expMap.put("operandRight", oprenadRight.toString());
				}else {
					throw new Exception("OutOfRange must be 1-10");
				}
			
				
				
				try {
					
					Character arithmeticOperator = findArithmeticOperator(expStr).charAt(0);
				
					if(validator.isArithmeticOperantion(arithmeticOperator)) {
					
						expMap.put("operator", arithmeticOperator.toString());
					}	
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}else throw new Exception("UnsupportedArithmeticOperator");
				
		}

		return expMap;		
	}
	
	
	
	private String findArithmeticOperator(String exp) throws Exception {
		
		Character op = null;
		
		Character[] supOperation = validator.getSupportedOperation();

		outerloop:	
		for(int i=0; i < exp.length(); i++) {
			
			for(int j=0; j < supOperation.length; j++) {
				
				if(exp.charAt(i) == supOperation[j]) {
					op = exp.charAt(i);
					break outerloop;
				}		
			}
		}
		 if(op == null) throw new Exception("UnsupportedArithmeticOperation");
		
		return op.toString();
		
	}
	class Validator{
		
		private final int  MAX_LEN = 7; // 10 + 10
		private final int MIN_LEN = 3;  // 1+2
		private final int RANGE_START = 1;
		private final int RANGE_END =  10;
		
		private final Character[] supportedOperation = new Character[4];
		
		public Character[] getSupportedOperation() {
			return supportedOperation;
		}



		Validator() {
			
			supportedOperation[0] = '+';
			supportedOperation[1] = '-';
			supportedOperation[2] = '/';
			supportedOperation[3] = '*';
		}
		
		
		
		private boolean isValidExpLen(String exp) {
			return (exp.length() >= MIN_LEN && exp.length() <= MAX_LEN);

		}
		
		public boolean isValidRangeNumber(int num) {
			return (num >= RANGE_START && num <= RANGE_END );
		}
		
		public boolean isArithmeticOperantion(Character op) {
			
			boolean flag = false;
			
			for(int i=0; i < supportedOperation.length; i++) {
				
				if(supportedOperation[i].equals(op)) {
					flag = true;
					break;
				}
				
			}
			return flag;
			
		}
	}
}
