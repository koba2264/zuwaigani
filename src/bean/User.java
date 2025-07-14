package bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User implements Serializable {
	private String id;
	private String name;
	private String namef;
	private Gender gender;
	private LocalDate birthDay;
	private String bloodType;
	private String number;
	private String address;
	private String sos1;
	private String sos2;
	private boolean spouse;
	private boolean enrollment;
	private LocalDate day;
	private Section section;

	// ゲッター
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNamef() {
		return namef;
	}

	public String getNumber() {
		return number;
	}

	public String getAddress() {
		return address;
	}

	public String getSos2() {
		return sos2;
	}

	public String getSos1() {
		return sos1;
	}

	public boolean isSpouse() {
		return spouse;
	}

	public boolean isEnrollment() {
		return enrollment;
	}

	public LocalDate getDay() {
		return day;
	}

	public Section getSection() {
		return section;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}

	// sql用
	public void setBirthDaySql(Date birthDay) {
		this.birthDay = birthDay.toLocalDate();
	}

	// セッター
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNamef(String namef) {
		this.namef = namef;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setEnrollment(boolean enrollment) {
		this.enrollment = enrollment;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	// sql用
	public Date getBirthDaySql() {
		return Date.valueOf(this.birthDay);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

}
