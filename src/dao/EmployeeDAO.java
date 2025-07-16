package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Employee;
import enu.Gender;
import enu.Job;
import enu.Role;

public class EmployeeDAO extends DAO {
//	ログイン用
	public Employee Login(String userId, String password) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEE.ID = ? AND PASSWORD = ?;");
		ps.setString(1, userId);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		Employee user = null;
		if (rs.next()) {
			user = new Employee();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setNamef(rs.getString("NAMEF"));
			user.setGender(Gender.valueOf(rs.getString("GENDER")));
			user.setBirthDaySql(rs.getDate("BIRTHDAY"));
			user.setRole(Role.valueOf(rs.getString("ROLE")));
			user.setJob(Job.valueOf(rs.getString("JOB")));
			user.setSpouse(rs.getBoolean("SPOUSE"));
		}

		ps.close();
		con.close();

		return user;
	}

//	新規登録用
	public boolean SignUp(Employee user) throws Exception {
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?,?);");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getNamef());
		ps.setString(4, user.getId());
		ps.setString(5, user.getGender().name());
		ps.setDate(6, user.getBirthDaySql());
		ps.setString(7, user.getJob().name());
		ps.setString(8, user.getRole().name());
		ps.setBoolean(9, user.isSpouse());
		if (ps.executeUpdate() > 0) {
			result = true;
		}

		ps.close();
		con.close();

		return result;
	}

//	IDの重複チェック
	public boolean checkDuplication(Employee em) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEE.ID = ?;");
		ps.setString(1, em.getId());
		ResultSet rs = ps.executeQuery();

		boolean result = !rs.next();

		return result;
	}
}

