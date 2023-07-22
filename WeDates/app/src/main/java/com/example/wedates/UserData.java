package com.example.wedates;

import android.widget.EditText;

public class UserData {
    String user_name,user_email,user_pass,last_message,send_Time,profile_pic;

    public UserData(String user_name, String user_email, String user_pass, String last_message, String send_Time, String profile_pic) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_pass = user_pass;
        this.last_message = last_message;
        this.send_Time = send_Time;
        this.profile_pic = profile_pic;
    }

    public UserData(String user_name, String user_email, String user_pass) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_pass = user_pass;
    }

    public String getLast_message() {
        return last_message;
    }

    public void setLast_message(String last_message) {
        this.last_message = last_message;
    }

    public String getSend_Time() {
        return send_Time;
    }

    public void setSend_Time(String send_Time) {
        this.send_Time = send_Time;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
}
