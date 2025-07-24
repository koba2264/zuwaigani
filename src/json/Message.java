package json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("text")
	private String text;
	@JsonProperty("id")
	private String id;
	@JsonProperty("time")
	private String time;

	public void setText(String text) {
		this.text = text;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
