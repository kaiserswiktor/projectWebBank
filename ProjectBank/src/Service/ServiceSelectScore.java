/**
 * 
 */
package Service;

import javax.servlet.http.HttpServletRequest;
import DAO.DaoSelectScore;
import tableDataBaza.Score;

/**
 * @author User
 *
 */
public class ServiceSelectScore implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
	DaoSelectScore scoreUser=new DaoSelectScore();
	int idCreditCard =Integer.parseInt(request.getParameter("idCard")) ;
	
	Score Score = scoreUser.selectDaoScore(idCreditCard);
	int idCard = Score.getIdCard();
	int idScore = Score.getIdScore();
	int balance = Score.getBalance();
	String condition = Score.getConditionScore();
	request.setAttribute("idCard", idCard);
	request.setAttribute("idScore", idScore);
	request.setAttribute("balance", balance);
	request.setAttribute("condition", condition);
	request.getSession(true).setAttribute( "idCreditCard",idCreditCard);
		return true;
	}

}
