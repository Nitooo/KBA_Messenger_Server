package messenger.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	/**
	 * Exception handler für EntityManager Exception
	 * @param e Exception_EntityManager
	 * @return Fehlernachricht
	 */
	@ExceptionHandler(Exception_EntityManager.class)
	public ExceptionMsg handleException(Exception_EntityManager e) {
		ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage());
		return exceptionMsg;
	}
	
	/**
	 * Exception handler für Runtime Exception
	 * @param e Exception_Runtime
	 * @return Fehlernachricht
	 */
	@ExceptionHandler(Exception_Runtime.class)
	public ExceptionMsg handleException(Exception_Runtime e) {
		ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage());
		return exceptionMsg;
	}
	
	/**
	 * Exception handler für All Exception
	 * @param e Exception_All
	 * @return Fehlernachricht
	 */
	@ExceptionHandler(Exception_All.class)
	public ExceptionMsg handleException(Exception_All e) {
		ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage());
		return exceptionMsg;
	}

	/**
	 * Exception handler für Not_FOUND Exception
	 * @param e Exception_NotFound
	 * @return Fehlernachricht
	 */
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found Exception!")
	@ExceptionHandler(Exception_NotFound.class)
	public ExceptionMsg handleException(Exception_NotFound e) {
		ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage());
		return exceptionMsg;
	}
}