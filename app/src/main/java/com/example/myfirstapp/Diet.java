package com.example.myfirstapp;

import android.content.Context;

import java.util.ArrayList;

public class Diet {
    private String title;
    private String description;

    public Diet(String title, String description) {
        this.title = title;
        this.description = description;
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
}
