package rest.ticket.system.serviceImplimenations;

import java.util.List;

import rest.ticket.system.dao.StationDao;
import rest.ticket.system.model.Stations;
import rest.ticket.system.services.StationServices;

public class StationServcieImpli implements StationServices {

	private StationDao dao=new StationDao();

   public Stations save(Stations gate) {
	   Stations temp=dao.save(gate);
		if(temp==null)
		{
			System.out.println("Exception in saving Stations");
		}
		return temp;
	}

	public Stations update(Stations gate, int id) {
		Stations temp=dao.update(gate, id);
		if(temp==null)
		{
			System.out.println("Exception in update Stations");
		}
		return temp;
	
	}

	public Stations get(int id) {
		Stations temp=dao.get(id);
		if(temp==null)
		{
			System.out.println("Exception in get Stations");
		}
		return temp;
	}
   public List<Stations> getAll() {
	   List<Stations> temp=dao.getAll();
		if(temp!=null)
		{
			System.out.println(temp);
			
		}
		else
		{
			System.out.println("Exception in getAll Stations");
		}
		return temp;
	}
   public int delete(int id) {
	   int result=dao.delete(id);
	   if(result==-1)
		{
			System.out.println("Error in deleteing Stations");
		}
	  
		return result;
	}
	
	
}
