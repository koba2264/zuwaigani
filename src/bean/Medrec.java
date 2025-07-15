package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//診療録
public class Medrec implements Serializable {
	private User user;
//	部屋番号
	private String roomNum;
//	介助レベル
	private String level;
//	身長
	private float height;
//	体重
	private float weight;
//	血圧
	private String bloodPres;
//	アレルギーリスト
	private List<Allergy> allergyList = new ArrayList<>();
//	注意事項
	private Careful careful;
//	申し送り事項リスト
	private List<Mang> mangList = new ArrayList<>();
//	病歴リスト
	private List<Medhis> medhisList = new ArrayList<>();
//	スケジュール
	private List<Schedule> Schedules = new ArrayList<>();
//	朝の薬
	private List<Drag> morningDrag = new ArrayList<>();
//	昼の薬
	private List<Drag> noonDrag = new ArrayList<>();
//	夜の薬
	private List<Drag> nightDrag = new ArrayList<>();

//	ゲッター
	public User getUser() {
		return user;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public String getLevel() {
		return level;
	}
	public float getHeight() {
		return height;
	}
	public float getWeight() {
		return weight;
	}
	public String getBloodPres() {
		return bloodPres;
	}
	public List<Allergy> getAllergyList() {
		return allergyList;
	}
	public Careful getCareful() {
		return careful;
	}
	public List<Mang> getMangList() {
		return mangList;
	}
	public List<Medhis> getMedhisList() {
		return medhisList;
	}
	public List<Schedule> getSchedules() {
		return Schedules;
	}
	public List<Drag> getMorningDrag() {
		return morningDrag;
	}
	public List<Drag> getNoonDrag() {
		return noonDrag;
	}
	public List<Drag> getNightDrag() {
		return nightDrag;
	}


//	セッター
	public void setUser(User user) {
		this.user = user;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setBloodPres(String bloodPres) {
		this.bloodPres = bloodPres;
	}
	public void setAllergyList(List<Allergy> allergyList) {
		this.allergyList = allergyList;
	}
	public void setAllergy(Allergy allergy) {
		this.allergyList.add(allergy);
	}
	public void setCareful(Careful careful) {
		this.careful = careful;
	}
	public void setMangList(List<Mang> mangList) {
		this.mangList = mangList;
	}
	public void setMang(Mang mang) {
		this.mangList.add(mang);
	}
	public void setMedhisList(List<Medhis> medhisList) {
		this.medhisList = medhisList;
	}
	public void setMedhis(Medhis medhis) {
		this.medhisList.add(medhis);
	}
	public void setSchedules(List<Schedule> schedules) {
		Schedules = schedules;
	}
	public void setSchedule(Schedule schedule) {
		Schedules.add(schedule);
	}
	public void setMorningDrag(List<Drag> morningDrag) {
		this.morningDrag = morningDrag;
	}
	public void setMorningDrag(Drag drag) {
		this.morningDrag.add(drag);
	}
	public void setNoonDrag(List<Drag> noonDrag) {
		this.noonDrag = noonDrag;
	}
	public void setNoonDrag(Drag drag) {
		this.noonDrag.add(drag);
	}
	public void setNightDrag(List<Drag> nightDrag) {
		this.nightDrag = nightDrag;
	}
	public void setNightDrag(Drag drag) {
		this.nightDrag.add(drag);
	}

}
