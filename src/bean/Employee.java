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
	private int age;
	private String number;
	private String blood;
	private String photo;
	private String address;
	private String role;
	private String sos1;
	private String sos2 = "";
	private boolean spouse;
	private String means;
	private String meansId;
	private String job;
	private String jobId;
	private static Map<String, String> meansMap = new HashMap<String, String>(){
		{
			put("01","徒歩");
			put("02","自転車");
			put("03","電車");
			put("04","自動車");
		}
	};
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
	public void setAge(int age) {
		this.age = age;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setSos1(String sos1) {
		this.sos1 = sos1;
	}
	public void setSos2(String sos2) {
		this.sos2 = sos2;
	}
	public void setSpouse(boolean spouse) {
		this.spouse = spouse;
	}
	public void setMeans(String meansId) {
		this.setMeansId(meansId);
		this.means = Employee.meansMap.get(meansId);
	}
	private void setMeansId(String meansId) {
		this.meansId = meansId;
	}
	public void setJob(String jobId) {
		this.setJobId(jobId);
		this.job = Employee.jobMap.get(this.jobId);
	}
	private void setJobId(String jobId) {
		this.jobId = jobId;
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
	public int getAge() {
		return age;
	}
	public String getNumber() {
		return number;
	}
	public String getBlood() {
		return blood;
	}
	public String getPhoto() {
		return photo;
	}
	public String getAddress() {
		return address;
	}
	public String getRole() {
		return role;
	}
	public String getSos1() {
		return sos1;
	}
	public String getSos2() {
		return sos2;
	}
	public boolean isSpouse() {
		return spouse;
	}
	public String getMeans() {
		return means;
	}
	public String getMeansId() {
		return meansId;
	}
	public String getJob() {
		return job;
	}
	public String getJobId() {
		return jobId;
	}
}
