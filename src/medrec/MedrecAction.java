package medrec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Medrec;
import dao.MedrecDAO;
import tool.Action;

public class MedrecAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String id = request.getParameter("id");
    	MedrecDAO dao = new MedrecDAO();
    	Medrec medrec = dao.getMedrec(id);
    	System.out.println(medrec.getMorningDrag().size());
    	request.setAttribute("medrec", medrec);

    	return "/WEB-INF/medrec/index.jsp";
    }
}