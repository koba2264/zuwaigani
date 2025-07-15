package enu;

public enum Section {
	MOVEIN("入居"),
	DAYSERVICE("デイサービス");

	private final String name;
	private Section(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
