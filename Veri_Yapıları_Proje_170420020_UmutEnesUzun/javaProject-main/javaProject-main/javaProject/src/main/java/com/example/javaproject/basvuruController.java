package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class basvuruController {

    @FXML
    protected ListView list;

    @FXML
    protected void back(){
        Public.publicStage.setTitle("Ana Menü");
        Public.publicStage.setScene(Public.menuScene);
        Public.publicStage.show();
    }
    @FXML
    protected void yenile(){
        MyStack temper = new MyStack();
        list.getItems().clear();
        Library.basvuruStack.printToString();
        int bound = Library.basvuruStack.Stack.size();
        for (int i=0; i <bound; i++){
            temper.expand(Library.basvuruStack.pullNoRemove());
            list.getItems().add(Library.basvuruStack.pull().objectData);
        }
        for (int i=0 ; i<bound ;i++){
            Library.basvuruStack.expand(temper.pull());
        }
    }

    @FXML
    protected void setWarn(){

    }
}
