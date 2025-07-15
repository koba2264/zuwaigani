package enu;

public enum Role {
	ADMIN("管理者"),
	COMMON("一般");

	private final String name;
	private Role(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
