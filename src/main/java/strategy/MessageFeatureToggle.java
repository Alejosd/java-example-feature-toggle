package strategy;

import java.io.IOException;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import model.Message;

public class MessageFeatureToggle implements IMessage {


	private Message message;

	public MessageFeatureToggle(Message message){
		this.message = message;
	}

	public Message sendMessage() throws IOException {
		// TODO Auto-generated method stub
		message.setMessage("");;

		LDClient client = new LDClient("sdk-548dca6e-ae25-4a5f-861d-8f854a267956");

		//LDUser user = new LDUser("alejosd5@gmail.com");
		
		 String valor = "6";
		
		 LDUser user2 = new LDUser.Builder("alejosd5@gmail.com")
				   .custom("telefono", valor)   
				   .build();

		boolean showFeature = client.boolVariation("sd", user2,false);
		
		System.out.println("VALOR TOGGLE:"+showFeature);

		if (showFeature) {


			message.setMessage("Java Jetty Servlet Activado Feature Toggle Agile");
			System.out.println("showing your feature");

		} else {

			message.setMessage("Java Jetty Servlet Desactivado Feature Toggle Agile");
			System.out.println("Not showing your feature");

		}
		client.flush();
		client.close();

		return message;
	}

}
