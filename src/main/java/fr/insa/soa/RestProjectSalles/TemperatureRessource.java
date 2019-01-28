package fr.insa.soa.RestProjectSalles;

import java.io.IOException;

import javax.crypto.CipherInputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.ContentInstance;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.mapper.Mapper;

@Path("temperature")
public class TemperatureRessource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Temperature getTemperature() throws IOException{
		Temperature temperature = new Temperature();
		Client c = new Client();
		Mapper mapper = new Mapper();
		ContentInstance cin = (ContentInstance) mapper.unmarshal(c.retrieve("http://localhost:8080/~/mn-cse/mn-name/TEMPERATURE/DATA/la", "admin:admin").getRepresentation());
		temperature.setNom(cin.getName());
		temperature.setValue(cin.getContent());
		return temperature;
	}
}
