

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validate")
public class TicketValidater extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TicketValidater() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ticket Validator");
		String stationName=request.getParameter("options");
		String key=request.getParameter("key");
		System.out.println(stationName+"   "+key);
		stationName=UtlityService.defualtCheckingConfig().getStationName().get(Integer.parseInt(stationName));
		String authorizedSationName=UtlityService.authorizedTickets.get(key);
		System.out.println("Auth Station Name :"+authorizedSationName);
		System.out.println("Passenger Station Name :"+stationName);
		if(authorizedSationName.equalsIgnoreCase(stationName))
		{
			request.setAttribute("result","THANKS FOR USING THIS,PLEASE VISIT GAIN "); 
			UtlityService.authorizedTickets.remove(authorizedSationName);
		}
		else
		{
			request.setAttribute("result","Sorry!!! YOU DONT HAVE ACCES IN THIS GATE"); 
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp");
	    dispatcher.forward(request, response);
	}

}
