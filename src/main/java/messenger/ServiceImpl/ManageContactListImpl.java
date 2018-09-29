package messenger.ServiceImpl;

import java.util.Set;

import javax.persistence.NoResultException;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.UserDao;
import messenger.Domain.User;
import messenger.Service.ManageContactList;

@Service
public class ManageContactListImpl implements ManageContactList, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDao userDbService;

	@Override
	@Transactional
	public boolean addContact(User user, User contact) {
		try {
			user = userDbService.getUserById(user.getUserId());
			contact = userDbService.getUserById(contact.getUserId());
		} catch (NoResultException e) {
			return false;
		}
		Set<User> contacts = user.getContacts();
		contacts.add(contact);
		user.setContacts(contacts);
		userDbService.persistObject(user);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteContact(User user, User contact) {
		try {
			user = userDbService.getUserById(user.getUserId());
			contact = userDbService.getUserById(contact.getUserId());
		} catch (NoResultException e) {
			return false;
		}
		Set<User> contacts = user.getContacts();
		contacts.remove(contact);
		userDbService.persistObject(user);
		return true;
	}

}
