package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Exception.Exception_Custom;
import messenger.Service.ChatValidation;

@RestController
@RequestMapping("/chatValidation")
public class ChatValidationAdapter {

	@Autowired
	private ChatValidation chatValidationService;

	@RequestMapping(value = "/checkIfChatExists", method = RequestMethod.GET)
	public boolean checkIfChatExists(@RequestParam(value = "chatId") Long chatId) {
		try {
			return chatValidationService.checkIfChatExists(chatId);
		} catch (IllegalArgumentException | TransactionRequiredException e) {
			throw new Exception_Custom(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		} catch (RuntimeException e) {
			throw new Exception_Custom(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		} catch (Exception e) {
			throw new Exception_Custom(
					"Couldn't execute //checkIfChatExists - Exception: " + e + " Message: " + e.getMessage());
		}
	}
}
