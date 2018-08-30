package messenger.Service;

import messenger.Domain.User;

public interface GetUser { 
	
	/**
	 * returns the user that the username belong to
	 * @param username for which the user object is to be returned
	 * @return user that belongs to the username
	 */
	public User getUser(String username);

}
