package in.com.exception;

public class CricketerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CricketerNotFoundException(String message) {
		super(message);
	}

}
