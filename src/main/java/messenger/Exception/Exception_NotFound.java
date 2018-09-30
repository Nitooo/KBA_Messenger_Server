package messenger.Exception;

public class Exception_NotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * bei nicht auffinden von Elementen
	 * @param errorMsg Fehlernachricht der Exception
	 */
	public Exception_NotFound(String errorMsg) {
		super(errorMsg);
	}
}
