
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class LoginAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String userid = request.getParameter("userid");
    	String pass = request.getParameter("pass");


    	return "login.jsp";
    }
}