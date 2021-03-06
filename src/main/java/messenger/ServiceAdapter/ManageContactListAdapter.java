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
import messenger.Exception.Exception_All;
import messenger.Exception.Exception_EntityManager;
import messenger.Exception.Exception_Runtime;
import messenger.Service.ManageContactList;

@RestController
@RequestMapping("/manageContactList")
public class ManageContactListAdapter {

	@Autowired
	private ManageContactList manageContactListService;

	/**
	 * Restadapter adds an contact to a user
	 * 
	 * @param entity LinkedMultiValueMap of the user and contact
	 * @return true: succesful; false: coundlt do it
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/addContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addContact(@RequestBody LinkedMultiValueMap<String, User> entity) {
		try {
			User user = entity.getFirst("user");
			User contact = entity.getFirst("contact");
			return manageContactListService.addContact(user, contact);
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

	/**
	 * Restadapter removes a contact from the user
	 * 
	 * @param entity LinkedMultiValueMap of the user and contact
	 * @return true: succesful; false: couldnt do it
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/deleteContact", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteContact(@RequestBody LinkedMultiValueMap<String, User> entity) {
		try {
			User user = entity.getFirst("user");
			User contact = entity.getFirst("contact");
			return manageContactListService.deleteContact(user, contact);
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
