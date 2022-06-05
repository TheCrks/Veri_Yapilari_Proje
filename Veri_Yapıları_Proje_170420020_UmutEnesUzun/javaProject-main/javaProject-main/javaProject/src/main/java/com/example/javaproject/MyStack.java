package com.example.javaproject;

import java.util.ArrayList;

public class MyStack {


    Node Head;
    ArrayList<Node> Stack = new ArrayList<>();


    public void expand(Node node){
        Stack.add(node);
    }

    public Node getHead() {
        Head = Stack.get(Stack.size()-1);
        return Head;
    }

    public Node pull(){
        Node node = getHead();
        Stack.remove(getHead());
        return node;
            }

    public Node pullNoRemove(){
        return getHead();
    }

    public void remove(Node node){
        Stack.remove(node);
    }


    public void printToString() {
        if (Stack.get(0).data == null){
        for (int i=Stack.size()-1; i>=0; i--){
            System.out.println(Stack.get(i).objectData.toString());
        }
        }else {
            for (int i=Stack.size()-1; i>=0; i--){
                System.out.println(Stack.get(i).data.toString());
            }
        }
    }
}
