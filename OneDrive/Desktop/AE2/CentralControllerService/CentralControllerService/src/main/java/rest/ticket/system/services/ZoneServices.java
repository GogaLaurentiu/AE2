package rest.ticket.system.services;

import java.util.List;

import rest.ticket.system.model.Gate;
import rest.ticket.system.model.Zone;

public interface ZoneServices {
	public Zone save(Zone gate);
	public Zone update(Zone gate,int id);
	public Zone get(int id);
	public List<Zone> getAll();
	public int delete(int id);
}
