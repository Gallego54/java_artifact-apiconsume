package parser;

import java.io.BufferedReader;

public class BufferParser {
	public static String stringifyData ( BufferedReader Buffer) {
		try {
		    String lineBuffer, dataBuffer="";
	        while (( lineBuffer = Buffer.readLine()) != null) {
	        	dataBuffer+=lineBuffer;
	        }
	        
	        return dataBuffer;
	        
		}catch(Exception e) {
			return "";
		}		
	}
}
