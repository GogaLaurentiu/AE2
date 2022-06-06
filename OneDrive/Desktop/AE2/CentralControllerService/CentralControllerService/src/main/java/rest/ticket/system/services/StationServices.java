package rest.ticket.system.services;

import java.util.List;
import rest.ticket.system.model.Stations;

public interface StationServices {
	public Stations save(Stations gate);
	public Stations update(Stations gate,int id);
	public Stations get(int id);
	public List<Stations> getAll();
	public int delete(int id);
}
