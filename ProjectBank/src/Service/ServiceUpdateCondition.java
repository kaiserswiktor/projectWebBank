/**
 * 
 */
package Service;

import javax.servlet.http.HttpServletRequest;

import DAO.DaoUpdateCondition;

/**
 * @author User
 *
 */
public class ServiceUpdateCondition implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
      DaoUpdateCondition updateCondition =new DaoUpdateCondition();
  	int idCreditCard = (int) request.getSession(true).getAttribute("idCreditCard");
  	String condition=request.getParameter("condition");
  	updateCondition.updateCondition(idCreditCard,condition);	
		return true;
	}

}
