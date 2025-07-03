package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MedrecdrageditAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String bname = request.getParameter("bname");
    	String newname = request.getParameter("newname");
    	String btime = request.getParameter("btime");
    	String time = request.getParameter("time");
    	String btiming = request.getParameter("btiming");
    	String timing = request.getParameter("timing");
    	String busage = request.getParameter("busage");
    	String newusage = request.getParameter("newusage");


    	return "medrec_drag_edit.jsp";
    }
}