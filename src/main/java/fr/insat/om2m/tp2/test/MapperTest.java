package fr.insat.om2m.tp2.test;

import org.eclipse.om2m.commons.resource.AE;

import fr.insat.om2m.tp2.mapper.Mapper;
import fr.insat.om2m.tp2.mapper.MapperInterface;

public class MapperTest {

	public static void main(String[] args) {
		MapperInterface mapper = new Mapper();

		// example to test marshal operation
		AE ae = new AE();
		ae.setRequestReachability(false); 
		System.out.println(mapper.marshal(System.out));
		
		// TODO test unmarshal
		// get the XML representation, parse it with unmarshal operation
	}
	
}
