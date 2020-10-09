package kz.nixwins.calculator.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kz.nixwins.calculator.model.BigRomanNumber;
import kz.nixwins.calculator.model.RomanNumber;

public class EncoderArabic implements Encoder {

	@Override
	public String encoder(String arabicNum) {
		
		List<BigRomanNumber> romanNumbers = BigRomanNumber.getList();

		for(int j=0; j < romanNumbers.size(); j++) {
			String arabicString = String.valueOf(romanNumbers.get(j).getArabic());
			if(arabicNum.equals(arabicString)) {
				return  String.valueOf(romanNumbers.get(j).name());
			}
			
		
		}
		return "";
	}

}
