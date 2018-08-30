package messenger.ServiceAdapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import messenger.Domain.Chat;
import messenger.Domain.Message;
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
	public List<Message> recieveMessage(@RequestBody Chat chat) {
		return communicationService.recieveMessage(chat);
	}

}
