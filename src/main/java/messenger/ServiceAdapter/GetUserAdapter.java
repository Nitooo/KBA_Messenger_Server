package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Exception.Exception_All;
import messenger.Exception.Exception_EntityManager;
import messenger.Exception.Exception_Runtime;
import messenger.Service.GetUser;

@RestController
@RequestMapping("/getUser")
public class GetUserAdapter {

	@Autowired
	private GetUser getUserService;

	/**
	 * Restadapter gives the userobject of the name
	 * 
	 * @param username of the user you want to get
	 * @return user object
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "username") String username) {
		try {
			return getUserService.getUser(username);
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
