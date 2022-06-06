package rest.ticket.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rest.ticket.system.model.Country;

@Path("/country")
public class CountryResource {
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Country> getCoutries(){
		
		Country ctr = new Country();
		ctr.setCode("IN");
		ctr.setName("India");
		ctr.setCountryId(101);
		
		Country ctr1 = new Country();
		ctr1.setCode("US");
		ctr1.setName("United Stated");
		ctr1.setCountryId(102);
		
		Country ctr2 = new Country();
		ctr2.setCode("UK");
		ctr2.setName("United Kindom");
		ctr2.setCountryId(103);
		
		List<Country> list = new ArrayList<Country>();
		list.add(ctr);
		list.add(ctr1);
		list.add(ctr2);
		
		return list;
	}

	@GET
	@Path("/info/{countryCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryInfo(@PathParam("countryCode") String countryCode){
		
		
		Country ctr = new Country();
		ctr.setCode("IN");
		ctr.setName("India");
		ctr.setCountryId(101);
		
		return ctr;
	}
	
	@POST
	@Path("/addCountry")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country){
		System.out.println("in adding country");
		return country;
	}
}
