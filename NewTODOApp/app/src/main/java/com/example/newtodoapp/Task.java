package com.example.newtodoapp;

public class Task {
    private String name,date;

    public Task(){

    }

    public Task(String name, String date){
        this.name=name;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }
}
