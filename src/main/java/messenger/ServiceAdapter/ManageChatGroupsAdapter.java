package messenger.ServiceAdapter;

import java.util.List;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.Chat;
import messenger.Domain.User;
import messenger.Exception.Exception_All;
import messenger.Exception.Exception_EntityManager;
import messenger.Exception.Exception_Runtime;
import messenger.Service.ManageChatGroups;

@RestController
@RequestMapping("/manageChatGroups")
public class ManageChatGroupsAdapter {

	@Autowired
	private ManageChatGroups manageChatGroupsService;

	/**
	 * Restadapter gives the user a new conversation
	 * 
	 * @param user who wants to get a new conversation
	 * @return true: conversation was addes; false: the conversation wasnt added
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/addConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addConversation(@RequestBody User user) {
		try {
			return manageChatGroupsService.addConversation(user);
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
	 * Restadapter gives the user a new groupconversation
	 * 
	 * @param chatname the name for the group
	 * @param user     the user who creates the group
	 * @return true: conversation created succesful; false: couldnt create
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/addGroupConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addGroupConversation(@RequestParam(value = "chatname", defaultValue = "unnamed") String chatname,
			@RequestBody User user) {
		try {
			return manageChatGroupsService.addGroupConversation(user, chatname);
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
	 * Restadapter Deltes a chat from the system
	 * 
	 * @param chat the chat which shall be deleted
	 * @return true: deleted succesful; false: couldnt delete
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/deleteConveration", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteConveration(@RequestBody Chat chat) {
		try {
			return manageChatGroupsService.deleteConveration(chat);
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
	 * Restadapter Updates a Conversation
	 * 
	 * @param chat the new one
	 * @return true: succesful; false: couldnt update
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/updateConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean updateConversation(@RequestBody Chat chat) {
		try {
			return manageChatGroupsService.updateConversation(chat);
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
	 * Restadapter get a list of all Conversation from a user
	 * 
	 * @param user of the conversation
	 * @return List<Chat> of the chats from the user
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/getAllConversations", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<Chat> getAllConversations(@RequestBody User user) {
		try {
			return manageChatGroupsService.getAllConversations(user);
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
	 * Restadapter Adds a user to the conversation
	 * 
	 * @param chat the conversation
	 * @param user the user who should be added
	 * @return true: succesful; false: couldnt add
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/addUserToConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addUserToConversation(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.addUserToConversation(chat, user);
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
	 * Restadapter Deletes a user from a conversation
	 * 
	 * @param chat from which chat
	 * @param user which user
	 * @return true: succesful; false: couldnt do it
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/deleteUserFromConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteUserFromConversation(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.deleteUserFromConversation(chat, user);
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
	 * Restadapter give the user admin rights
	 * 
	 * @param chat to which chat
	 * @param user which user shall get the rights
	 * @return true: succesful; false: couldnt do it
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/grantAdminPermission", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean grantAdminPermission(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.grantAdminPermission(chat, user);
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
	 * Restadapter revokes admin rights from the chat
	 * 
	 * @param chat from which chat
	 * @param user which user
	 * @return true: succesful; false: couldnt do it
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/revokeAdminPermission", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean revokeAdminPermission(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.revokeAdminPermission(chat, user);
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
