package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class UseraddcompAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


    	return "/WEB-INF/user/add_comp.jsp";
    }
}