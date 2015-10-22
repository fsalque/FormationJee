package org.exemple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().println("Hello servlet 1");
		response.getWriter().println("<br>");
		response.getWriter().println("<form action=\"MyServlet2\" method=\"POST\">");
		response.getWriter().println("Nom :");
		response.getWriter().println("<br>");
		response.getWriter().println("<input type='text' name='name'/>");
		response.getWriter().println("<br>");
		response.getWriter().println("Prenom :");
		response.getWriter().println("<br>");
		response.getWriter().println("<input type='text' name='surname'/>");
		response.getWriter().println("<br>");
		response.getWriter().println("<br>");
		response.getWriter().println("<input type='submit' value='Submit'>");
		response.getWriter().println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
