package json;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ChatUser {
	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("message")
	private List<Message> messages;

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
