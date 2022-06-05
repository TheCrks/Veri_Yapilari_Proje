package com.example.javaproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Library {
    public static ArrayList<Media> postLib = new ArrayList<>();
    public static ArrayList<String> attributes = new ArrayList<>();
    public static ArrayList<String> categories = new ArrayList<>();
    public static ArrayList<String> Modules = new ArrayList<>();
    public static File attributeFile = new File("attributes.txt");
    public static File categoryFile = new File("categories.txt");
    public static File postLibFile = new File("postLibrary.txt");
    public static MyStack basvuruStack = new MyStack();

    public static void addPost(Media post){
        postLib.add(post);
    }
    public static void removePost(Media post){
        postLib.remove(post);
    }

    public static Media getRandomPost(){
        Random random = new Random();
        int num= random.nextInt(0,postLib.size());
        return postLib.get(num);
    }

}
