package user;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import tool.Action;

public class UseraddcheckAction extends Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");
        String namef = request.getParameter("namef");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String roomnum = request.getParameter("roomnum");
        String age = request.getParameter("age");
        String telnum = request.getParameter("telnum");
        String address = request.getParameter("address");
        String sos1 = request.getParameter("sos1");
        String sos2 = request.getParameter("sos2");
        boolean spouse = request.getParameter("spouse") == "yes" ? true: false;
        String section = request.getParameter("section");

        User us = new User();

        us.setName(name);
        us.setNamef(namef);
        us.setGender(gender);
        us.setBirthday(birthday);
        us.setAge(age);
        us.setRoomnum(roomnum);
        us.setTelnum(telnum);
        us.setAddress(address);
        us.setSos1(sos1);
        us.setSos2(sos2);
        us.setSpouse(spouse);
        us.setSection(section);

        request.setAttribute("user", us);

        return "/WEB-INF/user/add_check.jsp";
    }
}