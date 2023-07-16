package com.aziz.recycler_view;

import android.widget.EditText;

public class NotesModel {
    String name,phone;

    public NotesModel(String name,String phone) {
        this.phone = phone;
        this.name=name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
