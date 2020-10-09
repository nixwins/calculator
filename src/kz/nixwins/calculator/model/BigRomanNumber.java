package kz.nixwins.calculator.model;

import java.util.Arrays;
import java.util.List;

public enum BigRomanNumber {
	
	I(1), II(2), III(3), IV(4), V(5),
	VI(6), VII(7), VIII(8), IX(9), X(10), 
	XI(12),  XII(12),  XIII(10),  XIV(14),
	XV(15),  XVI(16), XVII(17), XVIII(18),
	XIX(19), XX(20);
	
	private int arabic;
	
	BigRomanNumber(int j) {
		arabic = j;
	}
	
	public int getArabic() { return arabic; }
	
	
	public static List<BigRomanNumber> getList() {
		return Arrays.asList(BigRomanNumber.values());
	}
}
