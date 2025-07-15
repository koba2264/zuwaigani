package enu;

public enum Job {
	DOCTOR("医者"),
	NURSE("看護師"),
	NO("なし");

	private final String name;
	private Job(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
