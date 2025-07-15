package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import enu.Gender;
import enu.Section;

public class UserDAO extends DAO {
//	一覧取得
	public List<User> getUserList() throws Exception {
		List<User> userList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USER;");
		ResultSet rs = ps.executeQuery();

		User user;
		while (rs.next()) {
			user = new User();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setNamef(rs.getString("NAMEF"));
			user.setGender(Gender.valueOf(rs.getString("GENDER")));
			user.setNumber(rs.getString("NUMBER"));
			user.setBirthDay(rs.getObject("BIRTHDAY", LocalDate.class));
			user.setSos1(rs.getString("SOS1"));
			user.setSos2(rs.getString("SOS2") == null ? "" : rs.getString("SOS2"));
			user.setSpouse(rs.getBoolean("SPOUSE"));
			user.setEnrollment(rs.getBoolean("ENROLLMENT"));
			user.setSection(Section.valueOf(rs.getString("SECTION")));
			user.setDay(rs.getObject("DAY", LocalDate.class));
			user.setBloodType(rs.getString("BLOOD"));
			userList.add(user);
		}

		ps.close();
		con.close();

		return userList;
	}
}
