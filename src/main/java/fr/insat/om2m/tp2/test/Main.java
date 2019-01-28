package fr.insat.om2m.tp2.test;

import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.insat.om2m.tp2.client.Client;

public class Main {

	public static void main(String[] args) throws IOException {

		Client client = new Client();

		// create a MY SENSOR (named TEMPERATURE) application
		String url = "http://localhost:8080/~/mn-cse/mn-name";
		// String representation =
		// readFile("C:/Users/cbrav/Documents/fr.insat.om2m.tp2/src/main/resources/requests/create_ae.xml");//TEMPERATURE
		// String representation =
		// readFile("C:/Users/cbrav/workspace/RestProjectSalles/src/main/resources/requests/create_light.xml");//LUMIERE
		// DOOR POSITION
		String representation = "<m2m:ae xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"TEMPERATURE_EXT\">"
				+ "<api>app-temp</api>" + "<lbl>Type/sensor Category/presence Location/room1</lbl>"
				+ "<rr>false</rr>" + "</m2m:ae>";
		String originator = "admin:admin";
		String type = "2"; // 4 pour les CIN //3 for container CNT //2 for
							// sensor
		//client.create(url, representation, originator, type);

		// retrieve the app et other stuff
		// url = "http://localhost:8080/~/mn-cse/CAE194318868"; //TEMPERATURE
		//url = "http://localhost:8080/~/mn-cse/CAE392060000"; // LUMIERE
		//door position
		//url = "http://localhost:8080/~/mn-cse/CAE528321499";
		//window position
		//url = "http://localhost:8080/~/mn-cse/CAE608972214";
		//heater state
		//url = "http://localhost:8080/~/mn-cse/CAE440183420";
		//presence sensor
		//url = "http://localhost:8080/~/mn-cse/CAE346354793";
		//outside temp
		url="http://localhost:8080/~/mn-cse/CAE358152715";
		// System.out.println(client.retrieve(url, originator));
		// System.out.println(client.retrieve("http://localhost:8080/~/mn-cse/cin-355517943",
		// originator));

		// create a DATA container
		representation = readFile("C:/Users/cbrav/Documents/fr.insat.om2m.tp2/src/main/resources/requests/create_cnt.xml");
		type = "3";
		//client.create(url, representation, originator, type);
		// delete this container (http://localhost:8080/~/mn-cse/cnt-707047714)
		// client.delete("http://localhost:8080/~/mn-cse/cnt-707047714",
		// originator);

		// url du container data de temperature
		// url = "http://localhost:8080/~/mn-cse/cnt-648051517";
		// url du container data des lumieres
		//url = "http://localhost:8080/~/mn-cse/cnt-328372442";
		//des door position
		//url="http://localhost:8080/~/mn-cse/cnt-508384506";
		//des window position
		//url="http://localhost:8080/~/mn-cse/cnt-683564504";
		//des heater state
		//url="http://localhost:8080/~/mn-cse/cnt-671515391";
		//des presence sensor
		//url="http://localhost:8080/~/mn-cse/cnt-753274362";
		//out temp
		url="http://localhost:8080/~/mn-cse/cnt-500318626";
		
		// representation = readFile("C:/Users/cbrav/Documents/fr.insat.om2m.tp2/src/main/resources/requests/create_cin.xml");
		type = "4";//ctn

		/*representation =
				 "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
				 +"<cnf>application/xml</cnf>"
				 +"<con>"+false+"</con>"
				 +"</m2m:cin>";*/

		// TEMPERATURE
		// Creation de donn�es = ajouter une boucle de generation de
		// temp�ratures en Java, parser en JSON/XML, recupere en string
		// creons le xml en string brut icimeme en mettant une temperature
		// aleatoire entre 20 et 23
		representation =
		  "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
		  +"<cnf>application/xml</cnf>"
		  +"<con>"+((double)Math.round((18+Math.random()*7)*10)/10)+"</con>"
		  +"</m2m:cin>";
		 
		// pour tous les booleans
		/*
		 * String representation =
		 * "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
		 * +"<cnf>application/xml</cnf>" +"<con>"+false+"</con>" +"</m2m:cin>";
		 */

		client.create(url, representation, originator, type);
		// System.out.println(client.create(url, representation, originator,
		// type));

		// System.out.println(representation);

		// System.out.println(client.update("http://localhost:8080/~/mn-cse/cin-528232539",
		// representation, originator));//Update on ContentInstance is not
		// Allowed
		// System.out.println(client.retrieve("http://localhost:8080/~/mn-cse/mn-name/TEMPERATURE/DATA/la",
		// originator));//Retrieve the latest temperature
		//client.create(url, representation, originator, type);
	}

	static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}

}