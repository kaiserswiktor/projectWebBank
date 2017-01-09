package Service;

import javax.servlet.http.HttpServletRequest;

public class Command {
public String execute(HttpServletRequest request) {
		
		
		Service1 s= new Service1();
		boolean result = s.doService(request);

		if (result) {
			return "/jsp/UserName.jsp";
		} else {

		
			return "/jsp/Index.jsp";
		}
	}
}
