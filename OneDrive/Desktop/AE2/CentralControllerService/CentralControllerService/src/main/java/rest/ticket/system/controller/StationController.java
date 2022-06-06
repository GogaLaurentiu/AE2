package rest.ticket.system.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.ticket.system.model.Employee;
import rest.ticket.system.model.Stations;
import rest.ticket.system.model.TicketMachine;
import rest.ticket.system.model.Zone;
import rest.ticket.system.utlities.FileHandleUtlities;
/*
 * This is the Sation Controller 
 * This is used to CRUD operation of all Sation
 */
@Path("/station")
public class StationController {

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Stations getstation()
	{
		ArrayList<String> allStations=new ArrayList<String>();
		allStations.add("SouthPort");
		allStations.add("Birkadle");
		allStations.add("Hillside");
		allStations.add("Ainsadle");
		allStations.add("FreshField");
		allStations.add("Formby");
		allStations.add("HighTown");
		ArrayList<Zone> zones=new ArrayList<Zone>();
		zones.add(new Zone(1, 0));
		zones.add(new Zone(2, 20));
		zones.add(new Zone(3, 30));
		zones.add(new Zone(4, 40));
		zones.add(new Zone(5, 50));
		zones.add(new Zone(6, 60));
		
		ArrayList<TicketMachine> ticketMachines=new ArrayList<TicketMachine>();
		ticketMachines.add(new TicketMachine(1, "SouthPort"));
		ticketMachines.add(new TicketMachine(2, "Birkadle"));
		Employee emp=new Employee(1, "admin", "admin", "manager");
		Stations stations=new Stations(1, allStations, zones,ticketMachines , zones, 10, 2,emp);
		System.out.println(stations);
		FileHandleUtlities.allStatioDetails.add(stations);
		return stations;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Stations getAmachine(@PathParam("id") int id)
	{
		return FileHandleUtlities.allStatioDetails.get(id-1);
	}
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Stations> getAll()
	{
		return FileHandleUtlities.allStatioDetails;
	}
	
	
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String save(Stations st)
	{
		System.out.println("hello");
		FileHandleUtlities.allStatioDetails.add(st);
		
		return "You are Succesfullu  Added a Station details";
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(int id)
	{
		System.out.println("hello");
		FileHandleUtlities.allStatioDetails.remove(id-1);
		
		return "You are Succesfullu  Deleted a Station details";
	}
}
