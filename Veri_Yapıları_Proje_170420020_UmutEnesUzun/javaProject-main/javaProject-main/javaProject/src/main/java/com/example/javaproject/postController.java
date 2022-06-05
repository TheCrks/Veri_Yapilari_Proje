package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class postController {
    @FXML
    protected Label warn;
    @FXML
    protected ListView list;
    @FXML
    protected ChoiceBox attributeChoice;
    @FXML
    protected ChoiceBox categoryChoice;
    @FXML
    protected ChoiceBox popChoice;
    @FXML
    protected ChoiceBox ModuleChoice;

    @FXML
    protected void basvur(){
        int i = list.getSelectionModel().getSelectedIndex();
        Node node = new Node(0);
        node.objectData = list.getItems().get(i);
        Library.basvuruStack.expand(node);
        warn.setText("Başvurulara Eklendi");
        warn.setStyle("-fx-text-fill: red");
        warn.setVisible(true);
    }

    @FXML
    protected void back(){
        Public.publicStage.setTitle("Ana Menü");
        Public.publicStage.setScene(Public.menuScene);
        Public.publicStage.show();
    }
    @FXML
    protected void uygula(){
       String att =(String) attributeChoice.getValue();
       String cat = (String) categoryChoice.getValue();
       String pop = (String) popChoice.getValue();
       String mod = (String) ModuleChoice.getValue();
       String[] pops = pop.split("-");
       int min = Integer.parseInt(pops[0]);
       int max = Integer.parseInt(pops[1]);
       Queue<Media> shownPost= new LinkedList<>();
       Queue<Media> shownPost2 = new LinkedList<>();
       Queue<Media> shownPostFinal = new LinkedList<>();
       ArrayList<Media> posts = new ArrayList<>();

       for (int i=0; i< Library.postLib.size();i++)
        posts.add(Library.postLib.get(i));

       for (int i=0;i<Library.postLib.size();i++){
           if (Generator.indexOfString(Library.postLib.get(i).getAttributes(),att)){
               System.out.println("att");
               shownPost.add(Library.postLib.get(i));
           }
       }
       for (int i=0;i<shownPost.size();i++){
           Media data = shownPost.remove();
           if (Objects.equals(data.getCatagory(), cat)){
               System.out.println("cat");
               shownPost2.add(data);
           }else{
           shownPost.add(data);}
       }
       for (int i=0;i<shownPost2.size();i++){
           Media data = shownPost2.remove();
           int popul = data.getPopularity();
           if (min <= popul && popul <= max){
               System.out.println("pop");
               shownPostFinal.add(data);
           }else{
           shownPost2.add(data);}

       }
        if (Objects.equals(mod, Library.Modules.get(0))){
       list.getItems().clear();
       for (int i =0;i<shownPostFinal.size();i++){
           Media data = shownPostFinal.remove();
           list.getItems().add(data);
           shownPostFinal.add(data);
       }
       }
       else if (Objects.equals(mod, Library.Modules.get(1))){

           PQueue pQueue = new PQueue();
            for (int i= 0; i< shownPostFinal.size(); i++){
                Node node = new Node(0);
                node.data = shownPostFinal.remove();
                    pQueue.expand(node);
                posts.remove(node.data);
                shownPostFinal.add(node.data);
            }
            for (int i= 0; i< shownPost2.size(); i++){
                Node node = new Node(1);
                node.data = shownPost2.remove();
                    pQueue.expand(node);
                posts.remove(node.data);
                shownPost2.add(node.data);
            }
            for (int i= 0; i< shownPost.size(); i++){
                Node node = new Node(2);
                node.data = shownPost.remove();
                    pQueue.expand(node);
                posts.remove(node.data);
                shownPost.add(node.data);
            }
            list.getItems().clear();
            for (int i =0; i<posts.size(); i++){
                Node node = new Node(3);
                node.data = posts.get(i);
                pQueue.expand(node);
            }
            pQueue.printToString();
            for (int i=0; i < pQueue.Queue.size();i++){
                list.getItems().add(pQueue.pull().data);
            }
       }
       else if (Objects.equals(mod, Library.Modules.get(2))){
           TreeNode root = new TreeNode(shownPostFinal.remove().toString());
            BSearchTree bSearchTree = new BSearchTree(root);
            for (int i= 0; i< shownPostFinal.size(); i++){
                Media data = shownPostFinal.peek();
                TreeNode node = new TreeNode(shownPostFinal.remove().toString());
                bSearchTree.add(node,root);
                posts.remove(data);
                shownPostFinal.add(data);
            }
            for (int i= 0; i< shownPost2.size(); i++){
                Media data = shownPost2.peek();
                TreeNode node = new TreeNode(shownPost2.remove().toString());
                bSearchTree.add(node,root);
                posts.remove(data);
                shownPost2.add(data);
            }
            for (int i= 0; i< shownPost.size(); i++){
                Media data = shownPost.peek();
                TreeNode node = new TreeNode(shownPost.remove().toString());
                bSearchTree.add(node,root);
                posts.remove(data);
                shownPost.add(data);
            }
            for (int i =0; i<posts.size(); i++){
                TreeNode node = new TreeNode(posts.get(i).toString());
                bSearchTree.add(node, root);
            }
            list.getItems().clear();
            bSearchTree.inOrderAdd(list, root);

        }
    }
    @FXML
    protected void fillList(){
        String[] pops = {"0-1000","1000-5000","5000-10000"};
        Generator.setRandomPosts();
        for (int i=0;i<Library.postLib.size();i++) {
            list.getItems().add(Library.postLib.get(i).toString());
        }
        if (attributeChoice.getItems().size() == 0) {
            for (int i = 0; i < Library.attributes.size(); i++)
                attributeChoice.getItems().add(Library.attributes.get(i));
            for (int i = 0; i < Library.categories.size(); i++)
                categoryChoice.getItems().add(Library.categories.get(i));
            for (int i = 0; i < pops.length; i++)
                popChoice.getItems().add(pops[i]);
            for (int i = 0; i < Library.Modules.size(); i++){
                ModuleChoice.getItems().add(Library.Modules.get(i));}
        }
    }
    @FXML
    protected void setWarn(){
        int i = list.getSelectionModel().getSelectedIndex();
        warn.setText(list.getItems().get(i).toString());
        warn.setStyle("-fx-text-fill: blue");
        warn.setVisible(true);
    }
}
