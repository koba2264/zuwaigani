package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class HweighteditAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String height = request.getParameter("height");
    	String weight = request.getParameter("weight");
    	String high = request.getParameter("high");
    	String row = request.getParameter("row");


    	return "hweight_edit.jsp";
    }
}