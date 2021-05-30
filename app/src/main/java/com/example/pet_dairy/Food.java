package com.example.pet_dairy;

public class Food {

    String person, now, food1, food2;

    public Food(String person, String now, String food1, String food2) {
        this.person = person;
        this.now = now;
        this.food1 = food1;
        this.food2 = food2;
    }

    public Food(){}

    public String getperson() { return person; }
    public void setperson(String person) { this.person = person; }

    public String getnow() { return now; }
    public void setnow(String now) { this.now = now; }

    public String getfood1() { return food1; }
    public void setfood1(String food1) { this.food1 = food1; }

    public String getfood2() { return food2; }
    public void setfood2(String food2) { this.food2 = food2; }

}