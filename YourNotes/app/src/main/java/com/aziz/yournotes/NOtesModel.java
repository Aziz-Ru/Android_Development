package com.aziz.yournotes;

import com.google.firebase.Timestamp;

public class NOtesModel {
    String title,content;
    com.google.firebase.Timestamp timestamp;

    public NOtesModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
