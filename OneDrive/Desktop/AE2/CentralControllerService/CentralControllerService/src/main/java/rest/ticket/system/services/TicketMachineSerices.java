package rest.ticket.system.services;

import java.util.List;

import rest.ticket.system.model.Gate;
import rest.ticket.system.model.TicketMachine;

public interface TicketMachineSerices {
	public TicketMachine save(TicketMachine gate);
	public TicketMachine update(TicketMachine gate,int id);
	public TicketMachine get(int id);
	public List<TicketMachine> getAll();
	public int delete(int id);
}
