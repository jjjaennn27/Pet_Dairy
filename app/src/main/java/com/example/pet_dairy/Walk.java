package com.example.pet_dairy;

public class Walk {

    String Person, Time, Place;

    public Walk(String Person, String Time, String Place) {
        this.Person = Person;
        this.Time = Time;
        this.Place = Place;
    }

    public String getPerson() { return Person; }
    public void setPerson(String Person) { this.Person = Person; }

    public String getTime() { return Time; }
    public void setTime(String Time) { this.Time = Time; }

    public String getPlace() { return Place; }
    public void setPlace(String Place) { this.Place = Place; }

}