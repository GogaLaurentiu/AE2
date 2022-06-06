package rest.ticket.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * Machine class Entity 
 */
@Entity
public class TicketMachine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String stationName;
	
	
	public TicketMachine() {}
	
	public TicketMachine(int id, String stationName) {
		super();
		this.id = id;
		this.stationName = stationName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	@Override
	public String toString() {
		return "TicketMachine [id=" + id + ", stationName=" + stationName + "]";
	}
	
}
