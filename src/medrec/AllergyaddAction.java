package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class AllergyaddAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String allergy = request.getParameter("allergy");


    	return "allergy_add.jsp";
    }
}