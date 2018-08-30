package messenger.ServiceImpl;

import java.io.Serializable;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.ChatDao;
import messenger.Service.ChatValidation;

@Service
public class ChatValidationImpl implements ChatValidation, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ChatDao chatDbService;

	@Override
	@Transactional
	public boolean checkIfChatExists(Long chatId) {
		try{
			chatDbService.getChatById(chatId);
			return true;
		} catch (NoResultException nre) {
			return false;
		}
	}

}
