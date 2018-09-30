package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Exception.Exception_All;
import messenger.Exception.Exception_EntityManager;
import messenger.Exception.Exception_Runtime;
import messenger.Service.ChatValidation;

@RestController
@RequestMapping("/chatValidation")
public class ChatValidationAdapter {

	@Autowired
	private ChatValidation chatValidationService;

	/**
	 * Restadapter for check if chat exists
	 * 
	 * @param chatId for the chat to find in the system
	 * @return true: chat exist ; false: chat doesn't exist
	 * @throws Exception_EntityManager if an exception in the entitymanager occurs
	 * @throws Exception_Runtime       if an RuntimeException occurs
	 * @throws Exception_All           if an another Exception occurs
	 */
	@RequestMapping(value = "/checkIfChatExists", method = RequestMethod.GET)
	public boolean checkIfChatExists(@RequestParam(value = "chatId") Long chatId) {
		try {
			return chatValidationService.checkIfChatExists(chatId);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_EntityManager(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Runtime(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_All(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		}
	}
}
