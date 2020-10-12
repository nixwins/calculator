package kz.nixwins.calculator.util;

import java.util.Arrays;
import java.util.List;

import kz.nixwins.calculator.model.RomanNumber;

public class DecoderRoman  implements Decoder<String>{
	
	@Override
	public String[] decode(String[] romanNum) {
		
		String[] arabic = new String[2];

		arabic[0] = romanToArabic(romanNum[0]); ///String.valueOf(romanNum[0]);
			
				
				
	    arabic[1] = romanToArabic(romanNum[1]);//String.valueOf(romanNum[1]);

		
		return arabic;
	}
	
	
	private String romanToArabic(String input) {
	    String romanNumeral = input.toUpperCase();
	    int result = 0;

	    List<RomanNumber> romanNumerals = RomanNumber.getReverseSortedValues();

	    int i = 0;

	    while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
	    	RomanNumber symbol = romanNumerals.get(i);
	        if (romanNumeral.startsWith(symbol.name())) {
	            result += symbol.getValue();
	            romanNumeral = romanNumeral.substring(symbol.name().length());
	        } else {
	            i++;
	        }
	    }

	    if (romanNumeral.length() > 0) {
	        throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
	    }

	    return String.valueOf(result);
	}

	
	

}
