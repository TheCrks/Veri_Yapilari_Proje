package com.example.javaproject;

import java.util.ArrayList;

public class PQueue {
    ArrayList<Node> Queue = new ArrayList<>();
    Node Head;

    public void expand(Node node){
        int i = 0;
        while (true){
            if (Queue.size() > 0){
            if (i >= Queue.size()){
                if (i!=0){
                    Queue.get(i-1).next = node;
                    node.before = Queue.get(i-1);
                }
                    Queue.add(node);
                    int counter = i;
                    try {
                    while (Queue.get(counter).priority < Queue.get(counter-1).priority){
                        Node temper = Queue.get(counter);
                        Queue.set(counter , Queue.get(counter-1));
                        Queue.set(counter-1, temper);
                        counter--;
                        if (counter <1)
                            break;
                    }
                    }
                    catch (Exception e){
                        System.out.println("error");
                    }
                    break;
            }
            }else{
                Queue.add(node);
                break;}
            i++;
        }
    }

    public Node getHead() {
        Head = Queue.get(0);
        return Head;
    }

    public void printToString() {
        for (int i= 0; i< Queue.size();i++){
            System.out.println("Priority: " + Queue.get(i).priority +"  " +  Queue.get(i).data.toString());
        }
    }

    public Node pull(){
       Node data = Queue.get(0);
       Queue.remove(0);
       return data;
    }
}
