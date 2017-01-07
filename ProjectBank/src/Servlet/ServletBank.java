package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DaoInsertPayment;
import DAO.DaoSelectEmailPassword;
import DAO.DaoSelectScore;
import DAO.DaoSelectUser;
import tableDataBaza.Score;
import tableDataBaza.User;

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
	
		
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		request.setCharacterEncoding("UTF-8");
		DaoSelectUser user= new DaoSelectUser();
		DaoSelectScore scoreUser= new DaoSelectScore();
	
		User User=user.selectDaoUser("nikita@gmail.com", "nikita");
		String firstName=User.getFirstName();
		String lastName=User.getLastName();
		String role =User.getRole();
		int idCard=User.getIdCreditCard();
		Score Score=scoreUser.selectDaoScore(idCard);
		int idScore=Score.getIdScore();
		int balance=Score.getBalance();
		String condition=Score.getConditionScore();
		request.setAttribute("idCard", idCard);
		request.setAttribute("idScore", idScore);
		request.setAttribute("balance", balance);
		request.setAttribute("role", role);
		request.setAttribute("condition", condition);
		request.setAttribute("Name", firstName+" "+lastName);
		request.setAttribute("idCard", idCard);
		request.getRequestDispatcher("/jsp/UserName.jsp").forward(request, response);
		
		//request.getRequestDispatcher("/jsp/Payment.jsp").forward(request, response);
	
		//int idCard=101;
		
		//request.getRequestDispatcher("/jsp/UserScore.jsp").forward(request, response);
	}

}
