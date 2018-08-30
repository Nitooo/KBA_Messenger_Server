package messenger.ServiceAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Service.UserValidation;

@RestController
@RequestMapping("/userValidation")
public class UserValidationAdapter {

	@Autowired
	private UserValidation userValidationService;
	
	@RequestMapping(value = "/checkIfUserExists", method = RequestMethod.GET)
	public boolean checkIfUserExists(@RequestParam(value = "userId") Long username) {
		return userValidationService.checkIfUserExists(username);
	}
	
}
