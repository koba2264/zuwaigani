package enu;

public enum Job {
	DOCTOR("医者"),
	NURSE("看護師"),
	CARER("介護士"),
	ASSIST("介護助手"),
	WELFARE("介護福祉士"),
	SUPPORT("介護支援専門員"),
	CONSULT("生活相談員"),
	SERVICE("サービス提供責任者"),
	NO("なし");

	private final String name;
	private Job(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}
