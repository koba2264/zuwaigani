package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class UseraddcheckAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
    	String spouse = request.getParameter("spouse");
    	String section = request.getParameter("section");


    	return "/WEB-INF/user/add_check.jsp";
    }
}