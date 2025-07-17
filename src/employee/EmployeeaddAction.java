package employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class EmployeeaddAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	return "/WEB-INF/employee/add.jsp";
    }
}