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

    	String id = request.getParameter("id");
        String name = request.getParameter("name");
        String namef = request.getParameter("namef");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String sos1 = request.getParameter("sos1");
        String sos2 = request.getParameter("sos2");
        boolean spouse = "yes".equals(request.getParameter("spouse"));
        String section = request.getParameter("section");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setNamef(namef);
        user.setGender(Gender.valueOf(gender));
        user.setBirthDay(birthday);
        user.setNumber(number);
        user.setAddress(address);
        user.setSos1(sos1);
        user.setSos2(sos2);
        user.setSpouse(spouse);
        user.setSection(Section.valueOf(section));

        UserDAO dao = new UserDAO();
        if(dao.updateUser(user)) {
        	request.setAttribute("user", user);
        	return "/WEB-INF/user/add_check.jsp";
        }
        return "/WEB-INF/user/duplication_error.jsp";
    }
}