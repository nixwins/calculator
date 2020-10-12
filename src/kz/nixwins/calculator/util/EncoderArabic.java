package kz.nixwins.calculator.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kz.nixwins.calculator.model.RomanNumber;

public class EncoderArabic implements Encoder {

	@Override
	public String encoder(String arabicNum) {
		
//		List<BigRomanNumber> romanNumbers = BigRomanNumber.getList();
//
//		for(int j=0; j < romanNumbers.size(); j++) {
//			String arabicString = String.valueOf(romanNumbers.get(j).getArabic());
//			if(arabicNum.equals(arabicString)) {
//				return  String.valueOf(romanNumbers.get(j).name());
//			}
//			
//		
//		}
//		return "";
		return EncoderArabic.arabicToRoman(Integer.valueOf(arabicNum));
	}
	
	public static String arabicToRoman(int number) {
	    if ((number <= 0) || (number > 4000)) {
	        throw new IllegalArgumentException(number + " is not in range (0,4000]");
	    }

	    List<RomanNumber> romanNumerals = RomanNumber.getReverseSortedValues();

	    int i = 0;
	    StringBuilder sb = new StringBuilder();

	    while ((number > 0) && (i < romanNumerals.size())) {
	    	RomanNumber currentSymbol = romanNumerals.get(i);
	        if (currentSymbol.getValue() <= number) {
	            sb.append(currentSymbol.name());
	            number -= currentSymbol.getValue();
	        } else {
	            i++;
	        }
	    }

	    return sb.toString();
	}

}
