package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bean.Schedule;
import medrec.AddSchedule.sendSchedule;

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

	public void addSchedule(sendSchedule schedule) throws Exception{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO SCHEDULE (USER_ID, START_TIME, PROCESS) VALUES (?, ?, ?);");
		ps.setString(1, schedule.userId);
		ps.setTime(2, java.sql.Time.valueOf(LocalTime.parse(schedule.time)));
		ps.setString(3, schedule.content);

		ps.executeUpdate();

		ps.close();
		con.close();
	}
}
