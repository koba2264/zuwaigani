package enu;

public enum Timing {
    BEFORE("食前"),
    AFTER("食後"),
    BETWEEN("食間"),
    ANYTIME("いつでも");

	private final String name;
	private Timing(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
