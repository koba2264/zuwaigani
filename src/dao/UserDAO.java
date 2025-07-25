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
//	IDの重複チェック
		public boolean checkDuplication(User user) throws Exception {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE USER.ID = ?;");
			ps.setString(1, user.getId());
			ResultSet rs = ps.executeQuery();

			boolean result = !rs.next();

			return result;
		}

//	メッセージ用一覧取得
	public List<User> getUserList() throws Exception {
		List<User> userList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USER ORDER BY ID;");
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
			user.setAddress(rs.getString("ADDRESS"));
			user.setEnrollment(rs.getBoolean("ENROLLMENT"));
			user.setSection(Section.valueOf(rs.getString("SECTION")));
			user.setDay(rs.getObject("DAY", LocalDate.class));
			user.setBlood(rs.getString("BLOOD"));
			userList.add(user);
		}

		ps.close();
		con.close();

		return userList;
	}

//	idで1件取得
	public User getUser(String id) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE ID = ?;");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		User user = null;
		if (rs.next()) {
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
			user.setAddress(rs.getString("ADDRESS"));
			user.setEnrollment(rs.getBoolean("ENROLLMENT"));
			user.setSection(Section.valueOf(rs.getString("SECTION")));
			user.setDay(rs.getObject("DAY", LocalDate.class));
			user.setBlood(rs.getString("BLOOD"));
		}

		ps.close();
		con.close();

		return user;
	}

//	更新
	public boolean updateUser(User user) throws Exception {
		boolean result = false;

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE USER  SET NUMBER=?, ADDRESS=?, SOS1=?, SOS2=?, SPOUSE=?,ENROLLMENT=?, SECTION=? WHERE ID = ?;");
		ps.setString(1, user.getNumber());
		ps.setString(2, user.getAddress());
		ps.setString(3, user.getSos1());
		ps.setString(4, user.getSos2());
		ps.setBoolean(5, user.isSpouse());
		ps.setBoolean(6, user.isEnrollment());
		ps.setString(7, user.getSection().name());
		ps.setString(8, user.getId());

		if (ps.executeUpdate() > 0) {
			result = true;
		}

		ps.close();
		con.close();

		return result;
	}
}
