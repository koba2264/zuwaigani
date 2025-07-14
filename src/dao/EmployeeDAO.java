package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Employee;
import bean.Gender;

public class EmployeeDAO extends DAO {
//	ログイン用
	public Employee Login(String userId, String password) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE INNER JOIN GENDER ON EMPLOYEE.GENDER_ID = GENDER.ID WHERE EMPLOYEE.ID = ? AND PASSWORD = ?;");
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		Employee user = null;
		if (rs.next()) {
			user = new Employee();
			Gender gender = new Gender();
			user.setId(rs.getString("EMPLOYEE.ID"));
			user.setName(rs.getString("NAME"));
			user.setNamef(rs.getString("NAMEF"));
			gender.setId(rs.getString("GENDER.ID"));
			gender.setName("GENDER.NAME");
			user.setGen(gender);
			user.setGender(rs.getString("GENDER_ID"));
			user.setBirthDaySql(rs.getDate("BIRTHDAY"));
			user.setRole(rs.getString("ROLE"));
			user.setJob(rs.getString("JOB_ID"));
			user.setSpouse(rs.getBoolean("SPOUSE"));
		}

		ps.close();
		con.close();

		return user;
	}

//	新規登録用
	public boolean SignUp(Employee user, String password) throws Exception {
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?,?);");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getNamef());
		ps.setString(4, password);
		ps.setString(5, user.getGenderId());
		ps.setDate(6, user.getBirthDaySql());
		ps.setString(7, user.getJobId());
		ps.setString(8, user.getRole());
		ps.setBoolean(9, user.isSpouse());
		if (ps.executeUpdate() > 0) {
			result = true;
		}

		ps.close();
		con.close();

		return result;
  }
}

