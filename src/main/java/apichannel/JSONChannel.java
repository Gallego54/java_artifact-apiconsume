package apichannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;


import httpconnection.*;

import org.json.*;
import parser.BufferParser;
import java.io.OutputStream;


public class JSONChannel implements ICrud <JSONObject>{
	private IConnection httpconnection = new Connection ();
	

	
	public JSONObject get (String apiUrl) {
		try {
			HttpURLConnection Connection = this.httpconnection.startConnection(apiUrl, "GET", "application/json");
			
	        InputStreamReader in = new InputStreamReader(Connection.getInputStream());
	        String bufferData = BufferParser.stringifyData(new BufferedReader(in));
	     
	        
	 
	        this.httpconnection.endConnection();
	        return new JSONObject("{response: " + bufferData + "}");
		}catch(Exception e) {
			String[] StrException = e.toString().split(":");
			
			return new JSONObject("{exception: [{\""+StrException[0]+"\": \""+ StrException[1] +" \"}," 
			+ "{message: \""+ e.getMessage() + "\"}]}");
		}
	}
	
	public JSONObject put (String apiUrl,  JSONObject body) {
		try {
			HttpURLConnection Connection = this.httpconnection.startConnection(apiUrl, "PUT", "application/json");
			
	        InputStreamReader in = new InputStreamReader(Connection.getInputStream());
	        String bufferData = BufferParser.stringifyData(new BufferedReader(in));
	     
	        this.httpconnection.endConnection();
	        return new JSONObject("{response: " + bufferData + "}");
		}catch(Exception e) {
			String[] StrException = e.toString().split(":");
			
			return new JSONObject("{exception: [{\""+StrException[0]+"\": \""+ StrException[1] +" \"}," 
			+ "{message: \""+ e.getMessage() + "\"}]}");
		}
	}
	
	public JSONObject post (String apiUrl,  JSONObject body) {
		try {
			HttpURLConnection Connection = this.httpconnection.startConnection(apiUrl, "POST", "application/json");
			Connection.setDoOutput(true);

			OutputStream out = Connection.getOutputStream();
			out.write(body.toString().getBytes("UTF-8")); out.close();
			
	        InputStreamReader in = new InputStreamReader(Connection.getInputStream());
	        String bufferData = BufferParser.stringifyData(new BufferedReader(in));
	        
	        
	     
	        this.httpconnection.endConnection();
			return new JSONObject("{response: " + bufferData + "}");
		}catch(Exception e) {
			String[] StrException = e.toString().split(":");
	
			return new JSONObject("{exception: [{\""+StrException[0]+"\": \""+ StrException[1] +" \"}," 
			+ "{message: \""+ e.getMessage() + "\"}]}");
					
		}
	} 
	
	public JSONObject delete (String apiUrl) {
		try {
			HttpURLConnection Connection = this.httpconnection.startConnection(apiUrl, "DELETE", "application/json");
			
	        InputStreamReader in = new InputStreamReader(Connection.getInputStream());
	        String bufferData = BufferParser.stringifyData(new BufferedReader(in));
	        
	        
	        this.httpconnection.endConnection();
			return new JSONObject("{response: " + bufferData + "}");
		}catch(Exception e) {
			String[] StrException = e.toString().split(":");
	
			return new JSONObject("{exception: [{\""+StrException[0]+"\": \""+ StrException[1] +" \"}," 
			+ "{message: \""+ e.getMessage() + "\"}]}");
					
		}
	}
	
	
	public JSONChannel() {}
}
