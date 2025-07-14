package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Serializable {

	private String id;
//
	private String name;
	private String namef;
	private String genderName;
	private String genderId;
	private LocalDate birthDay;
	private String role;
	private boolean spouse;
	private String jobId;
	private String jobName;

//	セッター
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
//	sql用
	public void setBirthDaySql(Date birthDay) {
		this.birthDay = birthDay.toLocalDate();
	}

	public void setNamef(String namef) {
		this.namef = namef;
	}
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

//	ゲッター
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
//	sql用
	public Date getBirthDaySql() {
		return Date.valueOf(this.birthDay);
	}
	public String getNamef() {
		return namef;
	}
	public String getGenderId() {
		return genderId;
	}
	public String getRole() {
		return role;
	}
	public boolean isSpouse() {
		return spouse;
	}
	public String getJobId() {
		return jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public String getGenderName() {
		return genderName;
	}

}

