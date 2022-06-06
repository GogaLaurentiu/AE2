

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gateview")
public class gateView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public gateView() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GATE VIEW");
		ArrayList<String> options=UtlityService.defualtCheckingConfig().getStationName();
		options.remove(options.size()-1);
		request.setAttribute("stationName",options); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gate.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GATE VIEW");
		ArrayList<String> options=UtlityService.defualtCheckingConfig().getStationName();
		options.remove(options.size()-1);
		request.setAttribute("stationName",options); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gate.jsp");
	    dispatcher.forward(request, response);
		
	}

}
