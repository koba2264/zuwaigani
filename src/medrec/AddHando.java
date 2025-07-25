package medrec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Employee;
import dao.MangDAO;

/**
 * Servlet implementation class AddHando
 */
@WebServlet("/AddHando")
public class AddHando extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	Employee employee = (Employee)session.getAttribute("employee");
		request.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		SendHand mang = mapper.readValue(request.getReader(), SendHand.class);
		MangDAO dao = new MangDAO();
		try {
			dao.addMang(employee.getId(),mang);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsonData = mapper.writeValueAsString(mang);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
	}

	public static class SendHand {
		public String userId;
		public String content;
	}
}
