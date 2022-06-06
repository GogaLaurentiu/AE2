package rest.ticket.system.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.ticket.system.model.TicketMachine;
import rest.ticket.system.model.Zone;
import rest.ticket.system.serviceImplimenations.TicketMachineServiceImpli;
/*
 * This is the Machine Controller 
 * This is used to CRUD operation of all Machine
 * A ticket machine is adding by using this controller
 */
@Path("/machine")
public class TicketMachineController {
	
	private TicketMachineServiceImpli service=new TicketMachineServiceImpli();
	
	@Path("/list1")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Zone test()
	{
		//service.getAll();
		Zone z=new Zone(1,1);
		return z;
	}
	
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TicketMachine save(TicketMachine gate) {
		System.out.println("hello");
		return service.save(gate);
	}
	
	
	
	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TicketMachine get(@PathParam("id") int id) {
		return service.get(id);
	}
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public int delete(@PathParam("id") int id) {
		return service.delete(id);
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TicketMachine> getAll() {
		return service.getAll();
	}
}
