package rest.ticket.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * Zone class Entity 
 */
@Entity
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int cost;
	public Zone(int id, int cost) {
		super();
		this.id = id;
		this.cost = cost;
	}
	public Zone() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Zone [id=" + id + ", cost=" + cost + "]";
	}
	
	
}
