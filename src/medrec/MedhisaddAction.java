package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MedhisaddAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String sickname = request.getParameter("sickname");
    	String age = request.getParameter("age");
    	String state = request.getParameter("state");


    	return "medhis_add.jsp";
    }
}