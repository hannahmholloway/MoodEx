package com.example.myfirstapp;

import android.content.Context;

import java.util.ArrayList;

public class Diet {
    private String title;
    private String description;
    private String link;

    public Diet(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String dTitle) {
        title = dTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String dDescr) {
        description = dDescr;
    }

    public String getLink() { return link; }

    public void setLink(String dLink) { link = dLink; }
}
