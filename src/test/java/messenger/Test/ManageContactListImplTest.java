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

import messenger.DaoImpl.UserDaoImpl;
import messenger.Domain.User;
import messenger.ServiceImpl.ManageContactListImpl;

public class ManageContactListImplTest {

	@InjectMocks
	private ManageContactListImpl testingObject;

	@Mock
	private UserDaoImpl userDaoImpl;

	@Mock
	private User user;

	@Mock
	private User contact;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	// addContact

		@Test
		public void testAddContact() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
			Mockito.when(userDaoImpl.getUserById(2l)).thenReturn(contact);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			boolean result = testingObject.addContact(user, contact);
			Assert.assertEquals(result, true);
		}

		@Test
		public void testAddContactContactDoesntExist() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
			Mockito.when(userDaoImpl.getUserById(2l)).thenThrow(NoResultException.class);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			boolean result = testingObject.addContact(user, contact);
			Assert.assertEquals(result, false);
		}

		@Test
		public void testAddContactUserDoesntExist() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
			Mockito.when(userDaoImpl.getUserById(2l)).thenReturn(contact);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			boolean result = testingObject.addContact(user, contact);
			Assert.assertEquals(result, false);
		}

		@Test(expected = EntityExistsException.class)
		public void testAddContactCouldntPersist() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
			Mockito.when(userDaoImpl.getUserById(2l)).thenReturn(contact);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			Mockito.doThrow(EntityExistsException.class).when(userDaoImpl).persistObject(user);
			testingObject.addContact(user, contact);
		}

		
		// deleteContact

		@Test
		public void testDeleteContact() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
			Mockito.when(userDaoImpl.getUserById(2l)).thenReturn(contact);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			boolean result = testingObject.deleteContact(user, contact);
			Assert.assertEquals(result, true);
		}

		@Test
		public void testDeleteContactContactDoesntExist() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
			Mockito.when(userDaoImpl.getUserById(2l)).thenThrow(NoResultException.class);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			boolean result = testingObject.deleteContact(user, contact);
			Assert.assertEquals(result, false);
		}

		@Test
		public void testDeleteContactUserDoesntExist() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenThrow(NoResultException.class);
			Mockito.when(userDaoImpl.getUserById(2l)).thenReturn(contact);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			boolean result = testingObject.deleteContact(user, contact);
			Assert.assertEquals(result, false);
		}

		@Test(expected = EntityExistsException.class)
		public void testDeleteContactCouldntPersist() {
			Mockito.when(userDaoImpl.getUserById(1l)).thenReturn(user);
			Mockito.when(userDaoImpl.getUserById(2l)).thenReturn(contact);
			Mockito.when(user.getUserId()).thenReturn(1l);
			Mockito.when(contact.getUserId()).thenReturn(2l);
			Mockito.doThrow(EntityExistsException.class).when(userDaoImpl).persistObject(user);
			testingObject.deleteContact(user, contact);
		}

}
