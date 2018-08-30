package messenger.ServiceImpl;

import java.io.Serializable;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.UserDao;
import messenger.Domain.User;
import messenger.Service.GetUser;

@Service
public class GetUserImpl implements GetUser, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private UserDao userDbService;

	@Override
	@Transactional
	public User getUser(String username) {
		try{
			return userDbService.getUserByName(username);
		} catch (NoResultException nre) {
			return null;
		}
	}
	

}
