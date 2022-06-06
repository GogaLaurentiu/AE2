
import java.util.ArrayList;

/*
 * Stations class Entity 
 */

public class Stations {
	
	private int id;
	private ArrayList<String> stationName;
	private  ArrayList<Zone> zonesCost;
	private  ArrayList<TicketMachine> ticketMachines;
	private  ArrayList<Gate> gates;
	private int peak;
	private int offpeak;
	private Employee employee;

	
	public ArrayList<Gate> getGates() {
		return gates;
	}

	public void setGates(ArrayList<Gate> gates) {
		this.gates = gates;
	}

	public Stations() {
	}
	
	public Stations(int id1, ArrayList<String> stationName1, ArrayList<Zone> zonesCost1,
			ArrayList<TicketMachine> ticketMachines1, ArrayList<Gate> gate1, int peak1, int offpeak1,Employee emp) {
		this.id = id1;
		this.stationName = stationName1;
		this.zonesCost = zonesCost1;
		this.ticketMachines = ticketMachines1;
		this.gates = gate1;
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
				+ ticketMachines + ", gates=" + gates + ", peak=" + peak + ", offpeak=" + offpeak + ", employee="
				+ employee + "]";
	}
	
	
	
}
