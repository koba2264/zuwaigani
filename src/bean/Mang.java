package bean;

import java.io.Serializable;

//申し送り事項
public class Mang implements Serializable {
//	記入者
	private Employee employee;
//	内容
	private String message;

//	ゲッター
	public Employee getEmployee() {
		return employee;
	}
	public String getMessage() {
		return message;
	}

//	セッター
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
