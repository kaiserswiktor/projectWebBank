package Service;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import DAO.DaoSelectEmailPassword;
import DAO.DaoSelectScore;
import DAO.DaoSelectUser;
import tableDataBaza.Score;
import tableDataBaza.User;
import taskmodule3.Md5;

public class ServiceSelectUser implements Service {
     boolean admin=false;
	@Override
	public boolean doService(HttpServletRequest request) {
		ResourceBundle resource = ResourceBundle.getBundle("recourse.PrepareStatement");
		String Soll = resource.getString("soll");
		boolean status = false;
		String eMail = request.getParameter("eMail");
		Md5 md5=new Md5();
		String password=md5.getHash(request.getParameter("Password")+Soll);
		DaoSelectEmailPassword checkUser = new DaoSelectEmailPassword();
		try {
			status = checkUser.selectCheckUser(eMail, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (status) {
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
			request.getSession(true).setAttribute( "eMail",eMail);
			request.getSession(true).setAttribute( "idScore",idScore);
			request.getSession(true).setAttribute( "Password",password);
			request.getSession(true).setAttribute( "balance",balance);
			request.getSession(true).setAttribute( "condition",condition);
			if(role.equals("client")){
			return true;
			}
			else if(role.equals("admin")){
				admin=true;	
				
			}
			return true;
		}
		return false;

	}

}
