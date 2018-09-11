package messenger.ServiceImpl;

import java.io.Serializable;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import messenger.Dao.ChatDao;
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
	
	@Autowired
	private ChatDao chatDbService;

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
	public Chat getChat(Chat chat) {
		try{
			return chatDbService.getChatById(chat.getChatId());
		} catch (Exception e) {
			return null;
		}		
	}

	
}
