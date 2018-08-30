package messenger.ServiceImpl;

import java.io.Serializable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.MessageDao;
import messenger.Domain.Chat;
import messenger.Domain.Message;
import messenger.Service.Communication;

@Service
public class CommunicationImpl implements Communication, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MessageDao messageDbService;

	@Override
	@Transactional
	public boolean sendMessage(Message message) {
		try{
			messageDbService.persistObject(message);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public List<Message> recieveMessage(Chat chat) {
		try{
			return chat.getMessages(); //Ganze Methode sehr sinnvoll oder?
		} catch (Exception e) {
			return null;
		}		
	}

	
}
