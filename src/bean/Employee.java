package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Employee implements Serializable {

	private String id;
	private String name;
	private String namef;
	private String gender;
	private String genderId;
	private LocalDate birthDay;
	private String role;
	private boolean spouse;
	private String job;
	private String jobId;
	private static Map<String, String> genderMap = new HashMap<String, String>(){
		{
			put("01","男性");
			put("02","女性");
			put("03","無回答");
		}
	};
	private static Map<String, String> jobMap = new HashMap<String, String>(){
		{
			put("01","看護師");
			put("02","医者");
			put("03","無回答");
		}
	};

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
	public void setGender(String genderId) {
		this.genderId = genderId;
		this.gender = Employee.genderMap.get(genderId);
	}
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}
	public void setJob(String jobId) {
		this.setJobId(jobId);
		this.job = Employee.jobMap.get(this.jobId);
	}
	private void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getGender() {
		return gender;
	}
	public String getRole() {
		return role;
	}
	public boolean isSpouse() {
		return spouse;
	}
	public String getJob() {
		return job;
	}
	public String getJobId() {
		return jobId;
	}
}
