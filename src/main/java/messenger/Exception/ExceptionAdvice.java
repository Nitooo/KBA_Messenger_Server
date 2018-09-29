package messenger.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(Exception_Custom.class)
	public ExceptionMsg handleException(Exception_Custom e) {
		ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage());
		return exceptionMsg;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not Found Exception!")
	@ExceptionHandler(Exception_NotFound.class)
	public ExceptionMsg handleException(Exception_NotFound e) {
		ExceptionMsg exceptionMsg = new ExceptionMsg(e.getMessage());
		return exceptionMsg;
	}
}