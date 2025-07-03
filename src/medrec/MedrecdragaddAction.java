package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MedrecdragaddAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String dragname = request.getParameter("dragname");
    	String timing = request.getParameter("timing");
    	String dragusage = request.getParameter("dragusage");


    	return "medrec_drag_add.jsp";
    }
}