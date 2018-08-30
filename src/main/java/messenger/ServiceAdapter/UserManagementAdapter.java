package messenger.ServiceAdapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Service.UserManagement;

@RestController
@RequestMapping("/userManagement")
public class UserManagementAdapter {
	
	@Autowired
	private UserManagement userManagementService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public int addUser(@RequestParam(value = "username") String username, @RequestParam(value = "passwort") String passwort) {
		return userManagementService.addUser(username, passwort);
	}
	
	@RequestMapping(value = "/deleteUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteUser(@RequestBody User user) {
		return userManagementService.deleteUser(user);
	}
	
	@RequestMapping(value = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean updateUser(@RequestBody User user) {
		return userManagementService.updateUser(user);
	}
	
	@RequestMapping(value = "/getUser", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User getUser(@RequestBody User user) {
		return userManagementService.getUser(user);
	}
	
	@RequestMapping(value = "/getUserById", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public User getUser(@RequestBody Long userId) {
		return userManagementService.getUserById(userId);
	}
	
	@RequestMapping(value = "/loginUser", method = RequestMethod.GET)
	public User loginUser(@RequestParam(value = "username") String username, @RequestParam(value = "passwort") String passwort) {
		return userManagementService.loginUser(username, passwort);
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public User[] getAllUsers() {
		return userManagementService.getAllUsers();
	}

}
