package kz.nixwins.calculator;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader {

	private final InputStream in;
	
	public ConsoleReader(InputStream in) {
		this.in = in;
	
	}
	
	public String read() {
		
		Scanner scanner = new Scanner(in);
		
		System.out.print("Введите (a+b,a -b, a*b, a/b) : ");
		String raw = scanner.nextLine();
		
		//System.out.println(raw);
		scanner.close();
		return raw;
		///System.exit(0);
	}
}
