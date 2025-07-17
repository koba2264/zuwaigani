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

    	return "/WEB-INF/user/edit.jsp";
    }
}