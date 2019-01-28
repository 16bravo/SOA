package fr.insa.soa.RestProjectSalles;

import javax.ws.rs.core.MediaType;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.mapper.Mapper;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("lumieres")
public class LumieresRessources {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Lumieres getLumieres() throws IOException{
		Lumieres l = new Lumieres();
		Client c = new Client();
		Mapper mapper = new Mapper();
		ContentInstance cin = (ContentInstance) mapper.unmarshal(c.retrieve("http://localhost:8080/~/mn-cse/mn-name/LUMIERE/DATA/la", "admin:admin").getRepresentation());
		l.setId(cin.getName());
		l.setValue(cin.getContent());
		return l;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateLumiere(Lumieres l){
		System.out.println("Light now is "+l.getValue());
	}
}
