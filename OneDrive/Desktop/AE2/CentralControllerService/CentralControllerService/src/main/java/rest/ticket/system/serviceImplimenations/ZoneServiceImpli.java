package rest.ticket.system.serviceImplimenations;

import java.util.List;

import rest.ticket.system.dao.ZoneDao;
import rest.ticket.system.model.Zone;
import rest.ticket.system.services.ZoneServices;

public class ZoneServiceImpli implements ZoneServices{

	ZoneDao dao=new ZoneDao();
	public Zone save(Zone gate) {
		Zone temp=dao.save(gate);
		if(temp==null)
		{
			System.out.println("Exception in saving Zone");
		}
		return temp;
	}

	public Zone update(Zone gate, int id) {
		Zone temp=dao.update(gate, id);
		if(temp==null)
		{
			System.out.println("Exception in saving Zone");
		}
		return temp;
	
	}

	public Zone get(int id) {
		Zone temp=dao.get(id);
		if(temp==null)
		{
			System.out.println("Exception in saving Zone");
		}
		return temp;
	}

	public List<Zone> getAll() {
		List<Zone> temp=dao.getAll();
		if(temp!=null)
		{
			System.out.println(temp);
		}
		else
		{
			System.out.println("Exception in getAll Zone");
		}
		return temp;
	}

	public int delete(int id) {
		int result=dao.delete(id);
		if(result==-1)
		{
			System.out.println("Error in deleteing Zone");
		}
		return result;
	}
	
	
}
