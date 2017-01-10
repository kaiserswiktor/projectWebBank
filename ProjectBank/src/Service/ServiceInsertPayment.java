package Service;

import javax.servlet.http.HttpServletRequest;

import DAO.DaoInsertPayment;

public class ServiceInsertPayment implements Service {

	@Override
	public boolean doService(HttpServletRequest request) {
		
		int idScore =100101;
	 //   String typePayment="payment";
	  //  int sumPayment=1000;
				
		//int idScore =Integer.parseInt(request.getParameter("idScore"));
		String typePayment=request.getParameter("typePaymen");
		int sumPayment=Integer.parseInt(request.getParameter("sumPayment"));
		DaoInsertPayment insertPayment= new DaoInsertPayment(); 
		insertPayment.insertPayment(idScore, typePayment, sumPayment);
		return true;
	}

}
