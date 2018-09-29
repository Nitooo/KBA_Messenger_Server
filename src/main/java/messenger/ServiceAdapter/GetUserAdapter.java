package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Exception.Exception_Custom;
import messenger.Service.GetUser;

@RestController
@RequestMapping("/getUser")
public class GetUserAdapter {

	@Autowired
	private GetUser getUserService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "username") String username) {
		try {
			return getUserService.getUser(username);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}
}
