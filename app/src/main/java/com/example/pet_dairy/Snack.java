package com.example.pet_dairy;


public class Snack {
    String Give;
    String Type;
    String Many;
    String Date;

    public Snack(String Give, String Type, String Many, String Date) {
        this.Give = Give;
        this.Type = Type;
        this.Many = Many;
        this.Date = Date;
    }

    public Snack(){}

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

    public String getMany() {
        return Many;
    }
    public void setMany(String Many) {
        Many = Many;
    }

    public String getDate() {
        return Date;
    }
    public void setDate(String Date) {
        Date = Date;
    }


}