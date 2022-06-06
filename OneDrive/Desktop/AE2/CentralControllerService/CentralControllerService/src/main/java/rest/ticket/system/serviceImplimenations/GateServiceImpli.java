package rest.ticket.system.serviceImplimenations;

import java.util.List;
import rest.ticket.system.dao.GateDao;
import rest.ticket.system.model.Gate;
import rest.ticket.system.services.GateServices;


public class GateServiceImpli implements GateServices {

	private GateDao dao=new GateDao();
	
	public Gate save(Gate gate) {
		Gate temp=dao.save(gate);
		if(temp==null)
		{
			System.out.println("Exception in saving Gate");
		}
		return temp;
	}

	public Gate update(Gate gate, int id) {
		Gate temp=dao.update(gate, id);
		if(temp==null)
		{
			System.out.println("Exception in Update Gate");
		}
		return temp;
	
	}

	public Gate get(int id) {
		Gate temp=dao.get(id);
		if(temp==null)
		{
			System.out.println("Exception in get Gate");
		}
		return temp;
	}

	public List<Gate> getAll() {
		List<Gate> temp=dao.getAll();
		if(temp!=null)
		{
			System.out.println(temp);
		}
		else
		{
			System.out.println("Exception in getAll Gate");
		}
		return temp;
	}

	public int delete(int id) {
		int result=dao.delete(id);
		if(result==-1)
		{
			System.out.println("Error in deleteing Gate");
		}
		return result;
	}
	
	

}
