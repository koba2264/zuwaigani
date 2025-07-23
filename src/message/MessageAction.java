package message;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import bean.Message;
import dao.MessageDAO;
import tool.Action;

public class MessageAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	Employee employee = (Employee)session.getAttribute("employee");
    	String id = request.getParameter("id");
    	String name = request.getParameter("name");
    	MessageDAO dao = new MessageDAO();
    	List<Message> messages = dao.getMessageList(employee.getId(), id);
    	request.setAttribute("name", name);
    	request.setAttribute("messages", messages);
    	request.setAttribute("sendId", id);
    	request.setAttribute("myId", employee.getId());

//    	既読にする
    	dao.messageLooked(id, employee.getId());

    	return "/WEB-INF/message/index.jsp";
    }
}