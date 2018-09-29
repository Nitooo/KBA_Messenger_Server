package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Exception.Exception_Custom;
import messenger.Service.UserManagement;

@RestController
@RequestMapping("/userManagement")
public class UserManagementAdapter {

	@Autowired
	private UserManagement userManagementService;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public int addUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "passwort") String passwort) {
		try {
			return userManagementService.addUser(username, passwort);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //addUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //addUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //addUser - Exception: " + e + " Message: " + e.getMessage());
		}

	}

	@RequestMapping(value = "/deleteUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteUser(@RequestBody User user) {
		try {
			return userManagementService.deleteUser(user);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //deleteUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //deleteUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //deleteUser - Exception: " + e + " Message: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		try {
			return userManagementService.updateUser(user);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //updateUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //updateUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //updateUser - Exception: " + e + " Message: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User getUser(@RequestBody User user) {
		try {
			return userManagementService.getUser(user);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //getUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //getUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //getUser - Exception: " + e + " Message: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getUserById", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User getUser(@RequestBody Long userId) {
		try {
			return userManagementService.getUserById(userId);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //getUserById - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //getUserById - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //getUserById - Exception: " + e + " Message: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public User loginUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "passwort") String passwort) {
		try {
			return userManagementService.loginUser(username, passwort);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //loginUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //loginUser - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //loginUser - Exception: " + e + " Message: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public User[] getAllUsers() {
//		throw new Exception_Custom("01 - IllegalArgumentException ");
		try {
			return userManagementService.getAllUsers();
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //getAllUsers - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //getAllUsers - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //getAllUsers - Exception: " + e + " Message: " + e.getMessage());
		}
	}

}
