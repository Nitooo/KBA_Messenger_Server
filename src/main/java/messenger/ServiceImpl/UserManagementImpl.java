package messenger.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import messenger.Dao.UserDao;
import messenger.Domain.User;
import messenger.Service.UserManagement;


@Service
public class UserManagementImpl implements UserManagement, Serializable {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private UserDao userDbService;

	@Override
	@Transactional
	public int addUser(String username, String password) {
		try{
			userDbService.getUserByName(username);
			return 1;
		} catch (NoResultException nre) {
		}	
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		try{
			userDbService.persistObject(user);
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 2;
		}	
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) { //TODO User aus Chat allen Chats entfernen durch Cascade? 
		try{
			userDbService.removeObject(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		try{
			User tmpUser = userDbService.getUserByName(user.getUsername());
			if (tmpUser.getUserId() != user.getUserId()) return false;
		} catch (NoResultException nre) {
		}	
		
		try{
			userDbService.mergeObject(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	@Transactional
	public User getUser(User user) {
		try{
			return userDbService.find(user.getClass(), user);
		} catch (NoResultException nre) {
			return null;
		}	
	}
	
	@Override
	@Transactional
	public User getUserById(Long userId) {
		try{
			return userDbService.getUserById(userId);
		} catch (NoResultException nre) {
			return null;
		}	
	}

	@Override
	@Transactional
	public User loginUser(String username, String password) {
		try{
			User user = userDbService.getUserByName(username);
			
			if(user.getPassword() != password) {
				return null;
			}
			
			return user;
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	@Transactional
	public User[] getAllUsers() {
		return userDbService.getAllUsers();
	}
  

}
