package messenger.Service;

import messenger.Domain.Chat;
import messenger.Domain.Message;

public interface Communication {

	/**
	 * sends message
	 * 
	 * @param message message to send
	 * @return true: message successful send; false: message couldn't send
	 */
	public boolean sendMessage(Message message);

	/**
	 * @param chat chat for receive messages
	 * @return chat with all messages
	 */
	public Chat getChat(Chat chat);

}
