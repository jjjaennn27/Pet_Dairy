package com.example.pet_dairy;

public class Walk {

    String Person, Time, Place, Now;

    public Walk(String Person, String Time, String Place, String Now) {
        this.Person = Person;
        this.Time = Time;
        this.Place = Place;
        this.Now = Now;
    }

    public Walk(){}

    public String getPerson() { return Person; }
    public void setPerson(String Person) { this.Person = Person; }

    public String getTime() { return Time; }
    public void setTime(String Time) { this.Time = Time; }

    public String getPlace() { return Place; }
    public void setPlace(String Place) { this.Place = Place; }

    public String getNow() { return Now; }
    public void setNow(String txtNow) { this.Now = Now; }

}