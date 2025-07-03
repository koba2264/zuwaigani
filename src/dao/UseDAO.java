package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;

public class UseDAO extends DAO {
//	ログイン用
	public User Login(String userId, String password) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE ID = ? AND PASSWORD = ?;");
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		User user = null;
		if (rs.next()) {
			user = new User();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setNamef(rs.getString("NAMEF"));
			user.setGender(rs.getString("GENDER_ID"));
			user.setBirthDaySql(rs.getDate("BIRTHDAY"));
			user.setAge(rs.getInt("AGE"));
			user.setNumber(rs.getString("NUMBER"));
			user.setBlood(rs.getString("BLOOD"));
			user.setPhoto(rs.getString("PHOTO"));
			user.setAddress(rs.getString("ADDRESS"));
			user.setRole(rs.getString("ROLE"));
			user.setSos1(rs.getString("SOS1"));
			user.setSos2(rs.getString("SOS2"));
			user.setSpouse(rs.getBoolean("SPOUSE"));
			user.setMeans(rs.getString("MEANS"));
		}

		return user;
	}
}
