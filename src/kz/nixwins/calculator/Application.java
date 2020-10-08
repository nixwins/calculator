package kz.nixwins.calculator;

import java.util.Map;

public class Application {

	public static void main(String[] args) {

		ConsoleReader consoleReader = new ConsoleReader(System.in);
		String raw = consoleReader.read();
		
		ExpressionParser expParser = new ExpressionParser();
		
		try {
			
			Map<String, String> expMap = expParser.parser(raw);
			Calculator.init(expMap);
			
		}catch(Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		
	}
}
