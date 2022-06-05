package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuController {
    @FXML
    protected Label warn;
    @FXML
    protected void back(){
        Public.publicStage.setScene(Public.scene);
        Public.publicStage.setTitle("Giriş Yapınız");
        Public.publicStage.show();
    }
    @FXML
    protected void menu1(){
        Public.publicStage.setScene(Public.MediaScene);
        Public.publicStage.setTitle("Menu");
        Public.publicStage.show();
    }
    @FXML
    protected void menu2(){
        Public.publicStage.setScene(Public.reInfoScene);
        Public.publicStage.setTitle("Bilgi Güncelle");
        Public.publicStage.show();
    }
    @FXML
    protected void menu3(){
        Public.publicStage.setScene(Public.basvurScene);
        Public.publicStage.setTitle("Basvurular");
        Public.publicStage.show();
    }

}