package server;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tool.ServletContextChat;


@ServerEndpoint(value = "/WebSocketServer", configurator = ServletContextChat.class)
public class WebSocketServer {
	private static final Set<Session> Sessions = new CopyOnWriteArraySet<>();
//	チャットルーム内のセッションを保存する変数
	@OnMessage
    public String onMessage(String message,Session senderSession) {
            System.out.println("WebSocketで受信したメッセージ：" + message);
            ObjectMapper mapper = new ObjectMapper();
            try {
            	Chat data = mapper.readValue(message, Chat.class);
            	if (data.getType().equals("Open")) {
            		Sessions.add(senderSession);
            	} else if (data.getType().equals("Send")) {
            		for (Session session : Sessions) {
            			// セッションが開いている場合
            			if (session.isOpen()) {
            				// 人数を送る
            				session.getAsyncRemote().sendText(data.getSendId());
            			}
            		}
            	}
            } catch (JsonProcessingException e) {
            	e.printStackTrace();
            }

        return "ii";
    }

    @OnError
    public void onError(Throwable th) {
        // WebSocketエラーが発生した際の処理を実装
        System.out.println("WebSocketエラーが発生：" + th.getMessage());
    }

    @OnOpen
    public void onOpen(Session session) {
    	Sessions.remove(session);
        // セッションが確立した際の処理を実装
    	// セッションIDを保存
    	System.out.println("WebSocketセッション確立");

    }

    @OnClose
    public void onClose(Session session) {

        System.out.println("WebSocketセッション終了");
    }
    public static class Chat {
    	private String type;
    	private String myId;
    	private String sendId;
    	public String getMyId() {
    		return myId;
    	}
    	public void setMyId(String myId) {
    		this.myId = myId;
    	}
    	public String getSendId() {
    		return sendId;
    	}
    	public void setSendId(String sendId) {
    		this.sendId = sendId;
    	}
    	public String getType() {
    		return type;
    	}
    	public void setType(String type) {
    		this.type = type;
    	}
    }
}

