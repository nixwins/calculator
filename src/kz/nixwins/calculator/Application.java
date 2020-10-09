package kz.nixwins.calculator;

import java.nio.channels.NonWritableChannelException;
import java.util.Map;

import kz.nixwins.calculator.util.Encoder;
import kz.nixwins.calculator.util.EncoderArabic;
import kz.nixwins.calculator.view.ConsoleOutput;

public class Application {

	public static void main(String[] args) {

		ConsoleReader consoleReader = new ConsoleReader(System.in);
		String raw = consoleReader.read();
		
		ExpressionParser expParser = new ExpressionParser();
	
		
		try {
			
			Map<String, String> expMap = expParser.parser(raw);
			
			
			Calculator calculator = new Calculator();
			calculator.init(expMap);
			
			if(expParser.getIsRoman()){
				
				int result = calculator.calculate();
				Encoder encoder = new EncoderArabic();
				String romanResult = encoder.encoder(String.valueOf(result));
				
				ConsoleOutput.output(romanResult);
				
			}else {
				
				int result = calculator.calculate();
				ConsoleOutput.output(result);
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		
	}
}
