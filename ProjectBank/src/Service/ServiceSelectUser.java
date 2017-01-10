package Service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DaoSelectEmailPassword;
import DAO.DaoSelectScore;
import DAO.DaoSelectUser;
import tableDataBaza.Score;
import tableDataBaza.User;

public class ServiceSelectUser implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		boolean status = false;
		String eMail = request.getParameter("eMail");
		String password = request.getParameter("Password");
		DaoSelectEmailPassword checkUser = new DaoSelectEmailPassword();
		try {
			status = checkUser.selectCheckUser(eMail, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (status) {
			HttpSession session=request.getSession();
			DaoSelectUser user = new DaoSelectUser();
			DaoSelectScore scoreUser = new DaoSelectScore();
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
			session.setAttribute(eMail, "eMail");
			session.setAttribute(password, "Password");
			return true;
		}
		return false;

	}

}
