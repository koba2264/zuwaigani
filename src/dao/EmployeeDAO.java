package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Employee;

public class EmployeeDAO extends DAO {
//	ログイン用
	public Employee Login(String userId, String password) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ? AND PASSWORD = ?;");
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		Employee user = null;
		if (rs.next()) {
			user = new Employee();
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

		ps.close();
		con.close();

		return user;
	}

//	新規登録用
	public boolean SignUp(Employee user, String password) throws Exception {
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getNamef());
		ps.setString(4, password);
		ps.setString(5, user.getGenderId());
		ps.setDate(6, user.getBirthDaySql());
		ps.setInt(7, user.getAge());
		ps.setString(8, user.getNumber());
		ps.setString(9, user.getBlood());
		ps.setString(10, user.getPhoto());
		ps.setString(11, user.getAddress());
		ps.setString(12, user.getRole());
		ps.setString(13, user.getSos1());
		ps.setString(14, user.getSos2());
		ps.setBoolean(15, user.isSpouse());
		ps.setString(16, user.getMeansId());
		if (ps.executeUpdate() > 0) {
			result = true;
		}

		ps.close();
		con.close();

		return result;
	}
}
