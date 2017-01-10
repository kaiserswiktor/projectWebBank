package Service;

import javax.servlet.http.HttpServletRequest;

public class Command {

public String execute(HttpServletRequest request) {
	boolean result;
	String name ;
	name=request.getParameter("command");
	switch (name) {	
	case("eMail"):
		ServiceSelectUser s= new ServiceSelectUser();
		 result = s.doService(request);
		if (result) {
			return "/UserName.jsp";
		} else {	
			return "/Index.jsp";
		}
	case("Pay"):
		if (true) {
			return "/Payment.jsp";}
	case ("Balance"):
		ServiceSelectUserBalance b=new ServiceSelectUserBalance();
	result=b.doService(request);
	if (result) {
		return "/UserName.jsp";
	} else {	
		return "/Index.jsp";}
	
	case("Payment"):
		ServiceInsertPayment c=new ServiceInsertPayment();
		 result=c.doService(request);
		if (result) {
			return "/Pay.jsp";
		} else {

		
			return "/Index.jsp";
		}
	}
	return null;
	}
}
