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
		
		 String valor = "12345";
		 String usuario = "asierrdu";
		
		 LDUser user = new LDUser.Builder(usuario)
				   .custom("telefono", valor)   
				   .build();

		boolean showFeature = client.boolVariation("sd",user,false);
		
		System.out.println("VALOR TOGGLE:"+showFeature);

		if (showFeature) {


			message.setMessage("Java Jetty Servlet Activado Feature Toggle Agile.   "+"usuario"+usuario+",telefono:"+valor);
			System.out.println("showing your feature");

		} else {

			message.setMessage("Java Jetty Servlet Desactivado Feature Toggle Agile.   "+"usuario"+usuario+",telefono:"+valor);
			System.out.println("Not showing your feature");

		}
		client.flush();
		client.close();

		return message;
	}

}
