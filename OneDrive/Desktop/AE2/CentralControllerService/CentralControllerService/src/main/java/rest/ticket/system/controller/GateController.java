package rest.ticket.system.controller;

import java.util.List;


/*
 * This is the Gate Controller 
 * This is used to CRUD operation of all Gates
 */



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.ticket.system.model.Gate;
import rest.ticket.system.serviceImplimenations.GateServiceImpli;
@Path("/gate")
public class GateController {

private GateServiceImpli service=new GateServiceImpli();
	
	@Path("/list1")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Gate test()
	{
		//service.getAll();
		Gate z=new Gate(1,"");
		return z;
	}
	
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Gate save(Gate gate) {
		System.out.println("hello");
		return service.save(gate);
	}
	
	
	
	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gate get(@PathParam("id") int id) {
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
	public List<Gate> getAll() {
		return service.getAll();
	}
}
