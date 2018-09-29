package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Exception.Exception_Custom;
import messenger.Service.UserValidation;

@RestController
@RequestMapping("/userValidation")
public class UserValidationAdapter {

	@Autowired
	private UserValidation userValidationService;

	@RequestMapping(value = "/checkIfUserExists", method = RequestMethod.GET)
	public boolean checkIfUserExists(@RequestParam(value = "userId") Long username) {
		try {
			return userValidationService.checkIfUserExists(username);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

}
