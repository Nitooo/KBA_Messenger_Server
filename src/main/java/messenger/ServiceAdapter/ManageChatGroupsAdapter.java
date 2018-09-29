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
import messenger.Exception.Exception_Custom;
import messenger.Service.ManageChatGroups;

@RestController
@RequestMapping("/manageChatGroups")
public class ManageChatGroupsAdapter {

	@Autowired
	private ManageChatGroups manageChatGroupsService;

	@RequestMapping(value = "/addConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addConversation(@RequestBody User user) {
		try {
			return manageChatGroupsService.addConversation(user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/addGroupConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addGroupConversation(@RequestParam(value = "chatname", defaultValue = "unnamed") String chatname,
			@RequestBody User user) {
		try {
			return manageChatGroupsService.addGroupConversation(user, chatname);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteConveration", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteConveration(@RequestBody Chat chat) {
		try {
			return manageChatGroupsService.deleteConveration(chat);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/updateConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean updateConversation(@RequestBody Chat chat) {
		try {
			return manageChatGroupsService.updateConversation(chat);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/getAllConversations", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<Chat> getAllConversations(@RequestBody User user) {
		try {
			return manageChatGroupsService.getAllConversations(user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/addUserToConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addUserToConversation(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.addUserToConversation(chat, user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/deleteUserFromConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteUserFromConversation(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.deleteUserFromConversation(chat, user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/grantAdminPermission", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean grantAdminPermission(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.grantAdminPermission(chat, user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}

	@RequestMapping(value = "/revokeAdminPermission", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean revokeAdminPermission(@RequestBody Chat chat, @RequestBody User user) {
		try {
			return manageChatGroupsService.revokeAdminPermission(chat, user);
		} catch (IllegalArgumentException e) {
			throw new Exception_Custom("01 - IllegalArgumentException " + e.getMessage());
		} catch (TransactionRequiredException e) {
			throw new Exception_Custom("02 - TransactionRequiredException: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom("03 - Ein unbestimmter Fehler ist aufgetreten: " + e.getMessage());
		}
	}
}
