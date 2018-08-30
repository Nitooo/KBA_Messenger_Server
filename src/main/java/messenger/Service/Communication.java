package messenger.Service;

import java.util.List;

import messenger.Domain.Chat;
import messenger.Domain.Message;

public interface Communication {
	
	/**
	 * sends message
	 * @param message message to send
	 * @return true: message successful send; false: message couldn't send
	 */
	public boolean sendMessage(Message message);
	
	/**
	 * @param chat chat for receive messages
	 * @return List of all Messages belonging to the chat
	 */
	public List<Message> recieveMessage(Chat chat);

}
