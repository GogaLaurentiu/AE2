package rest.ticket.system.services;

import java.util.List;

import rest.ticket.system.model.Gate;

public interface GateServices {

	public Gate save(Gate gate);
	public Gate update(Gate gate,int id);
	public Gate get(int id);
	public List<Gate> getAll();
	public int delete(int id);
	
}
