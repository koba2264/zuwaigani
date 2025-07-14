package message;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MessagelistAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String emplid = request.getParameter("emplid");


    	return "message_list.jsp";
    }
}