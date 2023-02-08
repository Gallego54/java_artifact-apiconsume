package apichannel;

/**
 * HTTP methods to consume API REST
 */

public interface ICrud <Notation> {
	public Notation get 	(String apiUrl);
	public Notation put 	(String apiUrl,  Notation body);
	public Notation post 	(String apiUrl,   Notation body);
	public Notation delete (String apiUrl);
}
