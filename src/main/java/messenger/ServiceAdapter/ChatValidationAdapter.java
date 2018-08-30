package messenger.ServiceAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import messenger.Service.ChatValidation;

@RestController
@RequestMapping("/chatValidation")
public class ChatValidationAdapter {
	
	@Autowired
	private ChatValidation chatValidationService;

	@RequestMapping(value = "/checkIfChatExists", method = RequestMethod.GET)
	public boolean checkIfChatExists(@RequestParam(value = "chatId") Long chatId) {
		return chatValidationService.checkIfChatExists(chatId);
	}
	
}
