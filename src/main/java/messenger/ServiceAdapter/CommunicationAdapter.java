package messenger.ServiceAdapter;

import javax.persistence.TransactionRequiredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.Chat;
import messenger.Domain.Message;
import messenger.Exception.Exception_All;
import messenger.Exception.Exception_EntityManager;
import messenger.Exception.Exception_Runtime;
import messenger.Service.Communication;

@RestController
@RequestMapping("/communication")
public class CommunicationAdapter {

	@Autowired
	private Communication communicationService;

	@RequestMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public boolean sendMessage(@RequestBody Message message) {
		return communicationService.sendMessage(message);
	}

	@RequestMapping(value = "/recieveMessage", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Chat getChat(@RequestBody Chat chat) {
		try {
			return communicationService.getChat(chat);
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
