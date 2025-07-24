package tool;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class ServletContextChat extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        if (httpSession != null) {
            ServletContext servletContext = httpSession.getServletContext();
            // UserPropertiesに格納してWebSocketエンドポイントで受け取る
            config.getUserProperties().put(ServletContext.class.getName(), servletContext);
        }
    }
}

