package decoder;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import json.ChatOpen;

public class ChatOpenDecoder implements Decoder.Text<ChatOpen> {

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig arg0) {
	}

	@Override
	public ChatOpen decode(String text) throws DecodeException {
		ObjectMapper mapper = new ObjectMapper();
		ChatOpen obj = null;
		try {
			obj = mapper.readValue(text, ChatOpen.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean willDecode(String text) {
		return (text != null);
	}

}
