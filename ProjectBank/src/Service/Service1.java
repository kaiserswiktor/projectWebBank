package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DaoSelectScore;
import DAO.DaoSelectUser;
import tableDataBaza.Score;
import tableDataBaza.User;

public class Service1 implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {

		
		String eMail =request.getParameter("eMail");
		String password =request.getParameter("Password");
		DaoSelectUser user = new DaoSelectUser();
		DaoSelectScore scoreUser = new DaoSelectScore();		
			User User = user.selectDaoUser(eMail,password);					
				String firstName = User.getFirstName();
				String lastName = User.getLastName();
				String role = User.getRole();
				int idCard = User.getIdCreditCard();
				Score Score = scoreUser.selectDaoScore(idCard);
				int idScore = Score.getIdScore();
				int balance = Score.getBalance();
				String condition = Score.getConditionScore();
				request.setAttribute("idCard", idCard);
				request.setAttribute("idScore", idScore);
				request.setAttribute("balance", balance);
				request.setAttribute("role", role);
				request.setAttribute("condition", condition);
				request.setAttribute("Name", firstName + " " + lastName);
				request.setAttribute("idCard", idCard);
				return true;
			
		
		//return false;
	
	}
	
}
