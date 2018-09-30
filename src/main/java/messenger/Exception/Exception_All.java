package messenger.Exception;

/**
 * Wird bei Runtime Fehlern geworfen
 *
 */
public class Exception_All extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * bei allen ansonsten nicht behandelten Fehler
	 * 
	 * @param errorMsg Fehlernachricht der Exception
	 */
	public Exception_All(String errorMsg) {
		super(errorMsg);
	}
}
