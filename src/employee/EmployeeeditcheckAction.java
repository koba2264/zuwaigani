package employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import enu.Gender;
import enu.Job;
import enu.Role;
import tool.Action;

public class EmployeeeditcheckAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String name = request.getParameter("name");
    	String namef = request.getParameter("namef");
    	String birthday = request.getParameter("birthday");
    	String gender = request.getParameter("gender");
    	String role = request.getParameter("role");
    	String job = request.getParameter("job");
    	boolean spouse = request.getParameter("spouse") == "yes" ? true: false;

    	Employee em = new Employee();
    	em.setName(name);
    	em.setNamef(namef);
    	em.setBirthDay(birthday);
    	em.setGender(Gender.valueOf(gender));
    	em.setRole(Role.valueOf(role));
    	em.setJob(Job.valueOf(job));
    	em.setSpouse(spouse);


    	return "employee_edit_check.jsp";
    }
}