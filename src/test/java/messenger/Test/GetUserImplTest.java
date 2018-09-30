package messenger.Test;

import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import messenger.DaoImpl.UserDaoImpl;
import messenger.Domain.User;
import messenger.ServiceImpl.GetUserImpl;

public class GetUserImplTest {

	@InjectMocks
	private GetUserImpl testingObject;

	@Mock
	private UserDaoImpl userDaoImpl;

	@Mock
	private User user;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNoUserFoundGetUser() {
		Mockito.when(userDaoImpl.getUserByName("hans")).thenThrow(NoResultException.class);
		Mockito.when(user.getUsername()).thenReturn("hans");
		User result = testingObject.getUser("hans");
		Assert.assertEquals(result, null);
	}

	@Test
	public void testOkGetUser() {
		Mockito.when(userDaoImpl.getUserByName("hans")).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn("hans");
		User result = testingObject.getUser("hans");
		Assert.assertEquals(result, user);
	}

}
