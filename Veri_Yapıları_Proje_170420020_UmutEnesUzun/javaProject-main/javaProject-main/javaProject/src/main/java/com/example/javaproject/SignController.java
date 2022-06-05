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

public class SignController {
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
    protected void kayitOl() throws IOException {
        ArrayList<String> info = new ArrayList<String>();
        info.add(passIn.getText());
        info.add(nameIn.getText());
        info.add(surnameIn.getText());
        info.add(dateIn.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        String fileName = "Accounts/"+userIn.getText()+".txt";
        File file = new File(fileName);
        if (file.canRead()){
            warn.setText("Kullanıcı adı kullanımda");
            warn.setVisible(true);
        }
        else{
            FileWriter writer = new FileWriter(fileName);
            writer.write(String.valueOf(info));
            writer.close();
            warn.setText("Başırı ile Kayıt Olundu");
            warn.setVisible(true);
        }

    }
    @FXML
    protected void back(){
        Public.publicStage.setScene(Public.scene);
        Public.publicStage.setTitle("Giriş Yapınız");
        Public.publicStage.show();
    }
}
