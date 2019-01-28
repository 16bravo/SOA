package fr.insa.soa.RestProjectSalles;

import javax.ws.rs.core.MediaType;

import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.mapper.Mapper;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("presence")
public class PresenceRessources {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Presence getPresence() throws IOException{
		Presence p = new Presence();
		Client c = new Client();
		Mapper mapper = new Mapper();
		ContentInstance cin = (ContentInstance) mapper.unmarshal(c.retrieve("http://localhost:8080/~/mn-cse/mn-name/PRESENCE/DATA/la", "admin:admin").getRepresentation());
		p.setValue(cin.getContent());
		return p;
	}
}
