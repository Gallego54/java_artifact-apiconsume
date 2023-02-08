package jsonAPI;

import org.json.*;
import apichannel.*;

public class Main {
	public static void main (String[] args) {
		ICrud <JSONObject> IChannel = new  JSONChannel();

		JSONObject post = IChannel.post("http://localhost:1000/api/data", 
				new JSONObject("{\"data\":\"Java\"}")); 
			
		JSONObject patch = IChannel.put("http://localhost:1000/api/data/" + post.getJSONArray("response").getJSONObject(0).get("insertId"), 
				new JSONObject("{\"data\":\"JavaEdit\"}")); 
		

		JSONObject delete = IChannel.delete("http://localhost:1000/api/data/"+ post.getJSONArray("response").getJSONObject(0).get("insertId")); 
	
		System.out.println(post.get("response"));
		System.out.println(patch.get("response"));
		System.out.println(delete.get("response"));
		
	}
}
