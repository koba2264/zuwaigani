package employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import tool.Action;

public class EmployeelistAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String id = request.getParameter("id");

    	Employee em = new Employee();
    	em.setId(id);


    	return "employee_list.jsp";
    }
}