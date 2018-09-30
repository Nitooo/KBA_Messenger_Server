package messenger.Test;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import messenger.DaoImpl.ChatDaoImpl;
import messenger.DaoImpl.MessageDaoImpl;
import messenger.Domain.Chat;
import messenger.Domain.Message;
import messenger.ServiceImpl.CommunicationImpl;

/**
 * Test the CommunicationImpl
 *
 */
public class CommunicationImplTest {

	@InjectMocks
	private CommunicationImpl testingObject;

	@Mock
	private ChatDaoImpl chatDaoImpl;

	@Mock
	private Chat chat;

	@Mock
	private MessageDaoImpl messageDaoImpl;

	@Mock
	private Message message;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	// sendMessage Tests

	/**
	 * Message Send works
	 */
	@Test
	public void testMessageSend() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(message.getChat()).thenReturn(chat);
		Mockito.when(chat.getChatId()).thenReturn(1l);
		boolean result = testingObject.sendMessage(message);
		Assert.assertEquals(result, true);
	}

	/**
	 * message couldtn send because already exist
	 */
	@Test(expected = EntityExistsException.class)
	public void testMessageAlreadySend() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(message.getChat()).thenReturn(chat);
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Mockito.doThrow(EntityExistsException.class).when(messageDaoImpl).persistObject(message);
		testingObject.sendMessage(message);
	}

	/**
	 * message couldnt send because chat doesnt exist
	 */
	@Test
	public void testMessageDoesntSendChatDoesntExist() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		Mockito.when(message.getChat()).thenReturn(chat);
		Mockito.when(chat.getChatId()).thenReturn(1l);
		boolean result = testingObject.sendMessage(message);
		Assert.assertEquals(result, false);
	}

	// getChat Tests

	/**
	 * chat was found
	 */
	@Test
	public void testChatExist() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Chat result = testingObject.getChat(chat);
		Assert.assertEquals(result, chat);
	}

	/**
	 * chat wasnt found
	 */
	@Test
	public void testChatDoesntExist() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		Mockito.when(chat.getChatId()).thenReturn(1l);
		Chat result = testingObject.getChat(chat);
		Assert.assertEquals(result, null);
	}

}
