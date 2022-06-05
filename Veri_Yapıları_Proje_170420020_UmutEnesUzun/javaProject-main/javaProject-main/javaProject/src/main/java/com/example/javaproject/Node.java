package com.example.javaproject;

public class Node {
    Media data;
    Node next = null;
    Node before = null;
    Object objectData;
    int priority;

    Node(int priority){
        this.priority = priority;
    }


}
