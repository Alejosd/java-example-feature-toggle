package strategy;

import java.io.IOException;

import model.Message;

public class MessageActive implements IMessage {

	
	private Message message;
	
	public MessageActive(Message message){
		this.message = message;
	}

	public Message sendMessage() throws IOException {
		// TODO Auto-generated method stub
		String text = "Funcionalidad activa sin featureToggle";
		message.setMessage(text);
		return message;
	}
	
}
