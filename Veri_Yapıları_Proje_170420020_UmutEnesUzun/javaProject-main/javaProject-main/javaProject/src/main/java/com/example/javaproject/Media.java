package com.example.javaproject;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Media{
    private String post;
    private int popularity;
    private String date;
    private int hour;
    private int minute;
    private String catagory;
    private ArrayList<String> attributes = new ArrayList<>();
    private LinkedHashMap<Character, String> hashAttributes = new LinkedHashMap<>();

    Media(){}

    Media(String post, int popularity, String date, int hour, int minute, String category){
        this.post = post;
        this.popularity = popularity;
        this.date = date;
        this.hour =  hour;
        this.minute = minute;
        this.catagory = category;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setHashAttributes(char key, String value) {
        this.hashAttributes.put(key,value);
    }

    public int getHour () {
        return this.hour;
    }

    public int getMinute () {
        return minute;
    }

    public int getPopularity () {
        return popularity;
    }

    public String getCatagory () {
        return catagory;
    }

    public String getDate () {
        return date;
    }

    public String getPost () {
        return post;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(String attribute) {
        this.attributes.add(attribute);
    }

    public LinkedHashMap<Character, String> getHashAttributes() {
        return hashAttributes;
    }

    public String toString(){
        String hourS = "";
        String minuteS = "";
        if (this.hour < 10){
             hourS = "0" + this.hour;
        }else{
             hourS = String.valueOf(this.hour);
        }
        if (this.minute < 10){
             minuteS = "0" + this.minute;
        }else{
             minuteS = String.valueOf(this.minute);
        }

        return this.post + " " + this.date +", saat " + hourS +":"+minuteS+", " + String.valueOf(this.popularity)+" popülerite";
    }
}
