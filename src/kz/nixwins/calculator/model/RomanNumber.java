package kz.nixwins.calculator.model;

import java.util.Arrays;
import java.util.List;



public enum RomanNumber {

	I(1), II(2), III(3), IV(4), V(5),
	VI(6), VII(7), VIII(8), IX(9), X(10);
	
	private int arabic;
	
	RomanNumber(int j) {
		arabic = j;
	}
	
	public int getArabic() { return arabic; }
	
	
	public static List<RomanNumber> getList() {
		return Arrays.asList(RomanNumber.values());
	}
}
