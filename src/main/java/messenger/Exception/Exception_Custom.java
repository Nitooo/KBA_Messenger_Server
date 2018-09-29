package messenger.Exception;

public class Exception_Custom extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Exception_Custom(String errorMsg) {
		super(errorMsg);
	}
}
