package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MangAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String mang = request.getParameter("mang");


    	return "mang.jsp";
    }
}