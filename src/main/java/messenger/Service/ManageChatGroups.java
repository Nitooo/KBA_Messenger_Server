package messenger.Service;

import java.util.List;

import messenger.Domain.Chat;
import messenger.Domain.User;

public interface ManageChatGroups {

	/**
	 * adds a new conversation
	 * 
	 * @param user who creates the chat
	 * @return true: Conversation was added; false: Error
	 */
	public boolean addConversation(User user);

	/**
	 * adds a new group conversation
	 * 
	 * @param user     who create the chat
	 * @param chatname of the conversation
	 * @return true: Conversation was added; false: Error
	 */
	public boolean addGroupConversation(User user, String chatname);

	/**
	 * delete a conversation
	 * 
	 * @param chat to delete
	 * @return true: id conversation was deleted; false: Error
	 */
	public boolean deleteConveration(Chat chat);

	/**
	 * updates a conversation
	 * 
	 * @param chat which should be updated
	 * @return true: conversation was updated; false: Error
	 */
	public boolean updateConversation(Chat chat);

	/**
	 * return all chats of the user
	 * 
	 * @param user who wants to view his chats
	 * @return list with the chats
	 */
	public List<Chat> getAllConversations(User user);

	/**
	 * adds a user to the conversation
	 * 
	 * @param chat to the user should be added to
	 * @param user that should be added
	 * @return true: the user was added; false: Error
	 */
	public boolean addUserToConversation(Chat chat, User user);

	/**
	 * delete a user from a conversation
	 * 
	 * @param chat to the user should be deleted from
	 * @param user that should be deleted
	 * @return true: the user was deleted; false: Error
	 */
	public boolean deleteUserFromConversation(Chat chat, User user);

	/**
	 * grant admin rigths to a user of a conversation
	 * 
	 * @param chat to the user gets admin rights for
	 * @param user that gets admin rights
	 * @return true: admin right where correctly added; false: error
	 */
	public boolean grantAdminPermission(Chat chat, User user);

	/**
	 * revoke admin rights from a user of a conversation
	 * 
	 * @param chat to gets his admin rights revoked
	 * @param user that gets his admin rights revoked
	 * @return true: admin right where correctly revoked; false: error
	 */
	public boolean revokeAdminPermission(Chat chat, User user);

}
