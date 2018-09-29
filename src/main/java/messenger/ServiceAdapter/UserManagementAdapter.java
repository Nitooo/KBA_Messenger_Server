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
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}

	}

	@RequestMapping(value = "/deleteUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteUser(@RequestBody User user) {
		try {
			return userManagementService.deleteUser(user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		try {
			return userManagementService.updateUser(user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User getUser(@RequestBody User user) {
		try {
			return userManagementService.getUser(user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getUserById", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User getUser(@RequestBody Long userId) {
		try {
			return userManagementService.getUserById(userId);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public User loginUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "passwort") String passwort) {
		try {
			return userManagementService.loginUser(username, passwort);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public User[] getAllUsers() {
		try {
			return userManagementService.getAllUsers();
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

}
