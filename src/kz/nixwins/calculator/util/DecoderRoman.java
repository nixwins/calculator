package kz.nixwins.calculator.util;

import java.util.Arrays;
import java.util.List;

import kz.nixwins.calculator.model.RomanNumber;

public class DecoderRoman  implements Decoder<String>{
	
	@Override
	public String[] decode(String[] romanNum) {
		
		String[] arabic = new String[2];
		List<RomanNumber> romanNumbers = RomanNumber.getList();

			for(int j=0; j < romanNumbers.size(); j++) {
				
				if(romanNum[0].startsWith(romanNumbers.get(j).name())) {
					arabic[0] = String.valueOf(romanNumbers.get(j).getArabic());
				}
				
				if(romanNum[1].startsWith(romanNumbers.get(j).name())) {
					arabic[1]= String.valueOf(romanNumbers.get(j).getArabic());
				}
			}
		
		return arabic;
	}

	
	

}
