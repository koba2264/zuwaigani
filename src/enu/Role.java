package enu;

public enum Role {
	ADMIN("管理者"),
	COMMON("従業員");

	private final String name;
	private Role(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
