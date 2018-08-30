package messenger.ServiceAdapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.Chat;
import messenger.Domain.User;
import messenger.Service.ManageChatGroups;

@RestController
@RequestMapping("/manageChatGroups")
public class ManageChatGroupsAdapter {
	
	@Autowired
	private ManageChatGroups manageChatGroupsService;

	@RequestMapping(value = "/addConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addConversation(@RequestBody User user) {
		return manageChatGroupsService.addConversation(user);
	}
	
	@RequestMapping(value = "/addGroupConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addGroupConversation(@RequestParam(value = "chatname", defaultValue="unnamed") String chatname, @RequestBody User user) {
		return manageChatGroupsService.addGroupConversation(user, chatname);
	}
	
	@RequestMapping(value = "/deleteConveration", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteConveration(@RequestBody Chat chat) {
		return manageChatGroupsService.deleteConveration(chat);
	}
	
	@RequestMapping(value = "/updateConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean updateConversation(@RequestBody Chat chat) {
		return manageChatGroupsService.updateConversation(chat);
	}
		
	@RequestMapping(value = "/getAllConversations", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<Chat> getAllConversations(@RequestBody User user) {
		return manageChatGroupsService.getAllConversations(user);
	}
	
	@RequestMapping(value = "/addUserToConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean addUserToConversation(@RequestBody Chat chat, @RequestBody User user) {
		return manageChatGroupsService.addUserToConversation(chat, user);
	}
	
	@RequestMapping(value = "/deleteUserFromConversation", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean deleteUserFromConversation(@RequestBody Chat chat, @RequestBody User user) {
		return manageChatGroupsService.deleteUserFromConversation(chat, user);
	}
	
	@RequestMapping(value = "/grantAdminPermission", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean grantAdminPermission(@RequestBody Chat chat, @RequestBody User user) {
		return manageChatGroupsService.grantAdminPermission(chat, user);
	}
	
	@RequestMapping(value = "/revokeAdminPermission", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean revokeAdminPermission(@RequestBody Chat chat, @RequestBody User user) {
		return manageChatGroupsService.revokeAdminPermission(chat, user);
	}
}
