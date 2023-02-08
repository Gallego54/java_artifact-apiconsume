package httpconnection;

import java.net.HttpURLConnection;

public interface IConnection {
	public HttpURLConnection 	startConnection (String apiUrl, String method, String notation);
	public 		void 		 	endConnection ();
	
}
