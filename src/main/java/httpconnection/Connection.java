package httpconnection;

import java.net.HttpURLConnection;
import java.net.URL;


public class Connection implements IConnection{
	private URL APIUrl;
	private HttpURLConnection Connection;
	
	public HttpURLConnection startConnection (String apiUrl, String method, String notation) {
		try {

            this.APIUrl = new URL(apiUrl);
            this.Connection = (HttpURLConnection) this.APIUrl.openConnection();
            
            this.Connection.setRequestMethod(method);
            this.Connection.setRequestProperty("Accept", notation);
            this.Connection.setRequestProperty("Content-Type", notation);
   
            return this.Connection;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            return null;
        } 
	}
	
	public void endConnection () {
		try {
			this.Connection.disconnect();
		}catch(Exception e) {
			System.out.println("To disconnect you needs to be connected first...");
		}
	}
	
	public Connection () {
		this.APIUrl = null;
		this.Connection = null;
	}
}
