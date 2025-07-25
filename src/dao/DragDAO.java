package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Drag;
import enu.Timing;
import medrec.addDrag.SendDrag;

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
		Drag drag;
		while (rs.next()) {
			drag = new Drag();
			drag.setAmount(rs.getInt("AMOUNT"));
			drag.setName(rs.getString("NAME"));
			drag.setTiming(Timing.valueOf(rs.getString("TIMING")));
			result.add(drag);
		}

		ps.close();
		con.close();
		return result;
	}

	public void addDrag(SendDrag drag) throws Exception{
		Connection con = getConnection();
		PreparedStatement ps;
		switch (drag.time) {
		case "morning":
			System.out.println("morning");
			ps = con.prepareStatement("INSERT INTO DRAG (USER_ID, NAME, TIMING, AMOUNT, MORNING, NOON, NIGHT) VALUES (?, ?, ?, ?, TRUE, FALSE, FALSE);");
			break;
		case "noon":
			System.out.println("noon");
			ps = con.prepareStatement("INSERT INTO DRAG (USER_ID, NAME, TIMING, AMOUNT, MORNING, NOON, NIGHT) VALUES (?, ?, ?, ?, FALSE, TRUE, FALSE);");
			break;
		default:
			System.out.println("evning");
			ps = con.prepareStatement("INSERT INTO DRAG (USER_ID, NAME, TIMING, AMOUNT, MORNING, NOON, NIGHT) VALUES (?, ?, ?, ?, FALSE, FALSE, TRUE);");
			break;
		}
		ps.setString(1, drag.userId);
		ps.setString(2, drag.name);
		ps.setString(3, drag.instructions);
		ps.setInt(4, Integer.parseInt(drag.dose));

		System.out.println(ps.executeUpdate());
		ps.close();
		con.close();
	}
}
