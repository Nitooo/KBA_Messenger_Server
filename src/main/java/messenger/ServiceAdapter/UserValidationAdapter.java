package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Exception.Exception_All;
import messenger.Exception.Exception_EntityManager;
import messenger.Exception.Exception_Runtime;
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
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_EntityManager(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Runtime(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_All(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		}
	}

}
