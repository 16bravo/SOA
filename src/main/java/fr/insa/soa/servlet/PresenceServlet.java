package fr.insa.soa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.insat.om2m.tp2.client.Client;

/**
 * Servlet implementation class PresenceServlet
 */
public class PresenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("MainServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("presence");
		if (p.equals("true")) {
			p = "false";
		} else {
			p = "true";
		}
		;
		System.out.println(p);

		Client client = new Client();
		String url = "http://localhost:8080/~/mn-cse/mn-name/PRESENCE/DATA"; // DATA_container_for_presence
		String type = "4"; // cin
		String representation = "<m2m:cin xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">"
				+ "<cnf>application/xml</cnf>" + "<con>" + p + "</con>" + "</m2m:cin>";
		System.out.println(client.create(url, representation, "admin:admin", type));

		request.getRequestDispatcher("MainServlet").forward(request, response);
	}

}
