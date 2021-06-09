package com.example.pet_dairy;
// 건강 등록 파이어베이스 연결

public class Record_H {

    String IdText1;
    String IdText2;
    String IdText3;
    String IdText4;
    String IdText5;

    public Record_H(String IdText1, String IdText2, String IdText3,String IdText4,String IdText5){
        this.IdText1 = IdText1;
        this.IdText2 = IdText2;
        this.IdText3 = IdText3;
        this.IdText4 = IdText4;
        this.IdText5 = IdText5;
    }

    public Record_H(){}


    public String getIdText1() {
        return IdText1;
    }

    public void setIdText1(String IdText1) {
        this.IdText1 = IdText1;
    }


    public String getIdText2() {
        return IdText2;
    }

    public void setIdText2(String IdText2) {
        this.IdText2 = IdText2;
    }


    public  String getIdText3() {
        return IdText3;
    }

    public  void setIdText3(String IdText3) {
        this.IdText3 = IdText3;
    }

    public  String getIdText4() {
        return IdText4;
    }

    public  void setIdText4(String IdText4) {
        this.IdText4 = IdText4;
    }

    public  String getIdText5() {
        return IdText5;
    }

    public  void setIdText5(String IdText5) {
        this.IdText5 = IdText5;
    }
}