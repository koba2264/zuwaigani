package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class UsereditAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String id = request.getParameter("id");
    	UserDAO dao = new UserDAO();
    	User user = dao.getUser(id);
    	if (user == null) {
    		return "Userlist.action";
    	}
    	request.setAttribute("user", user);

    	String name = request.getParameter("name");
    	String namef = request.getParameter("namef");
    	String gender = request.getParameter("gender");
    	String birthday = request.getParameter("birthday");
    	String age = request.getParameter("age");
    	String roomnum = request.getParameter("roomnum");
    	String telnum = request.getParameter("telnum");
    	String address = request.getParameter("address");
    	String sos1 = request.getParameter("sos1");
    	String sos2 = request.getParameter("sos2");
    	boolean spouse = request.getParameter("spouse") == "yes" ? true: false;
    	String enrollment = request.getParameter("enrollment");
    	String section = request.getParameter("section");

    	return "/WEB-INF/user/edit.jsp";

    }
}