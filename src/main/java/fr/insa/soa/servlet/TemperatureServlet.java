package fr.insa.soa.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import fr.insat.om2m.tp2.mapper.Mapper;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.json.JSONObject;

import fr.insa.soa.RestProjectSalles.DoorPosition;
import fr.insa.soa.RestProjectSalles.HeaterState;
import fr.insa.soa.RestProjectSalles.Lumieres;
import fr.insa.soa.RestProjectSalles.Presence;
import fr.insa.soa.RestProjectSalles.Temperature;
import fr.insa.soa.RestProjectSalles.WindowPosition;
import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;

/**
 * Servlet implementation class TemperatureServlet
 */
public class TemperatureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TemperatureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("MainServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Recuperation form et modification TEMPERATURES
		String t = request.getParameter("temperature");
		String ot = request.getParameter("otemp");
		Client client = new Client();
		String url = "http://localhost:8080/~/mn-cse/mn-name/TEMPERATURE/DATA";
		String type="4"; //cin
		String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
				+"<cnf>application/xml</cnf>"
				+"<con>"+t+"</con>"
				+"</m2m:cin>";
		System.out.println(client.create(url, representation, "admin:admin", type)); //new value
		
		url = "http://localhost:8080/~/mn-cse/mn-name/TEMPERATURE_EXT/DATA";
		representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
				+"<cnf>application/xml</cnf>"
				+"<con>"+ot+"</con>"
				+"</m2m:cin>";
		System.out.println(client.create(url, representation, "admin:admin", type)); //new value
		
		//this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);*/
				
		//doGet(request,response);
		
		request.getRequestDispatcher("MainServlet").forward(request, response);
	}

}
