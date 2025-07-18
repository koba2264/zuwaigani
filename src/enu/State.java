package enu;

public enum State {
    TREATING("治療中"),
    REMISS("寛容"),
    CURED("治癒"),
    UNKNOWN("不明");

	private final String name;
	private State(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
