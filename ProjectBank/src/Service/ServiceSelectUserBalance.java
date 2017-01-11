package Service;

import javax.servlet.http.HttpServletRequest;

import DAO.DaoSelectScore;
import DAO.DaoSelectUser;
import tableDataBaza.Score;
import tableDataBaza.User;

public class ServiceSelectUserBalance implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		
		DaoSelectUser user = new DaoSelectUser();
		DaoSelectScore scoreUser = new DaoSelectScore();
		String eMail=(String) request.getSession(true).getAttribute("eMail");
		String password=(String) request.getSession(true).getAttribute("Password");
		User User = user.selectDaoUser(eMail, password);
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
		request.getSession(true).setAttribute( "balance",balance);

		return true;

	}

}
