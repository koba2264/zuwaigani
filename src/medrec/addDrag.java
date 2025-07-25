package medrec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DragDAO;
import enu.Timing;

/**
 * Servlet implementation class addDrag
 */
@WebServlet("/addDrag")
public class addDrag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		SendDrag sendDrag = mapper.readValue(request.getReader(), SendDrag.class);
		DragDAO dao = new DragDAO();
		try {
			dao.addDrag(sendDrag);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		sendDrag.instructions = Timing.valueOf(sendDrag.instructions).getName();
		String jsonData = mapper.writeValueAsString(sendDrag);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
	}

	public static class SendDrag {
		public String userId;
		public String instructions;
		public String dose;
		public String name;
		public String time;
	}

}
