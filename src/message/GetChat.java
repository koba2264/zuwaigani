package message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.MessageDAO;
import json.ChatUser;
import json.Message;
import json.SelectUser;

/**
 * Servlet implementation class GetChat
 */
@WebServlet("/GetChat")
public class GetChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		SelectUser userJson = mapper.readValue(request.getReader(), SelectUser.class);
//
		String myId = userJson.myId;
		String sendId = userJson.sendId;
		String name = userJson.name;
		MessageDAO dao = new MessageDAO();
		ChatUser user = new ChatUser();
		user.setId(sendId);
		user.setName(name);
		mapper = new ObjectMapper();
		String jsonData = "";
		List<Message> messages = new ArrayList<>();
		try {
			List<bean.Message> meLis=dao.getMessageList(myId, sendId).stream().sorted().collect(Collectors.toList());
			meLis.forEach(value -> {
				Message message = new Message();
				message.setId(value.getSendId());
				message.setText(value.getText());
				message.setTime(value.getStrSendingTime());
				messages.add(message);
			});
			user.setMessages(messages);
			jsonData = mapper.writeValueAsString(user);
			dao.messageLooked(sendId, myId);
		} catch (Exception e) {
			e.printStackTrace();
		}
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonData);
	}
}
