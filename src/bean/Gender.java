package bean;

import java.io.Serializable;

public class Gender implements Serializable {
	private String id;
	private String name;

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
