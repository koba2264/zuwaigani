package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bean.Message;

public class MessageDAO extends DAO {
//	メッセージの一覧
	public List<Message> getMessageList(String sendId, String receiveId) throws Exception{

		List<Message> messageList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM MESSAGE WHERE (SEND_ID = ? AND RECEIVE_ID = ?) OR (SEND_ID = ? AND RECEIVE_ID = ?) ORDER BY SENDING_TIME;");
		ps.setString(1, sendId);
		ps.setString(2, receiveId);
		ps.setString(3, receiveId);
		ps.setString(4, sendId);
		ResultSet rs = ps.executeQuery();

		Message message;
		while (rs.next()) {
			message = new Message();
			message.setSendId(rs.getString("SEND_ID"));
			message.setText(rs.getString("TEXT"));
			message.setSendingTime(rs.getObject("SENDING_TIME", LocalDateTime.class));
			message.setLooked(rs.getBoolean("LOOKED"));
			if (message.getSendId().equals(sendId)) {
				message.setMine(true);
			} else {
				message.setMine(false);
			}
			messageList.add(message);
		}

		ps.close();
		con.close();

		return messageList;
	}

//	既読
	public void messageLooked(String sendId, String receiveId) throws Exception{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE MESSAGE SET LOOKED = TRUE WHERE SEND_ID = ? AND RECEIVE_ID = ?;");
		ps.setString(1, sendId);
		ps.setString(2, receiveId);
		ps.executeUpdate();

		ps.close();
		con.close();
	}

//	送信
	public void sendMessage(String sendId, String receiveId, String text, LocalDateTime now) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO MESSAGE(SEND_ID, RECEIVE_ID, TEXT, SENDING_TIME) VALUES(?,?,?,?);");
		ps.setString(1, sendId);
		ps.setString(2, receiveId);
		ps.setString(3, text);
		ps.setObject(4, now);
		ps.executeUpdate();

		ps.close();
		con.close();
	}
}
