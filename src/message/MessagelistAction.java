package message;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import dao.EmployeeDAO;
import tool.Action;

public class MessagelistAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	Employee employee = (Employee)session.getAttribute("employee");
    	EmployeeDAO dao = new EmployeeDAO();
    	List<Employee> employeeList = dao.getEmployeeList(employee.getId());

    	request.setAttribute("employeeList", employeeList);
    	request.setAttribute("id", employee.getId());


    	return "/WEB-INF/message/personalChat.jsp";
    }
}