package messenger.Exception;

/**
 * Wird bei Fehlern im EntityManager geworfen
 *
 */
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
