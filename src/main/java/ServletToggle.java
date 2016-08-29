import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;

import model.Message;
import strategy.IMessage;
import strategy.MessageActive;
import strategy.MessageFeatureToggle;


public class ServletToggle extends HttpServlet {

	private IMessage messageStrategy;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//modelo de datos
		Message text = new Message();
		
		//Estrategia a implementar feature Toggle
		setMessageStrategy(new MessageFeatureToggle(text));
		
		//clase contexto
		Notification notification = new Notification();
		
		//asignar estrategia a utilizar
		notification.setMessage(messageStrategy);
		
		//Respuesta HTTP del servicio
		resp.setStatus(HttpStatus.OK_200);
		
		//Contenido de respuesta
		resp.getWriter().println(notification.StrategyNotification().getMessage());
	}

	IMessage getMessageStrategy() {
		return messageStrategy;
	}

	void setMessageStrategy(IMessage messageStrategy) {
		this.messageStrategy = messageStrategy;
	}
}
