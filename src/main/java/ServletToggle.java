import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;


public class ServletToggle extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	LDClient client = new LDClient("sdk-548dca6e-ae25-4a5f-861d-8f854a267956");
	    LDUser user = new LDUser("alejosd5@gmail.com");
	    		boolean showFeature = client.boolVariation("sd", user,false);

	    		if (showFeature) {
	    		  System.out.println("Showing your feature");
	    	        resp.setStatus(HttpStatus.OK_200);
	    	        resp.getWriter().println("Activado");
	    		} else {
	    		  System.out.println("Not showing your feature");
	    		  resp.setStatus(HttpStatus.OK_200);
	    	        resp.getWriter().println("Desactivado");
	    		}
	    		client.flush();
	    		client.close();


    }

	
}
