package message;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MessageAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String message = request.getParameter("message");


    	return "message.jsp";
    }
}