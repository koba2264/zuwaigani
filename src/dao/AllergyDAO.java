package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Allergy;

public class AllergyDAO extends DAO {
	public List<Allergy> getAllergyList(String userId) throws Exception{
		List<Allergy> allergys = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT ALLERGY.ID AS ID, ALLERGY.NAME AS NAME FROM ALLERGY_USER INNER JOIN ALLERGY ON ALLERGY.ID  = ALLERGY_USER.ALLERGY_ID WHERE ALLERGY_USER.USER_ID = ?;");
		ps.setString(1, userId);

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Allergy allergy = new Allergy();
			allergy.setId(rs.getString("ID"));
			allergy.setName(rs.getString("NAME"));
			allergys.add(allergy);
		}

		ps.close();
		con.close();

		return allergys;
	}
}
