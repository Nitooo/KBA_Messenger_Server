package messenger.Test;

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

import messenger.DaoImpl.UserDaoImpl;
import messenger.Domain.User;
import messenger.ServiceImpl.UserManagementImpl;

/**
 * Test for UserManagementImpl
 *
 */
public class UserManagementImplTest {

	@InjectMocks
	private UserManagementImpl testingObject;

	@Mock
	private UserDaoImpl userDaoImpl;

	@Mock
	private User user;

	@Mock
	private User user2;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

	}

	// addUser

	/**
	 * addUser succesful
	 */
	@Test
	public void testAddUser() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenThrow(NoResultException.class);
		Mockito.when(user.getUsername()).thenReturn("name");
		int result = testingObject.addUser("name", "passwort");
		Assert.assertEquals(result, 0);
	}

	/**
	 * couldnt becasue of EntityExistException
	 */
	@Test
	public void testAddUserAlreadyExistWithDiffrentName() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenThrow(NoResultException.class);
		Mockito.when(user.getUsername()).thenReturn("name");
		Mockito.doThrow(EntityExistsException.class).when(userDaoImpl)
				.persistObject(ArgumentMatchers.<Class<User>>any());
		int result = testingObject.addUser("name", "passwort");
		Assert.assertEquals(result, 1);
	}

	/**
	 * Couldnt because the name is already given to someone else
	 */
	@Test
	public void testAddUserNameAlreadyExist() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn("name");
		int result = testingObject.addUser("name", "passwort");
		Assert.assertEquals(result, 1);
	}

	// deleteUser

	/**
	 * succesful delted user
	 */
	@Test
	public void testDeleteUser() {
		boolean result = testingObject.deleteUser(user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt because of an IllegalArgumentException in the entitymanager
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteUserException() {
		Mockito.doThrow(IllegalArgumentException.class).when(userDaoImpl).removeObject(user);
		testingObject.deleteUser(user);
	}

	/**
	 * couldnt because of an TransactionRequiredException in the entitymanager
	 */
	@Test(expected = TransactionRequiredException.class)
	public void testDeleteUserException2() {
		Mockito.doThrow(TransactionRequiredException.class).when(userDaoImpl).removeObject(user);
		testingObject.deleteUser(user);
	}

	// updateUser

	/**
	 * succesful updated user
	 */
	@Test
	public void testUpdateUser() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenReturn(user);
		Mockito.when(user.getUsername()).thenReturn("name");
		boolean result = testingObject.updateUser(user);
		Assert.assertEquals(result, true);
	}

	/**
	 * couldnt because name already exist
	 */
	@Test
	public void testUpdateUserNameAlreadyExist() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenReturn(user2);
		Mockito.when(user.getUsername()).thenReturn("name");
		Mockito.when(user.getUserId()).thenReturn(1l);
		Mockito.when(user2.getUserId()).thenReturn(2l);
		boolean result = testingObject.updateUser(user);
		Assert.assertEquals(result, false);
	}

	// getUserById

	/**
	 * succesful; got the use
	 */
	@Test
	public void testgetUserById() {
		Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
		User result = testingObject.getUserById(1l);
		Assert.assertEquals(result, user);
	}

	/**
	 * couldnt get the user because of wrong id
	 */
	@Test
	public void testgetUserByIdWrongID() {
		Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
		User result = testingObject.getUserById(1l);
		Assert.assertEquals(result, null);
	}

	// loginUser

	/**
	 * succesful loged in the user
	 */
	@Test
	public void testLoginUser() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenReturn(user);
		Mockito.when(user.getPassword()).thenReturn("passwort");
		User result = testingObject.loginUser("name", "passwort");
		Assert.assertEquals(result, user);
	}

	/**
	 * wrong password
	 */
	@Test
	public void testLoginUserWrongPasswort() {
		Mockito.when(userDaoImpl.getUserByName("name")).thenReturn(user);
		Mockito.when(user.getPassword()).thenReturn("passwort");
		User result = testingObject.loginUser("name", "passwort-falsch");
		Assert.assertEquals(result, null);
	}

	/**
	 * wrong username
	 */
	@Test
	public void testLoginUserWrongName() {
		Mockito.when(userDaoImpl.getUserByName("name-falsch")).thenThrow(NoResultException.class);
		Mockito.when(user.getPassword()).thenReturn("passwort");
		User result = testingObject.loginUser("name-falsch", "passwort");
		Assert.assertEquals(result, null);
	}

	// getAllUsers

	/**
	 * succesful; got all the users
	 */
	@Test
	public void testgetAllUsers() {
		User[] userList = new User[1];
		userList[0] = user;
		Mockito.when(userDaoImpl.getAllUsers()).thenReturn(userList);
		User[] result = testingObject.getAllUsers();
		Assert.assertArrayEquals(result, userList);
	}

	/**
	 * no user in database
	 */
	@Test
	public void testgetAllUsersWithNoUserInDB() {
		Mockito.when(userDaoImpl.getAllUsers()).thenReturn(null);
		User[] result = testingObject.getAllUsers();
		Assert.assertArrayEquals(result, null);
	}

}
