package password;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class PasswordlistAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String emplid = request.getParameter("emplid");


    	return "/WEB-INF/employee/list.jsp";
    }
}