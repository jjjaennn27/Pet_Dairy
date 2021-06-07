package com.example.pet_dairy;

public class Pet {

    String name;
    String kind;
    String Birthday;
    String Genderboy;
    String Gendergirl;

    public Pet(String name, String kind, String birthday) {
        this.name = name;
        this.kind = kind;
        this.Birthday = birthday;


    }
    public Pet(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getkind() {
        return kind;
    }

    public void setkind(String kind) {
        this.kind = kind;
    }

    public  String getbirthday() {
        return Birthday;
    }

    public  void setbirthday(String birthday) {
        this.Birthday = birthday;
    }




}