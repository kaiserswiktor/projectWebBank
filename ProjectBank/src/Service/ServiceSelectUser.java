package Service;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import DAO.DaoSelectEmailPasswordImpl;
import DAO.DaoSelectScoreImpl;
import DAO.DaoSelectUserImpl;
import tableDataBaza.Score;
import tableDataBaza.User;
import taskmodule3.Md5;

/**
 * 
 * @author User class checks the user and outputting user information
 */
public class ServiceSelectUser implements Service {
	boolean admin = false;

	@Override
	public boolean doService(HttpServletRequest request) {
		String Soll = "fff";
		boolean status = false;
		String eMail = request.getParameter("eMail");
		Md5 md5 = new Md5();
		String password = md5.getHash(request.getParameter("Password") + Soll);
		DaoSelectEmailPasswordImpl checkUser = new DaoSelectEmailPasswordImpl();
		try {
			status = checkUser.selectCheckUser(eMail, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (status) {
			DaoSelectUserImpl user = new DaoSelectUserImpl();
			DaoSelectScoreImpl scoreUser = new DaoSelectScoreImpl();
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
			request.getSession(true).setAttribute("eMail", eMail);
			request.getSession(true).setAttribute("idScore", idScore);
			request.getSession(true).setAttribute("Password", password);
			request.getSession(true).setAttribute("balance", balance);
			request.getSession(true).setAttribute("condition", condition);
			if (role.equals("client")) {
				return true;
			} else if (role.equals("admin")) {
				admin = true;

			}
			return true;
		}
		return false;

	}

}
