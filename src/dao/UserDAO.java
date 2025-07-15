package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO extends DAO {
//	一覧取得
	public List<User> getUserList() throws Exception {
		List<User> userList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("");

		return userList;
	}
}
