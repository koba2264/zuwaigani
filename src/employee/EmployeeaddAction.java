package employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class EmployeeaddAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String name = request.getParameter("name");
    	String namef = request.getParameter("namef");
    	String birthday = request.getParameter("birthday");
    	String gender = request.getParameter("gender");
    	String section = request.getParameter("section");
    	String job = request.getParameter("job");


    	return "employee_add.jsp";
    }
}