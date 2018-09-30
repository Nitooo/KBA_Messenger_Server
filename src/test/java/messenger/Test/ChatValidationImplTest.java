package messenger.Test;

import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import messenger.DaoImpl.ChatDaoImpl;
import messenger.Domain.Chat;
import messenger.ServiceImpl.ChatValidationImpl;

/**
 * Test for the ChatValidationImpl
 *
 */
public class ChatValidationImplTest {

	@InjectMocks
	private ChatValidationImpl testingObject;

	@Mock
	private ChatDaoImpl chatDaoImpl;

	@Mock
	private Chat chat;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Chat Exists Test
	 */
	@Test
	public void testChatExist() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenReturn(chat);
		boolean result = testingObject.checkIfChatExists(1l);
		Assert.assertEquals(result, true);
	}

	/**
	 * Chat doesnt Exits Test
	 */
	@Test
	public void testChatDontExist() {
		Mockito.when(chatDaoImpl.getChatById(1l)).thenThrow(NoResultException.class);
		boolean result = testingObject.checkIfChatExists(1l);
		Assert.assertEquals(result, false);
	}

}
