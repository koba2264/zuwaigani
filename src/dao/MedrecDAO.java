package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.Allergy;
import bean.Careful;
import bean.Drag;
import bean.Mang;
import bean.Medhis;
import bean.Medrec;
import bean.Schedule;
import bean.User;

public class MedrecDAO extends DAO {
	public Medrec getMedrec(String userId) throws Exception {
		Medrec medrec = new Medrec();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM MEDREC INNER JOIN CAREFUL ON MEDREC.USER_ID = CAREFUL.USER_ID WHERE MEDREC.USER_ID = ?;");
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			UserDAO udao = new UserDAO();
			User user = udao.getUser(userId);
			medrec.setUser(user);
			medrec.setRoomNum(rs.getString("MEDREC.ROOMNUM"));
			medrec.setLevel(rs.getString("MEDREC.LEVEL"));
			medrec.setHeight(rs.getFloat("HEIGHT"));
			medrec.setWeight(rs.getFloat("WEIGHT"));
			medrec.setBloodPres(rs.getString("BLOOD_PRES"));
			AllergyDAO adao = new AllergyDAO();
			List<Allergy> allergys = adao.getAllergyList(userId);
			medrec.setAllergyList(allergys);
			Careful careful = new Careful();
			careful.setBath(rs.getBoolean("CAREFUL.BATH"));
			careful.setDrag(rs.getBoolean("CAREFUL.DRAG"));
			careful.setEat(rs.getBoolean("CAREFUL.EAT"));
			careful.setSleep(rs.getBoolean("CAREFUL.SLEEP"));
			careful.setToilet(rs.getBoolean("CAREFUL.TOILET"));
			careful.setWalk(rs.getBoolean("CAREFUL.WALK"));
			careful.setWcar(rs.getBoolean("CAREFUL.WCAR"));
			medrec.setCareful(careful);
			MangDAO mdao = new MangDAO();
			List<Mang> mangs = mdao.getMangList(userId);
			medrec.setMangList(mangs);
			MedhisDAO medao = new MedhisDAO();
			List<Medhis> medhisList = medao.getMangList(userId);
			medrec.setMedhisList(medhisList);
			ScheduleDAO sdao = new ScheduleDAO();
			List<Schedule> schedules = sdao.getMangList(userId);
			medrec.setSchedules(schedules);
			DragDAO ddao = new DragDAO();
			List<Drag> morningDrag = ddao.getDragList(userId, "MORNING");
			medrec.setMorningDrag(morningDrag);
			List<Drag> noonDrag = ddao.getDragList(userId, "NOON");
			medrec.setMorningDrag(noonDrag);
			List<Drag> nightDrag = ddao.getDragList(userId, "NIGHT");
			medrec.setMorningDrag(nightDrag);
		}
		ps.close();
		con.close();

		return medrec;
	}
}
