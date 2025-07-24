package message;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.MessageDAO;
import json.Message;

/**
 * Servlet implementation class SendChat
 */
@WebServlet("/SendChat")
public class SendChat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		SendMessage sendMessage = mapper.readValue(request.getReader(), SendMessage.class);
		MessageDAO dao = new MessageDAO();
		LocalDateTime now = LocalDateTime.now();
		try {
			dao.sendMessage(sendMessage.sendId, sendMessage.receiveId, sendMessage.text, now);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Message message = new Message();
		message.setId(sendMessage.sendId);
		message.setText(sendMessage.text);
		message.setTime(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		String jsonData = mapper.writeValueAsString(message);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
	}

	public static class SendMessage {
		public String sendId;
		public String receiveId;
		public String text;
	}

}
