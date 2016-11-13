package strategy;
import java.io.IOException;



import model.Message;

public class Notification {

	private IMessage message;

	public Notification(){
	}

	  public IMessage getMessage() {
		return message;
	}

	public void setMessage(IMessage message) {
		this.message = message;
	}

	public Message StrategyNotification() throws IOException{
		return message.sendMessage();
	  }

}
