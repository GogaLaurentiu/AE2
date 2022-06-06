

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DataBindingException;

import javafx.scene.chart.PieChart.Data;

@WebServlet("/destination")
public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Destination() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("stationName"));
		int stationIndex=Integer.parseInt(request.getParameter("stationName"));
		
		System.out.println(UtlityService.currentStstion+"  "+stationIndex);
		
		//int totalStation=UtlityService.defualtCheckingConfig().getStationName().size();
		
		String from=UtlityService.defualtCheckingConfig().getStationName().get(UtlityService.currentStstion);
		
		String toStation=UtlityService.defualtCheckingConfig().getStationName().get(stationIndex);
	
		UtlityService.uptoGate=stationIndex;
		
		int totalPrice=0;
		for(int i=0;i<stationIndex;i++)
		{
			totalPrice=totalPrice+UtlityService.defualtCheckingConfig().getZonesCost().get(i).getCost();
			
		}
		System.out.println(totalPrice);
		int peak=UtlityService.defualtCheckingConfig().getPeak();
		int ticketAmount=0;
		
		if(peak!=0)
		{
			System.out.println(peak);
			ticketAmount=totalPrice*peak/100;
			ticketAmount=totalPrice+ticketAmount;
			System.out.println(ticketAmount);
			request.setAttribute("peak",peak); 
		}
		else
		{
			int offPeak=UtlityService.defualtCheckingConfig().getOffpeak();
			ticketAmount=totalPrice*offPeak/100;
			ticketAmount=totalPrice-ticketAmount;
			System.out.println(ticketAmount);
			request.setAttribute("peak",-peak); 
			
		}
		
		String key=UtlityService.generateKey();
		
		request.setAttribute("from",from); 
		request.setAttribute("to",toStation); 
		request.setAttribute("ticketAmount",ticketAmount); 
		request.setAttribute("secretCode",key); 
		UtlityService.authorizedTickets.put(key,UtlityService.defualtCheckingConfig().getGates().get(stationIndex).getStationName());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowTicket.jsp");
	    dispatcher.forward(request, response);
		
		
	}

}
