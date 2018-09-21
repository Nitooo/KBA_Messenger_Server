package messenger.ServiceAdapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Service.ManageContactList;

@RestController
@RequestMapping("/manageContactList")
public class ManageContactListAdapter {

	@Autowired
	private ManageContactList manageContactListService;
	
	/*@RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addContact(@RequestBody User user, @RequestBody User contact) {
		return manageContactListService.addContact(user, contact);
	}*/
	
	@RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addContact(@RequestBody LinkedMultiValueMap<String,User> entity) {
		User user = entity.getFirst("user");
		User contact = entity.getFirst("contact");
		System.out.print(user.getUsername());
		System.out.println(contact.getUsername());
		return manageContactListService.addContact(user, contact);
	}
	
	@RequestMapping(value = "/deleteContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteContact(@RequestBody User user, @RequestBody User contact) {
		return manageContactListService.deleteContact(user, contact);
	}
	
	@RequestMapping(value = "/getContactList", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<User> getContactList(@RequestBody User user) {
		return manageContactListService.getContactList(user);
	}

}
