package fr.insa.soa.RestProjectSalles;

import javax.ws.rs.core.MediaType;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.mapper.Mapper;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("chauffage")
public class HeaterStateRessources {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HeaterState getHeaterState() throws IOException{
		HeaterState hs = new HeaterState();
		Client c = new Client();
		Mapper mapper = new Mapper();
		ContentInstance cin = (ContentInstance) mapper.unmarshal(c.retrieve("http://localhost:8080/~/mn-cse/mn-name/HEATER_STATE/DATA/la", "admin:admin").getRepresentation());
		hs.setValue(cin.getContent());
		return hs;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void addHeaterState(HeaterState h){
		System.out.println("Heater now is "+h.getValue());
	}
}
