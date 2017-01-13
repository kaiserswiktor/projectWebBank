package Service;

import javax.servlet.http.HttpServletRequest;

import DAO.DaoInsertPaymentImpl;
import DAO.DaoUpdateBalanceImpl;

/**
 * 
 * @author User
 *class adding a new payment
 */
public class ServiceInsertPayment implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		String condition = (String) request.getSession(true).getAttribute("condition");
		int balance = (int) request.getSession(true).getAttribute("balance");
		int idScore = (int) request.getSession(true).getAttribute("idScore");
		String typePayment = request.getParameter("typePaymen");
		int sumPayment = Integer.parseInt(request.getParameter("sumPayment"));
		if (condition.equals("unblocked")) {
			if (sumPayment <= balance) {
				DaoInsertPaymentImpl insertPayment = new DaoInsertPaymentImpl();
				insertPayment.insertPayment(idScore, typePayment, sumPayment);
				DaoUpdateBalanceImpl updateBalance = new DaoUpdateBalanceImpl();
				if (typePayment.equals("payment")) {
					int newBalance = balance - sumPayment;
					updateBalance.updateBalance(newBalance, idScore);
				} else if (typePayment.equals("refill")) {
					int newBalance = balance + sumPayment;
					updateBalance.updateBalance(newBalance, idScore);
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
