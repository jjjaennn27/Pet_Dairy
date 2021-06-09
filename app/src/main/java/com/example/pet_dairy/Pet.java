package com.example.pet_dairy;

// 동물 등록 파이어베이스 연결

public class Pet {

    String name;
    String kind;
    String Birthday;
    String Spinnergender;

    public Pet(String name, String kind, String birthday, String spinnergender) {
        this.name = name;
        this.kind = kind;
        this.Birthday = birthday;
        this.Spinnergender = spinnergender;


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


    public String getSpinnergender() {
        return Spinnergender;
    }

    public void setSpinnergender(String spinnergender) {
        this.Spinnergender = spinnergender;
    }




}