package com.example.javaproject;

public class TreeNode {
    String data;
    TreeNode left = null;
    TreeNode right = null;
    int value;

    TreeNode(String data){
        this.data = data;
        setValue();
    }


    private void setValue(){
        char first = data.charAt(0);
        first = Character.toLowerCase(first);
        this.value = (int) first;
    }
}
