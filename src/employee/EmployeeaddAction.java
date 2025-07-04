package employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import tool.Action;

public class EmployeeaddAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String name = request.getParameter("name");
    	String namef = request.getParameter("namef");
    	String birthday = request.getParameter("birthday");
    	String gender = request.getParameter("gender");
    	String role = request.getParameter("role");
    	String job = request.getParameter("job");

    	Employee em = new Employee();
    	em.setName(name);
    	em.setNamef(namef);
    	em.setBirthDay(birthday);
    	em.setGender(gender);
    	em.setRole(role);
    	em.setJob(job);

    	request.setAttribute("em", em);


    	return "employee_add.jsp";
    }
}