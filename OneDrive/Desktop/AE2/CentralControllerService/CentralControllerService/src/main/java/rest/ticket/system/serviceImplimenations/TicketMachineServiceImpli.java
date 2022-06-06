package rest.ticket.system.serviceImplimenations;

import java.util.List;

import rest.ticket.system.dao.TicketMachineDao;
import rest.ticket.system.model.TicketMachine;
import rest.ticket.system.services.TicketMachineSerices;

public class TicketMachineServiceImpli implements TicketMachineSerices {
	
	TicketMachineDao dao=new TicketMachineDao();
	
	public TicketMachine save(TicketMachine gate) {
		TicketMachine temp=dao.save(gate);
		if(temp==null)
		{
			System.out.println("Exception in saving TicketMachineDao");
		}
		return temp;
	}

	public TicketMachine update(TicketMachine gate, int id) {
		TicketMachine temp=dao.update(gate, id);
		if(temp==null)
		{
			System.out.println("Exception in update TicketMachineDao");
		}
		return temp;
	
	}

	public TicketMachine get(int id) {
		TicketMachine temp=dao.get(id);
		if(temp==null)
		{
			System.out.println("Exception in get TicketMachineDao");
		}
		return temp;
	}

	public List<TicketMachine> getAll() {
		List<TicketMachine> temp=dao.getAll();
		if(temp!=null)
		{
			System.out.println(temp);
		}
		else
		{
			System.out.println("Exception in getAll TicketMachineDao");
		}
		return temp;
	}

	public int delete(int id) {
		int result=dao.delete(id);
		if(result==-1)
		{
			System.out.println("Error in deleteing TicketMachineDao");
		}
		return result;
	}
	
	
}
