package com.example.pet_dairy;


// 산책 등록 파이어베이스 연결


public class Walk {

    String Time, Place, Person, Now;

    public Walk(String Time, String Place, String Person, String Now) {
        this.Time = Time;
        this.Place = Place;
        this.Person = Person;
        this.Now = Now;
    }
    public Walk(){}

    public String getTime() { return Time; }
    public void setTime(String Time) { this.Time = Time; }

    public String getPlace() { return Place; }
    public void setPlace(String Place) { this.Place = Place; }

    public String getPerson() { return Person; }
    public void setPerson(String Person) { this.Person = Person; }

    public String getNow() { return Now; }
    public void setNow(String Now) { this.Now = Now; }

}