package kz.nixwins.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.sun.istack.internal.FinalArrayList;
import kz.nixwins.calculator.model.RomanNumber;
import kz.nixwins.calculator.util.Decoder;
import kz.nixwins.calculator.util.DecoderRoman;


public class ExpressionParser {

	private boolean isRoman = false;
	private final Validator validator = new Validator();
	private final Map<String, String> expMap = new HashMap<String, String>();
	
	public Map<String, String> parser(final String expStr) throws Throwable {
	
		if(validator.isValidExpLen(expStr)) {
			
			String[] arr = expStr.split("[+*-/]");
			
			if(arr.length == 2) {
				
				initArithmeticOperator(expStr);
				
				if(validator.isMixedExpression(arr)) {
					
					throw new Exception("Mixed expression: " + expStr);
					
				}else if(validator.isArabicNumber(arr)) {
					
					initExpressoion(arr);
			
				}else if(validator.isRomanNumber(arr)) {
					
					Decoder<String> decoderRoman = new DecoderRoman();
					String[] arabicNums= decoderRoman.decode(arr);
					romanNumberToUppercase(arr);
					isRoman = true;
					//System.out.println("HERE " + Arrays.toString(arabicNums));
					initExpressoion(arabicNums);
					
				}else {
					throw new IllegalArgumentException("Expresion  invalid");
				}
				
				
			}else { throw new Exception("InvalidExpresion"); }
				
		}

		return expMap;		
	}
	
	public void initArithmeticOperator(final String expStr) {
		
		try {

			Character arithmeticOperator = findArithmeticOperator(expStr).charAt(0);

			if (validator.isArithmeticOperantion(arithmeticOperator)) {

				expMap.put("operator", arithmeticOperator.toString());
			}
		} catch (Exception e) { System.out.println(e.getMessage());}
	}
	
	private void initExpressoion(final String[] numbers) throws Throwable {
		
		Integer operandLeft  = Integer.valueOf(numbers[0]);
		Integer oprenadRight = Integer.valueOf(numbers[1]);
		
		if(validator.isValidRangeNumber(operandLeft) && validator.isValidRangeNumber(oprenadRight)){
			
			expMap.put("operandLeft", operandLeft.toString());
			expMap.put("operandRight", oprenadRight.toString());
			
		}else { throw new Exception("OutOfRange must be 1-10"); }
		
	}
	
	
	private String findArithmeticOperator(final String exp) throws Exception {
		
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
	
	public boolean getIsRoman() {
		return isRoman;
	}
	
	public void romanNumberToUppercase(String[] nums) {
		
		for(int i=0; i < nums.length; i++) {
			nums[i].toUpperCase();
		}
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
		
		public boolean isMixedExpression(final String[] numbers) {
			
			boolean isArabic = false;
			boolean isRoman = false;

			for(int i=0; i < numbers.length; i++) {
				
				if(Character.isDigit(numbers[i].charAt(0))) {
					isArabic = true;
				}
				
				if(Character.isAlphabetic(numbers[i].charAt(0))) {
					isRoman = true;
				}
			}
			
			if(isArabic && isRoman) return true;
			
			return false;
		}
		
		public boolean isRomanNumber(final String[] numbers) {
			
			 boolean operandLeftIsRoman = false;
			 boolean operandRightIsRoman = false;
			 
			 List<RomanNumber> romanNumber = RomanNumber.getList();
			 String operandLeft = numbers[0];
			 String operandRight = numbers[1];
	
			for (int j = 0; j < romanNumber.size(); j++) {
				
				String romanNumStr = String.valueOf(romanNumber.get(j));
				
				if(operandLeft.equals(romanNumStr)) {
					operandLeftIsRoman = true;
				} 
				
				if(operandRight.equals(romanNumStr)) {
					operandRightIsRoman = true;
				}
			}
			
			if(operandLeftIsRoman && operandRightIsRoman) return true;

			return false;
		}
		
	
		public boolean isArabicNumber(final String[] numbers) {
			
			for(int i=0; i < numbers.length; i++) {
				
				if(Character.isDigit(numbers[i].charAt(0))) {
					return true;
				}
			}
			
			return false;
		}
		
		private boolean isValidExpLen(final String exp) {
			
			return (exp.length() >= MIN_LEN && exp.length() <= MAX_LEN);

		}
		
		public boolean isValidRangeNumber(final int num) {
			
			return (num >= RANGE_START && num <= RANGE_END );
			
		}
		
		public boolean isArithmeticOperantion(final Character op) {
			
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
