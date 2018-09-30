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
import messenger.ServiceImpl.UserValidationImpl;

/**
 * Test for UserValidationImpl
 *
 */
public class UserValidationImplTest {

	@InjectMocks
	private UserValidationImpl testingObject;

	@Mock
	private UserDaoImpl userDaoImpl;

	@Mock
	private User user;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * user exist
	 */
	@Test
	public void testUserExist() {
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		boolean result = testingObject.checkIfUserExists(1l);
		Assert.assertEquals(result, true);
	}

	/**
	 * user not in the system
	 */
	@Test
	public void testUserDontExist() {
		Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
		boolean result = testingObject.checkIfUserExists(1l);
		Assert.assertEquals(result, false);
	}

}
