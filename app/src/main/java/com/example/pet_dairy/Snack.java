package com.example.pet_dairy;

public class Snack {
    String Give;
    String Type;
    String Time;
    String Many;

    public Snack(String Give, String Type, String Time, String Many) {
        this.Give = Give;
        this.Type = Type;
        this.Time = Time;
        this.Many = Many;
    }

    public String getGive() {
        return Give;
    }
    public void setGive(String Give) {
        this.Give = Give;
    }

    public String getType() {
        return Type;
    }
    public void setType(String Type) {
        this.Type = Type;
    }

    public String getTime() {
        return Time;
    }
    public void setTime(String time) {
        Time = time;
    }

    public String getMany() {
        return Many;
    }
    public void setMany(String many) {
        Many = many;
    }
}