
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;



public class UtlityService {

	private Stations stations;
	private static ArrayList<String> allPrivateKeys=new ArrayList<String>();
	private static HashMap<String, String> allTickets =new HashMap<String, String>();
	public static HashMap<String, String> authorizedTickets =new HashMap<String, String>();
	static Cipher cipher = null;
	public static int currentStstion;
	public static int uptoGate;
	public void setStation(Stations sta)
	{
		this.stations=sta;
	}
	
	public static  Stations defualtCheckingConfig()
	{
	 ArrayList<String> allStations=new ArrayList<String>();
		allStations.add("SouthPort");
		allStations.add("Birkadle");
		allStations.add("Hillside");
		allStations.add("Ainsadle");
		allStations.add("FreshField");
		allStations.add("Formby");
		allStations.add("HighTown");
		ArrayList<Zone> zones=new ArrayList<Zone>();
		zones.add(new Zone(1, 10));
		zones.add(new Zone(2, 20));
		zones.add(new Zone(3, 30));
		zones.add(new Zone(4, 40));
		zones.add(new Zone(5, 50));
		zones.add(new Zone(6, 60));
		ArrayList<TicketMachine> ticketMachines=new ArrayList<TicketMachine>();
		ticketMachines.add(new TicketMachine(1, "SouthPort"));
		ticketMachines.add(new TicketMachine(2, "Birkadle"));
		Employee emp=new Employee(1, "admin", "admin", "manager");
		ArrayList<Gate> gate=new ArrayList<Gate>();
		gate.add(new Gate(1, "SouthPort"));
		gate.add(new Gate(2, "Birkadle"));
		gate.add(new Gate(3, "Hillside"));
		gate.add(new Gate(4, "Ainsadle"));
		gate.add(new Gate(5, "FreshField"));
		gate.add(new Gate(6, "Formby"));
		gate.add(new Gate(7, "HighTown"));
		Stations stations=new Stations(1, allStations, zones,ticketMachines , gate, 10, 2,emp);
		return stations;
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println(request.getParameter("stationName"));
		//int stationIndex=Integer.parseInt(request.getParameter("stationName"));
		int stationIndex=0;
		//last name is current station name,it will free for calculation
		int totalStation=UtlityService.defualtCheckingConfig().getStationName().size();
		
		String from=UtlityService.defualtCheckingConfig().getStationName().get(stationIndex);
		String toStation=UtlityService.defualtCheckingConfig().getStationName().get(totalStation-3);
		int gateid=UtlityService.defualtCheckingConfig().getGates().get(totalStation-3).getId();
		int toIndex=totalStation-3;
		System.out.println(from + " "+toStation);
		UtlityService.defualtCheckingConfig().getStationName().get(stationIndex);
		int totalPrice=0;
		for(int i=stationIndex;i<toIndex;i++)
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
		}
		else
		{
			int offPeak=UtlityService.defualtCheckingConfig().getOffpeak();
			ticketAmount=totalPrice*offPeak/100;
			ticketAmount=totalPrice-ticketAmount;
			System.out.println(ticketAmount);
			
		}
		
		//String hello="helllooo";
		//String key =encryption(hello);
		
		//System.out.println("key main "+key);
		
		//String value=allTickets.get(key);
	//	System.out.println("value : "+value);
		//boolean result=decryption(value);
		//System.out.println("passed or not : "+result);
		
		
	}
	
	public static String encryption(String text) throws Exception {
		
		String key = generateKey();
		Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = null;
		cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.ENCRYPT_MODE, aesKey);

		byte[] encrypted = null;

		encrypted = cipher.doFinal(text.getBytes());

		System.err.println(new String(encrypted));
		String encypted = encrypted.toString();
		System.err.println("Encrypted String " + encypted);
		allTickets.put(key, encypted);
		return key;
	}
	
	
	public static boolean decryption(String key) throws Exception
	{
		 cipher = Cipher.getInstance("AES");	
			
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
		cipher.init(Cipher.DECRYPT_MODE, aesKey);
        
        String value=allTickets.get(key);
        byte[] encrypted = null;
		
			encrypted = cipher.doFinal(value.getBytes());
		
        String decrypted = null;
		
			decrypted = new String(cipher.doFinal(encrypted));
	
        System.err.println("decrypted String "+decrypted);
        
		return true;
		
	}
	
	public static String generateKey()
	{
		int first = 97;
        int last = 122;
        int length = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        String resultString;
      while(true) {
        for (int i = 0; i < length; i++) {
            int limit = first + (int) 
              (random.nextFloat() * (last - first + 1));
            buffer.append((char) limit);
        }
        resultString = buffer.toString();
        System.out.println(resultString);
        if(allPrivateKeys.contains(resultString))
        {
        }
        	else
        	{
        		allPrivateKeys.add(resultString);
        		break;
        	}
 
    }
        System.out.println("RANDOM KEY : "+resultString);
		return resultString;
	}
}
