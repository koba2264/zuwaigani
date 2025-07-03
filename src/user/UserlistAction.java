package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class UserlistAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String userid = request.getParameter("userid");


    	return "user_list.jsp";
    }
}