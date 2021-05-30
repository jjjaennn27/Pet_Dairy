package com.example.pet_dairy;

public class Board {
    String Place;
    String Time;
    String Dog_breed;
    String ID;

    public Board(String Place, String Time, String Dog_breed, String ID){
        this.Place = Place;
        this.Time = Time;
        this.Dog_breed = Dog_breed;
        this.ID = ID;

    }
    public Board(){}
    public String getPlace(){
        return Place;
    }
    public void setPlace(String Place){
        this.Place = Place;
    }
    public String getTime(){
        return Time;
    }
    public void setTime(String Time){
        this.Time= Time;
    }
    public String getDog_breed(){
        return Dog_breed;
    }
    public void setDog_breed(String Dog_breed){
        this.Dog_breed = Dog_breed;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }

}