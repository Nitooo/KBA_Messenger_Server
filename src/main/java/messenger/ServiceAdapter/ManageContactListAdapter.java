package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.User;
import messenger.Exception.Exception_Custom;
import messenger.Service.ManageContactList;

@RestController
@RequestMapping("/manageContactList")
public class ManageContactListAdapter {

	@Autowired
	private ManageContactList manageContactListService;

	@RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addContact(@RequestBody LinkedMultiValueMap<String, User> entity) {
		try {
			User user = entity.getFirst("user");
			User contact = entity.getFirst("contact");
			return manageContactListService.addContact(user, contact);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //addContact - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //addContact - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //addContact - Exception: " + e + " Message: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteContact(@RequestBody LinkedMultiValueMap<String, User> entity) {
		try {
			User user = entity.getFirst("user");
			User contact = entity.getFirst("contact");
			return manageContactListService.deleteContact(user, contact);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //deleteContact - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //deleteContact - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //deleteContact - Exception: " + e + " Message: " + e.getMessage());
		}
	}

}
