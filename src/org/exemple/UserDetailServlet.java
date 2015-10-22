package org.exemple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.exemple.user.entities.User;
import org.exemple.user.repositories.UsersManager;

/**
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/user/detail")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		displayView(request,response,UsersManager.getInstance().getByID(Integer.parseInt(request.getParameter("id"))));
	}

	private void displayView(HttpServletRequest request, HttpServletResponse response, User user) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>User "+ user.getName() + " " + user.getSurname() +"</h1><form action='update' method='POST'><table>");
			out.println("<tr><td> ID :</td>");
			out.println("<td><input type='text' name='id' value ='"+ user.getId() + "'></td></tr>");
			out.println("<tr><td> Nom :</td>");
			out.println("<td><input type='text' name='name' value ='"+ user.getName() + "'></td></tr>");
			out.println("<tr><td> Prenom :</td>");
			out.println("<td><input type='text' name='surname' value ='"+ user.getSurname() + "'></td></tr>");
			out.println("<tr><td> Adresse :</td>");
			out.println("<td><input type='text' name='adress' value ='"+ user.getAdress() + "'></td></tr>");
			out.println("<tr><td><input type='submit' value='Submit'></td></tr>");
		out.println("</table></br><a href='list'>Retour à la liste</a></body></html>");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
