package enu;

public enum Gender {
    MALE("男性"),
    FEMALE("女性"),
    NO("無回答");

    private final String name;
    private Gender(String name){
    	this.name = name;
    }
    public String getName(){
    	return name;
    }
}
