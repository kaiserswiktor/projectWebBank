package Service;

import javax.servlet.http.HttpServletRequest;

import DAO.DaoInsertPayment;
import DAO.DaoUpdateBalance;

public class ServiceInsertPayment implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		int balance = (int) request.getSession(true).getAttribute("balance");
		int idScore = (int) request.getSession(true).getAttribute("idScore");
		String typePayment = request.getParameter("typePaymen");
		int sumPayment = Integer.parseInt(request.getParameter("sumPayment"));
		if (sumPayment <= balance) {
			DaoInsertPayment insertPayment = new DaoInsertPayment();
			insertPayment.insertPayment(idScore, typePayment, sumPayment);
			DaoUpdateBalance updateBalance = new DaoUpdateBalance();
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

	}

}
