import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import dao.EmployeeDAO;
import tool.Action;

public class LoginAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	HttpSession session=request.getSession();

    	String userid = request.getParameter("userid");
    	String pass = request.getParameter("pass");

		EmployeeDAO dao=new EmployeeDAO();
		Employee employee=dao.Login(userid, pass);

		if (employee!=null) {
			session.setAttribute("employee", employee);
			return "menu.jsp";
		}
    	return "login.jsp";
    }
}