package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class CarefuleditAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String careful = request.getParameter("careful");


    	return "careful_edit.jsp";
    }
}