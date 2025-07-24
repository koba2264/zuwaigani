package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import enu.Gender;
import enu.Section;
import tool.Action;

public class UseraddcheckAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String namef = request.getParameter("namef");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String sos1 = request.getParameter("sos1");
        String sos2 = request.getParameter("sos2");
        boolean spouse = request.getParameter("spouse") == "yes" ? true: false;
        String section = request.getParameter("section");

        User us = new User();
        us.setName(name);
        us.setNamef(namef);
        us.setGender(Gender.valueOf(gender));
        us.setBirthDay(birthday);
        us.setNumber(number);
        us.setAddress(address);
        us.setSos1(sos1);
        us.setSos2(sos2);
        us.setSpouse(spouse);
        us.setSection(Section.valueOf(section));

        UserDAO dao = new UserDAO();
        if(dao.updateUser(us)) {
        	request.setAttribute("user", us);
        	return "/WEB-INF/user/add_check.jsp";
        }
        return "/WEB-INF/employee/duplication_error.jsp";
    }
}