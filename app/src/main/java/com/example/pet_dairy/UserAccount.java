package com.example.pet_dairy;

public class UserAccount
{
    private String idToken; // Firebase Uid( 고유토큰정보)
    private String emailId;
    private String password;

    public UserAccount() {    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}