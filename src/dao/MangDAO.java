package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Mang;

public class MangDAO extends DAO {
	public List<Mang> getMangList(String userId) throws Exception{
		List<Mang> mangs = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT EMPLOYEE.NAME AS NAME, MANG.MESSAGE AS MESSAGE FROM MANG INNER JOIN EMPLOYEE ON MANG.EMPLOYEE_ID = EMPLOYEE.ID WHERE MANG.USER_ID = ?;");
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Mang mang = new Mang();
			mang.setMessage(rs.getString("MESSAGE"));
			mang.setEmployee(rs.getString("NAME"));
			mangs.add(mang);
		}

		ps.close();
		con.close();
		return mangs;
	}
}
