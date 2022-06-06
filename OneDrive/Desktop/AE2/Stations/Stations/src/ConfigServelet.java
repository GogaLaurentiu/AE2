

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConfigServelet")
public class ConfigServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ConfigServelet() {
        super();
      
    }

	public void init(ServletConfig config) throws ServletException {
		 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/*URL url = new URL("http://localhost:8080/CentralControllerService/station/test");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestProperty("Accept", "application/json");
		System.out.println(http.getResponseMessage() + " " + http.getResponseCode()  );
		int responseCode = http.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		StringBuffer result = new StringBuffer();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String inputLine;
			

			while ((inputLine = in.readLine()) != null) {
				result.append(inputLine);
			}
			in.close();

			System.out.println("ORIGINAL DATA"+result.toString());
			
		} else {
			System.out.println("GET request not worked");
		}
	
		http.disconnect();
		 JSONObject jsonObject = new JSONObject(result.toString());
		 Gson gson=new Gson();
		 Stations station=gson.fromJson(result.toString(),Stations.class);
		System.out.println(station);
		*/

		System.out.println("ConfigServelet GET");
		ArrayList<Integer> id=new ArrayList<Integer>();
		int totalStations=UtlityService.defualtCheckingConfig().getStationName().size();
		for(int i=1;i<=totalStations;i++)
			id.add(i);
		request.setAttribute("options",id); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("Station.jsp");
	    dispatcher.forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println(request.getParameter("options"));
	     

			ArrayList<String> options=UtlityService.defualtCheckingConfig().getStationName();
			options.remove(options.size()-1);
			request.setAttribute("stationName",options); 
			int totalStations=UtlityService.defualtCheckingConfig().getStationName().size();
			request.setAttribute("name",UtlityService.defualtCheckingConfig().getStationName().get(0)); 
			UtlityService.currentStstion=0;
			System.out.println("Current Station :"+UtlityService.currentStstion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TicketMachine.jsp");
		    dispatcher.forward(request, response);
	}

}
