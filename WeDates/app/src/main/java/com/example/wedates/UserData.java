package com.example.wedates;

import android.widget.EditText;

public class UserData {
    String user_name,user_email,user_phone,user_pass;

    public UserData(String user_name, String user_email, String user_phone, String user_pass) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_pass = user_pass;
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

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
}
