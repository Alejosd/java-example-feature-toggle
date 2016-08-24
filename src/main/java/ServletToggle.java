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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Message text = new Message();
		IMessage messageStrategy =  new MessageFeatureToggle(text);
		Notification notification = new Notification(messageStrategy);
		resp.setStatus(HttpStatus.OK_200);
		resp.getWriter().println(notification.StrategyNotification().getMessage());


	}


}
