/**
 * 
 */
package Service;

import javax.servlet.http.HttpServletRequest;

import DAO.DaoUpdateConditionImpl;

/**
 * @author User class update condition Score
 */
public class ServiceUpdateCondition implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		DaoUpdateConditionImpl updateCondition = new DaoUpdateConditionImpl();
		int idCreditCard = (int) request.getSession(true).getAttribute("idCreditCard");
		String condition = request.getParameter("condition");
		updateCondition.updateCondition(idCreditCard, condition);
		return true;
	}

}
