/**
 * 
 */
package Service;

import javax.servlet.http.HttpServletRequest;
import DAO.DaoSelectScoreImpl;
import tableDataBaza.Score;

/**
 * @author User
 *class look score 
 */
public class ServiceSelectScore implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		DaoSelectScoreImpl scoreUser = new DaoSelectScoreImpl();
		int idCreditCard = Integer.parseInt(request.getParameter("idCard"));
		Score Score = scoreUser.selectDaoScore(idCreditCard);
		int idCard = Score.getIdCard();
		int idScore = Score.getIdScore();
		int balance = Score.getBalance();
		String condition = Score.getConditionScore();
		request.setAttribute("idCard", idCard);
		request.setAttribute("idScore", idScore);
		request.setAttribute("balance", balance);
		request.setAttribute("condition", condition);
		request.getSession(true).setAttribute("idCreditCard", idCreditCard);
		return true;
	}

}
