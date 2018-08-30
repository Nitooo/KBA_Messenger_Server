package messenger.ServiceAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Service.GetUser;

@RestController
@RequestMapping("/getUser")
public class GetUserAdapter {
	
	@Autowired
	private GetUser getUserService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser(@RequestParam(value = "username") String username) {
		return getUserService.getUser(username);
	}
}
