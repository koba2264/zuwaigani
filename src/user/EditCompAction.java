package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import enu.Section;
import tool.Action;

public class EditCompAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	User user = new User();
    	user.setId(request.getParameter("id"));
    	user.setNumber(request.getParameter("telnum"));
    	user.setAddress(request.getParameter("address"));
    	user.setSos1(request.getParameter("sos1"));
    	user.setSos2(request.getParameter("sos2"));
    	user.setSpouse(request.getParameter("spouse").equals("true"));
    	user.setEnrollment(request.getParameter("enrollment").equals("true"));
    	user.setSection(Section.valueOf(request.getParameter("section")));

    	UserDAO dao = new UserDAO();
    	dao.updateUser(user);

		return "/WEB-INF/user/edit_comp.jsp";
	}

}
