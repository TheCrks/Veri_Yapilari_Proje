package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class reInfoController {
    @FXML
    private TextField nameIn;
    @FXML
    private TextField surnameIn;
    @FXML
    private DatePicker dateIn;
    @FXML
    private TextField userIn;
    @FXML
    private TextField passIn;
    @FXML
    private Label warn;

    @FXML
    protected void guncelle() throws IOException {
        boolean bool = false;
        ArrayList<String> info = new ArrayList<String>();
        info.add(passIn.getText());
        info.add(nameIn.getText());
        info.add(surnameIn.getText());
        info.add(dateIn.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        String fileName = "Accounts/"+userIn.getText()+".txt";
        for (int i=0;i<4;i++){
            if (info.get(i) == null){
                bool = true;
            }
        }
        if(!bool){
        File file = new File(fileName);
        if (file.canRead()){
            FileWriter writer = new FileWriter(fileName,false);
            writer.write(String.valueOf(info));
            writer.close();
            warn.setText("Başırı ile bilgiler güncellendi");
            warn.setVisible(true);

        }
        else{
            warn.setText("Kullanıcı bulunamadı");
            warn.setVisible(true);
        }}
        else{
            warn.setText("Tüm Alanları Doldurunuz!");
            warn.setVisible(true);
        }

    }
    @FXML
    protected void back(){
        Public.publicStage.setScene(Public.menuScene);
        Public.publicStage.setTitle("Menü");
        Public.publicStage.show();
    }
}