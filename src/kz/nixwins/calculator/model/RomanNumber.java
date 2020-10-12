package kz.nixwins.calculator.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public enum RomanNumber {

//	I(1), II(2), III(3), IV(4), V(5),
//	VI(6), VII(7), VIII(8), IX(9), X(10);
//	
//	private int arabic;
//	
//	RomanNumber(int j) {
//		arabic = j;
//	}
//	
//	public int getArabic() { return arabic; }
//	
//	

	
	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

	public static List<RomanNumber> getList() {
		return Arrays.asList(RomanNumber.values());
	}

	private int value;

	RomanNumber(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static List<RomanNumber> getReverseSortedValues() {
		return Arrays.stream(values()).sorted(Comparator.comparing((RomanNumber e) -> e.value).reversed())
				.collect(Collectors.toList());
	}
}
