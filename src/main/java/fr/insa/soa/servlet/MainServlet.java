package fr.insa.soa.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import fr.insa.soa.RestProjectSalles.DoorPosition;
import fr.insa.soa.RestProjectSalles.HeaterState;
import fr.insa.soa.RestProjectSalles.Lumieres;
import fr.insa.soa.RestProjectSalles.Presence;
import fr.insa.soa.RestProjectSalles.Temperature;
import fr.insa.soa.RestProjectSalles.WindowPosition;
import fr.insat.om2m.tp2.client.Response;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doGet");
				Response r = new Response();

				CloseableHttpClient client = HttpClients.createDefault();
				
				// Instantiate the correct Http Method
				HttpGet get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/lumieres");
				get.addHeader("accept", "application/json");
				try {
					// GET LUMIERE
					// send request
					CloseableHttpResponse reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					//System.out.println(r.getRepresentation());
					JSONObject json = new JSONObject(r.getRepresentation());
					Lumieres l = new Lumieres();
					l.setValue(json.getString("value"));
					request.setAttribute("l", l);

					// GET TEMPERATURE
					get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/temperature");
					get.addHeader("accept", "application/json");
					reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					json = new JSONObject(r.getRepresentation());
					Temperature t = new Temperature();
					t.setValue(json.getString("value"));
					request.setAttribute("t", t);
					System.out.println(t.getValue());
					
					// GET TEMPERATURE EXTERIEURE
					get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/temperature_ext");
					get.addHeader("accept", "application/json");
					reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					//System.out.println(r.getRepresentation());
					json = new JSONObject(r.getRepresentation());
					Temperature ot = new Temperature();
					ot.setValue(json.getString("value"));
					request.setAttribute("ot", ot);
					
					// GET DOOR POSITION
					get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/portes");
					get.addHeader("accept", "application/json");
					reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					//System.out.println(r.getRepresentation());
					json = new JSONObject(r.getRepresentation());
					DoorPosition d = new DoorPosition();
					d.setValue(json.getString("value"));
					request.setAttribute("d", d);
					
					// GET WINDOW POSITION
					get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/fenetres");
					get.addHeader("accept", "application/json");
					reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					//System.out.println(r.getRepresentation());
					json = new JSONObject(r.getRepresentation());
					WindowPosition w = new WindowPosition();
					w.setValue(json.getString("value"));
					request.setAttribute("w", w);
					
					// GET HEATER STATE
					get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/chauffage");
					get.addHeader("accept", "application/json");
					reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					//System.out.println(r.getRepresentation());
					json = new JSONObject(r.getRepresentation());
					HeaterState h = new HeaterState();
					h.setValue(json.getString("value"));
					request.setAttribute("h", h);
					
					// GET PRESENCE
					get = new HttpGet("http://localhost:7080/RestProjectSalles/webapi/presence");
					get.addHeader("accept", "application/json");
					reqResp = client.execute(get);
					r.setStatusCode(reqResp.getStatusLine().getStatusCode());
					r.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
					//System.out.println(r.getRepresentation());
					json = new JSONObject(r.getRepresentation());
					Presence p = new Presence();
					p.setValue(json.getString("value"));
					request.setAttribute("p", p);
					
					//DISPLAY TIME
					Date date = new Date();
				    String strDateFormat = "HH:mm";
				    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
				    String fd= dateFormat.format(date);
					request.setAttribute("time", fd);

					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
