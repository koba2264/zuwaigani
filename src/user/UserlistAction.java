package user;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class UserlistAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	UserDAO dao = new UserDAO();
    	List<User> users = dao.getUserList();

    	request.setAttribute("users", users);

    	return "/WEB-INF/user/list.jsp";
    }
}