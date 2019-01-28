package fr.insa.soa.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import fr.insa.soa.RestProjectSalles.Presence;
import fr.insa.soa.RestProjectSalles.Temperature;
import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("TemperatureServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation temperature
		Response r = new Response();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/temperature");
		get.addHeader("accept", "application/json");
		CloseableHttpResponse reqResp = client.execute(get);
		r.setStatusCode(reqResp.getStatusLine().getStatusCode());
		r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
		JSONObject json = new JSONObject(r.getRepresentation());
		Temperature t = new Temperature();
		//t.setValue(json.getString("value"));
		float valueTemp = Float.parseFloat(json.getString("value"));
		System.out.println("temperature : "+valueTemp);
		
		//Recuperation presence
		get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/presence");
		get.addHeader("accept", "application/json");
		reqResp = client.execute(get);
		r.setStatusCode(reqResp.getStatusLine().getStatusCode());
		r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
		//System.out.println(r.getRepresentation());
		json = new JSONObject(r.getRepresentation());
		String p = json.getString("value");
		System.out.println("presence : "+p);
		
		//Recuperation temperature exterieure
		get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/temperature_ext");
		get.addHeader("accept", "application/json");
		reqResp = client.execute(get);
		r.setStatusCode(reqResp.getStatusLine().getStatusCode());
		r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
		//System.out.println(r.getRepresentation());
		json = new JSONObject(r.getRepresentation());
		float ot = Float.parseFloat(json.getString("value"));
		System.out.println("temperature exterieure : "+ot);
		
		//GESTION DU CHAUFFAGE
		Client c = new Client();
		String url = "http://localhost:8080/~/mn-cse/mn-name/HEATER_STATE/DATA"; // DATA_container_for_heater
		String type = "4"; // cin
		if(valueTemp<19 && p.equals("true")){
			//Allumage des chauffages si temperature sous 19 et si quelqu un dans la salle
			String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
					+ "<cnf>application/xml</cnf>" + "<con>true</con>" + "</m2m:cin>";
			System.out.println(c.create(url, representation, "admin:admin", type));
		}else if((valueTemp>20 && p.equals("false"))||ot > 25){
			//Extinction des chauffages si temperature au-dessus de 20 et personne dans la salle
			String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
					+ "<cnf>application/xml</cnf>" + "<con>false</con>" + "</m2m:cin>";
			System.out.println(c.create(url, representation, "admin:admin", type));
		}
		
		//GESTION DES FENETRES
		//Ouverture des fenetres entre 18 et 27 dehors et si dehors plus froid que dedans
		url = "http://localhost:8080/~/mn-cse/mn-name/WINDOW_POSITION/DATA";
		if(ot<valueTemp && ot>=18 && ot <=27){
			String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
					+ "<cnf>application/xml</cnf>" + "<con>true</con>" + "</m2m:cin>";
			System.out.println(c.create(url, representation, "admin:admin", type));
		}
		
		//GESTION DE L'ALARME
		String time = request.getParameter("time");
		request.setAttribute("ttime", time);
		int heure = Integer.parseInt(time.substring(0,2));
		if((heure<6||heure>=22) && p.equals("false")){
			request.setAttribute("alert", "true (if change in door position)");	
		}else{
			request.setAttribute("alert", "false");
		}
		
		//GESTION DES LUMIERES
		if(p.equals("false") && (heure<6||heure>=18)){
			String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
					+ "<cnf>application/xml</cnf>" + "<con>false</con>" + "</m2m:cin>";
			c.create("http://localhost:8080/~/mn-cse/mn-name/LUMIERE/DATA", representation, "admin:admin", type);
		}
		
		request.getRequestDispatcher("TemperatureServlet").forward(request, response);
	}

}
