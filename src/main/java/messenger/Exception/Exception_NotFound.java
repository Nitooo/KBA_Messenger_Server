package messenger.Exception;

public class Exception_NotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Exception_NotFound(String errorMsg) {
		super(errorMsg);
	}
}