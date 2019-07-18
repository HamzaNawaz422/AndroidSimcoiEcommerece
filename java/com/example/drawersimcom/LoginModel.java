package com.example.drawersimcom;

public class LoginModel {
    String success,message,userid;

    public LoginModel(String success, String message, String userid) {
        this.success = success;
        this.message = message;
        this.userid = userid;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getUserid() {
        return userid;
    }
}
