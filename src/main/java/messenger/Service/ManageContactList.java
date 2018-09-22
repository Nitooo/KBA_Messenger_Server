package messenger.Service;

import java.util.List;

import messenger.Domain.User;

public interface ManageContactList {
	
	/**
	 * adds a contact to user contact list
	 * @param user who wants to add a contact
	 * @param contact user to add
	 * @return true: the contact was added; false: error
	 */
	public boolean addContact(User user, User contact);
	
	/**
	 * deletes a user from a user contact list
	 * @param user who wants to delete a contact
	 * @param contact user to delete
	 * @return true: contact succesful deleted false: deleting of the contact failed
	 */
	public boolean deleteContact(User user, User contact);
	
	/**
	 * returns an list with all the contact of a user
	 * @param user owner of contact list
	 * @return List of contacts belonging to the contacts of the user
	 */
	//public List<User> getContactList(User user);
	
}
