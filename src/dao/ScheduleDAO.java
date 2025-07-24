package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bean.Schedule;

public class ScheduleDAO extends DAO {
	public List<Schedule> getMangList(String userId) throws Exception{
		List<Schedule> result = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM SCHEDULE WHERE USER_ID = ? ORDER BY START_TIME;");
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Schedule schedule = new Schedule();
			schedule.setProcess(rs.getString("PROCESS"));
			schedule.setStartTime(rs.getObject("START_TIME", LocalTime.class));
			result.add(schedule);
		}

		ps.close();
		con.close();
		return result;
	}
}
