package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MedrecdragdrinkcAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String dragname = request.getParameter("dragname");


    	return "medrec_drag_drinkc.jsp";
    }
}