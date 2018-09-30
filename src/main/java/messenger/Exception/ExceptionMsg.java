package messenger.Exception;

public class ExceptionMsg {
	private String exceptionMsg;

	/**
	 * Konstuktor der Fehlernachricht
	 * @param exceptionMsg
	 */
	public ExceptionMsg(String exceptionMsg) {
		this.setExceptionMsg(exceptionMsg);
	}

	/**
	 * gibt die Fehlernachicht
	 * @return Fehlernachricht
	 */
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * Setzt die Fehlernachricht
	 * @param exceptionMsg Fehlernachricht
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}



}
