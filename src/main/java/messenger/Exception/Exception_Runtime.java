package messenger.Exception;

public class Exception_Runtime extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * bei Runtime Exceptions
	 * @param errorMsg Fehlernachricht der Exception
	 */
	public Exception_Runtime(String errorMsg) {
		super(errorMsg);
	}
}
