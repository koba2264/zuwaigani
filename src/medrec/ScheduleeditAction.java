package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class ScheduleeditAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String time = request.getParameter("time");
    	String process = request.getParameter("process");


    	return "schedule_edit.jsp";
    }
}