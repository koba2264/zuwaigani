package server;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/WebSocketServer")
public class WebSocketServer {

//	チャットルーム内のセッションを保存する変数
	private static final Map<String,List<Session>> ChatSessions = new HashMap<>();


    @OnMessage
    public String onMessage(String message,Session senderSession) {
    	System.out.println("WebSocketで受信したメッセージ：" + message);
    	List<Session> sessions;
    	if(ChatSessions.containsKey(message)) {
    		sessions = ChatSessions.get(message);
    		if(!sessions.contains(senderSession)) {
    			sessions.add(senderSession);
    		}
    	} else {
    		sessions = new ArrayList<>();
    		sessions.add(senderSession);
    	}
    	ChatSessions.put(message, sessions);
        return null;
    }

    @OnError
    public void onError(Throwable th) {
        // WebSocketエラーが発生した際の処理を実装
        System.out.println("WebSocketエラーが発生：" + th.getMessage());
    }

    @OnOpen
    public void onOpen(Session session) {
        // セッションが確立した際の処理を実装
    	// セッションIDを保存
    	System.out.println("WebSocketセッション確立");
    }

    @OnClose
    public void onClose(Session session) {

        System.out.println("WebSocketセッション終了");
    }
}