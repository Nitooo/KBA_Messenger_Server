package messenger.Exception;

public class Exception_EntityManager extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Für EntityManager Exceptions
	 * @param errorMsg Fehlernachricht der Exception
	 */
	public Exception_EntityManager(String errorMsg) {
		super(errorMsg);
	}
}
