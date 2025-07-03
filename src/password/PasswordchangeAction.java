package password;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class PasswordchangeAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String emplid = request.getParameter("emplid");
    	String newpass = request.getParameter("newpass");


    	return "password_change.jsp";
    }
}