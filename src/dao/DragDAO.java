package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Drag;
import enu.Timing;

public class DragDAO extends DAO {
	public List<Drag> getDragList(String userId, String timeZone) throws Exception{
		List<Drag> result = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps;
		switch (timeZone){
		case "MORNING":
			ps = con.prepareStatement("SELECT * FROM DRAG WHERE USER_ID = ? AND MORNING;");
			break;
		case "NOON":
			ps = con.prepareStatement("SELECT * FROM DRAG WHERE USER_ID = ? AND NOON;");
			break;
		default:
			ps = con.prepareStatement("SELECT * FROM DRAG WHERE USER_ID = ? AND NIGHT;");
			break;
		}

		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Drag drag = new Drag();
			drag.setAmount(rs.getInt("AMOUNT"));
			drag.setName(rs.getString("NAME"));
			drag.setTiming(Timing.valueOf(rs.getString("TIMING")));
			result.add(drag);
		}

		ps.close();
		con.close();
		return result;
	}
}
