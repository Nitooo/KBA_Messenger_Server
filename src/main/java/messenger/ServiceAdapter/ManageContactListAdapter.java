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
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteContact(@RequestBody LinkedMultiValueMap<String, User> entity) {
		try {
			User user = entity.getFirst("user");
			User contact = entity.getFirst("contact");
			return manageContactListService.deleteContact(user, contact);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

}
