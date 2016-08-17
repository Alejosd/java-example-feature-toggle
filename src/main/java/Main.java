import java.io.IOException;
import java.util.Arrays;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;



public class Main {

	public static void main(String[] args) throws Exception {
		
		 Server server = new Server(8080);
		         ServletContextHandler handler = new ServletContextHandler(server, "/");
		         handler.addServlet(ServletToggle.class, "/");
		         server.start();
	}
	
}
