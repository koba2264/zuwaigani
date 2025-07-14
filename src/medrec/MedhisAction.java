package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MedhisAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String sickname = request.getParameter("sickname");
    	String state = request.getParameter("state");


    	return "medhis.jsp";
    }
}