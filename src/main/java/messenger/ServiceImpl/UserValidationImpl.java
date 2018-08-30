package messenger.ServiceImpl;

import java.io.Serializable;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.UserDao;
import messenger.Service.UserValidation;

@Service
public class UserValidationImpl implements UserValidation, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private UserDao userDbService;

	@Override
	@Transactional
	public boolean checkIfUserExists(Long userId) {
		try{
			userDbService.getUserById(userId);
			return true;
		} catch (NoResultException nre) {
			return false;
		}
	} 

}
