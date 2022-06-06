package rest.ticket.system.model;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
 * Stations class Entity 
 */

public class Stations {
	
	private int id;
	private ArrayList<String> stationName;
	private  ArrayList<Zone> zonesCost;
	private  ArrayList<TicketMachine> ticketMachines;
	private  ArrayList<Zone> zones;
	private int peak;
	private int offpeak;
	private Employee employee;
	
	
	public Stations() {
	}
	
	public Stations(int id1, ArrayList<String> stationName1, ArrayList<Zone> zonesCost1,
			ArrayList<TicketMachine> ticketMachines1, ArrayList<Zone> zones1, int peak1, int offpeak1,Employee emp) {
		this.id = id1;
		this.stationName = stationName1;
		this.zonesCost = zonesCost1;
		this.ticketMachines = ticketMachines1;
		this.zones = zones1;
		this.peak = peak1;
		this.offpeak = offpeak1;
		this.employee=emp;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<String> getStationName() {
		return stationName;
	}
	public void setStationName(ArrayList<String> stationName) {
		this.stationName = stationName;
	}
	public ArrayList<Zone> getZonesCost() {
		return zonesCost;
	}
	public void setZonesCost(ArrayList<Zone> zonesCost) {
		this.zonesCost = zonesCost;
	}
	public ArrayList<TicketMachine> getTicketMachines() {
		return ticketMachines;
	}
	public void setTicketMachines(ArrayList<TicketMachine> ticketMachines) {
		this.ticketMachines = ticketMachines;
	}
	public ArrayList<Zone> getZones() {
		return zones;
	}
	public void setZones(ArrayList<Zone> zones) {
		this.zones = zones;
	}
	public int getPeak() {
		return peak;
	}
	public void setPeak(int peak) {
		this.peak = peak;
	}
	public int getOffpeak() {
		return offpeak;
	}
	public void setOffpeak(int offpeak) {
		this.offpeak = offpeak;
	}
	@Override
	public String toString() {
		return "Stations [id=" + id + ", stationName=" + stationName + ", zonesCost=" + zonesCost + ", ticketMachines="
				+ ticketMachines + ", zones=" + zones + ", peak=" + peak + ", offpeak=" + offpeak + "]";
	}
	
	
}
