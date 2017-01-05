package Servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoSelectEmail;
import DAO.DaoSelectPassword;
import DAO.DaoSelectUser;

/**
 * Servlet implementation class ServletBank
 */
@WebServlet(name="/ServletBank", urlPatterns = {"/Servlet"})
public class ServletBank extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBank() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DaoSelectPassword m=new DaoSelectPassword();
		DaoSelectEmail b= new DaoSelectEmail();
		DaoSelectUser n = new DaoSelectUser();
		m.select();
		b.select();
		n.select();
	
    String idUser="ff";
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("idUser",idUser);
	
		request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
	}

}
