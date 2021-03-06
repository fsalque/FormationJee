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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = (request.getParameter("name"));
		String surname = (request.getParameter("surname"));
		String adress = (request.getParameter("adress"));
		
		User user = new User();
		user.setAdress(adress);
		user.setId(id);
		user.setName(name);
		user.setSurname(surname);
		
		UsersManager.getInstance().update(user);
		
		displayView(request, response, user);
	}

	private void displayView(HttpServletRequest request, HttpServletResponse response, User user) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>User "+ user.getName() + " " + user.getSurname() +" updated</h1></br><a href='list'>Retour � la liste</a></body></html>");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
