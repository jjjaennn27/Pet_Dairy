package com.example.pet_dairy;


public class Person {

    String name;
    String age;
    String NickName;

    public Person(String name, String Age, String Nickname) {
        this.name = name;
        this.age = Age;
        this.NickName = Nickname;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String Age) {
        this.age = Age;
    }


    public  String getNickName() {
        return NickName;
    }

    public  void setNickName(String Nickname) {
        this.NickName = Nickname;
    }
}