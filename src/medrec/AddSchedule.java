package medrec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.ScheduleDAO;

/**
 * Servlet implementation class AddSchedule
 */
@WebServlet("/addSchedule")
public class AddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		sendSchedule schedule = mapper.readValue(request.getReader(), sendSchedule.class);
		ScheduleDAO dao = new ScheduleDAO();
		try {
			dao.addSchedule(schedule);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsonData = mapper.writeValueAsString(schedule);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
	}

	public static class sendSchedule {
		public String userId;
		public String time;
		public String content;
	}
}
