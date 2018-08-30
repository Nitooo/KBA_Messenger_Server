package messenger.Service;

public interface ChatValidation {

	/**
	 * checks if a chat with the given id exists
	 * @param chatId of the chat
	 * @return true: chat exists; false: chat doesn't exist
	 */
	public boolean checkIfChatExists(Long chatId);
	

}
