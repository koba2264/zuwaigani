package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Medhis;
import enu.State;

public class MedhisDAO extends DAO {
	public List<Medhis> getMangList(String userId) throws Exception{
		List<Medhis> result = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM MEDHIS WHERE USER_ID = ?;");
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Medhis medhis = new Medhis();
			medhis.setAge(rs.getInt("AGE"));
			medhis.setName(rs.getString("NAME"));
			medhis.setState(State.valueOf(rs.getString("STATE")));
			result.add(medhis);
		}

		ps.close();
		con.close();
		return result;
	}
}
