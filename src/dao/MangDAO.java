package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Mang;
import medrec.AddHando.SendHand;

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

	public void addMang(String id, SendHand mang) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO MANG (USER_ID, EMPLOYEE_ID, MESSAGE) VALUES (?, ?, ?);");
		ps.setString(1, mang.userId);
		ps.setString(2, id);
		ps.setString(3, mang.content);
		ps.executeUpdate();

		ps.close();
		con.close();
	}
}
