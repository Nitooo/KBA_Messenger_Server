package messenger.ServiceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.ChatDao;
import messenger.Dao.UserDao;
import messenger.Domain.Chat;
import messenger.Domain.User;
import messenger.Service.ManageChatGroups;

@Service
public class ManageChatGroupsImpl implements ManageChatGroups, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ChatDao chatDbService;

	@Autowired
	private UserDao userDbService;

	@Override
	@Transactional
	public boolean addConversation(User user) {
		try {
			userDbService.getUserById(user.getUserId());
		} catch (NoResultException nre) {
			return false;
		}

		Chat chat = new Chat();
		List<User> users = new ArrayList<User>();

		users.add(user);
		chat.setUsers(users);
		chat.setGroupChat(false);

		chatDbService.persistObject(chat);
		return true;
	}

	@Override
	@Transactional
	public boolean addGroupConversation(User user, String chatname) {
		try {
			userDbService.getUserById(user.getUserId());
		} catch (NoResultException nre) {
			return false;
		}

		Chat chat = new Chat();
		List<User> users = new ArrayList<User>();

		users.add(user);
		chat.setUsers(users);
		chat.setGroupChat(true);
		chat.setName(chatname);
		chat.setAdmin(user);

		chatDbService.persistObject(chat);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteConveration(Chat chat) {
		chatDbService.removeObject(chat);
		return true;

	}

	@Override
	@Transactional
	public boolean updateConversation(Chat chat) {
		chatDbService.mergeObject(chat);
		return true;

	}

	@Override
	@Transactional
	public List<Chat> getAllConversations(User user) {
		return user.getChats();
	}

	@Override
	@Transactional
	public boolean addUserToConversation(Chat chat, User user) {
		try {
			chatDbService.getChatById(chat.getChatId());
			userDbService.getUserById(user.getUserId());
		} catch (NoResultException e) {
			return false;
		}

		List<User> users = chat.getUsers();
		users.add(user);
		chat.setUsers(users);

		chatDbService.mergeObject(chat);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteUserFromConversation(Chat chat, User user) {
		try {
			chatDbService.getChatById(chat.getChatId());
		} catch (NoResultException e) {
			return false;
		}

		List<User> users = chat.getUsers();
		users.remove(user);
		chat.setUsers(users);

		chatDbService.mergeObject(chat);
		return true;
	}

	@Override
	@Transactional
	public boolean grantAdminPermission(Chat chat, User user) {
		try {
			chatDbService.getChatById(chat.getChatId());
			userDbService.getUserById(user.getUserId());
		} catch (NoResultException e) {
			return false;
		}

		chat.setAdmin(user);
		chatDbService.mergeObject(chat);
		return true;
	}

	@Override
	@Transactional
	public boolean revokeAdminPermission(Chat chat, User user) {
		try {
			chatDbService.getChatById(chat.getChatId());
		} catch (NoResultException e) {
			return false;
		}

		chat.setAdmin(null);
		chatDbService.mergeObject(chat);
		return true;
	}

}
