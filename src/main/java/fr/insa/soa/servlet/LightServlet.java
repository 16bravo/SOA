package fr.insa.soa.servlet;

import java.io.IOException;
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

import fr.insa.soa.RestProjectSalles.Lumieres;
import fr.insa.soa.RestProjectSalles.Temperature;
import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;

/**
 * Servlet implementation class LightServlet
 */
public class LightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LightServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("TemperatureServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recuperation form et modification LUMIERES
		String light = request.getParameter("light");
		if (light.equals("true")) {
			light = "false";
		} else {
			light = "true";
		}
		;
		System.out.println(light);

		Client client = new Client();
		String url = "http://localhost:8080/~/mn-cse/mn-name/LUMIERE/DATA"; // DATA_container_for_lights
		String type = "4"; // cin
		String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
				+ "<cnf>application/xml</cnf>" + "<con>" + light + "</con>" + "</m2m:cin>";
		System.out.println(client.create(url, representation, "admin:admin", type)); // new_value_for_light_state

		request.getRequestDispatcher("TemperatureServlet").forward(request, response);
	}

}
