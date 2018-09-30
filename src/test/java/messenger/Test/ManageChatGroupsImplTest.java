package messenger.Test;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.TransactionRequiredException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import messenger.DaoImpl.ChatDaoImpl;
import messenger.DaoImpl.UserDaoImpl;
import messenger.Domain.Chat;
import messenger.Domain.User;
import messenger.ServiceImpl.ManageChatGroupsImpl;

/**
 * Tests for the ManageChatGroupsImpl
 *
 */
public class ManageChatGroupsImplTest {

	@InjectMocks
	private ManageChatGroupsImpl testingObject;

	@Mock
	private ChatDaoImpl chatDaoImpl;

	@Mock
	private Chat chat;

	@Mock
	private UserDaoImpl userDaoImpl;

	@Mock
	private User user;

	@Mock
	private List<Chat> chatList;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	// addConversation

	/**
	 * add converstaion succesful
	 */
	@Test
	public void addConveration() {
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.addConversation(user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt add conversation because user doesnt exist
	 */
	@Test
	public void addConverationUserDoesntExist() {
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
		boolean result = testingObject.addConversation(user);
		Assert.assertEquals(result, false);
	}

	/**
	 * couldnt add the conversation because the conversation already exist
	 */
	@Test(expected = EntityExistsException.class)
	public void addConverationUserPersistException() {
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.doThrow(EntityExistsException.class).when(chatDaoImpl)
				.persistObject(ArgumentMatchers.<Class<Chat>>any());
		testingObject.addConversation(user);

	}

	// addGroupConversation

	/**
	 * addes succesful the GroupConversation
	 */
	@Test
	public void addGroupConveration() {
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.addGroupConversation(user, "chatname");
		Assert.assertEquals(result, true);
	}

	/**
	 * Couldnt add groupconversation because user doesnt exist
	 */
	@Test
	public void addGroupConverationUserDoesntExist() {
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
		boolean result = testingObject.addGroupConversation(user, "chatname");
		Assert.assertEquals(result, false);
	}

	/**
	 * couldnt add groupconversation because the conversation already exist
	 */
	@Test(expected = EntityExistsException.class)
	public void addGroupConverationUserPersistException() {
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.doThrow(EntityExistsException.class).when(chatDaoImpl)
				.persistObject(ArgumentMatchers.<Class<Chat>>any());
		testingObject.addGroupConversation(user, "chatname");

	}

	// deleteConversation
	/**
	 * delete conversation succesful
	 */
	@Test
	public void testDeleteChat() {
		boolean result = testingObject.deleteConveration(chat);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldt delete for IllegalArgumentException in the EntityManager
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteChatException() {
		Mockito.doThrow(IllegalArgumentException.class).when(chatDaoImpl).removeObject(chat);
		testingObject.deleteConveration(chat);
	}

	/**
	 * couldnt delete for TransactionRequiredException in the EntityManager
	 */
	@Test(expected = TransactionRequiredException.class)
	public void testDeleteChatException2() {
		Mockito.doThrow(TransactionRequiredException.class).when(chatDaoImpl).removeObject(chat);
		testingObject.deleteConveration(chat);
	}

	// updateConversation
	/**
	 * succesful updated the conversation
	 */
	@Test
	public void testUpdateChat() {
		boolean result = testingObject.updateConversation(chat);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt update for IllegalArgumentException in the EntityManager
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateChatException() {
		Mockito.doThrow(IllegalArgumentException.class).when(chatDaoImpl).mergeObject(chat);
		testingObject.updateConversation(chat);
	}

	/**
	 * couldnt update for TransactionRequiredException in the EntityManager
	 */
	@Test(expected = TransactionRequiredException.class)
	public void testUpdateChatException2() {
		Mockito.doThrow(TransactionRequiredException.class).when(chatDaoImpl).mergeObject(chat);
		testingObject.updateConversation(chat);
	}

	// getAllChats

	/**
	 * succesful getting all chats
	 */
	@Test
	public void testgetAllChats() {
		Mockito.when(user.getChats()).thenReturn(chatList);
		List<Chat> result = testingObject.getAllConversations(user);
		Assert.assertEquals(result, chatList);
	}

	/**
	 * there wasnt any chats in the database
	 */
	@Test
	public void testgetAllChatsWithNoChatInDB() {
		Mockito.when(user.getChats()).thenReturn(null);
		List<Chat> result = testingObject.getAllConversations(user);
		Assert.assertEquals(result, null);
	}

	// addUserToConverastion

	/**
	 * succesful addes an user to the conversation
	 */
	@Test
	public void testAddUserToConversation() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.addUserToConversation(chat, user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt add user to conversation because chat doesnt exist
	 */
	@Test
	public void testAddUserToConversationChatDoesntExist() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.addUserToConversation(chat, user);
		Assert.assertEquals(result, false);
	}

	/**
	 * couldnt add user to the conversation because user doesnt exist
	 */
	@Test
	public void testAddUserToConversationUserDoesntExist() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
		boolean result = testingObject.addUserToConversation(chat, user);
		Assert.assertEquals(result, false);
	}

	// deleteUserToConverastion

	/**
	 * conversation deleted succesful
	 */
	@Test
	public void testDeleteUserToConversation() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.deleteUserFromConversation(chat, user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt delete the conversation because it doesnt exist
	 */
	@Test
	public void testDeleteUserToConversationChatDoesntExist() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.deleteUserFromConversation(chat, user);
		Assert.assertEquals(result, false);
	}

	// grantAdminPermissopmn

	/**
	 * granted admin permission succesful
	 */
	@Test
	public void testgrantAdminPermission() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.grantAdminPermission(chat, user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt grant because the chat doesnt exist
	 */
	@Test
	public void testgrantAdminPermissionChatDoesntExist() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.grantAdminPermission(chat, user);
		Assert.assertEquals(result, false);
	}

	/**
	 * couldnt grant because the user doesnt exist
	 */
	@Test
	public void testgrantAdminPermissionUserDoesntExist() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
		boolean result = testingObject.grantAdminPermission(chat, user);
		Assert.assertEquals(result, false);
	}

	// removeAdminPersmission

	/**
	 * revoked roght succesful
	 */
	@Test
	public void testrevokeAdminPermission() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.revokeAdminPermission(chat, user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt revoke because couldnt find chat
	 */
	@Test
	public void testrevokeAdminPermissionChatDoesntExist() {
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.revokeAdminPermission(chat, user);
		Assert.assertEquals(result, false);
	}
}
