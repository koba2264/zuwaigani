package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import enu.Gender;
import enu.Section;
import tool.Action;

public class UsereditcheckAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	User user = new User();
    	user.setId(request.getParameter("id"));
    	user.setName(request.getParameter("name"));
    	user.setNamef(request.getParameter("namef"));
    	user.setGender(Gender.valueOf(request.getParameter("gender")));
    	user.setBirthDay(request.getParameter("birthday"));
    	user.setNumber(request.getParameter("telnum"));
    	user.setAddress(request.getParameter("address"));
    	user.setSos1(request.getParameter("sos1"));
    	user.setSos2(request.getParameter("sos2"));
    	user.setSpouse(request.getParameter("spouse").equals("yes"));
    	user.setEnrollment(request.getParameter("enrollment").equals("ent"));
    	user.setSection(Section.valueOf(request.getParameter("section")));


    	request.setAttribute("user", user);

    	return "/WEB-INF/user/edit_check.jsp";
    }
}