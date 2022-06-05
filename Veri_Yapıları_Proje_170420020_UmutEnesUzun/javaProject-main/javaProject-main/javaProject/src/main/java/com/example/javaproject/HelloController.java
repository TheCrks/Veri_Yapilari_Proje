package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {


    @FXML
    private TextField usernameIn;

    @FXML
    private PasswordField passwordIn;
    @FXML
    private Label warn;

    @FXML
    protected void logAction() throws FileNotFoundException {
        ArrayList<String> datas = new ArrayList<>();
        String username = usernameIn.getText();
        String password = passwordIn.getText();
        String fileName = "Accounts/"+username+".txt";
        File file = new File(fileName);
        if (file.canRead()){
            Scanner reader = new Scanner(file);
            while (reader.hasNext()){
                String data = reader.next();
                datas.add(data);
            }
            String passCheck = datas.get(0);
            password = "["+password+",";
            if (Objects.equals(passCheck, password)){
                Public.publicStage.setTitle("Ana Menü");
                Public.publicStage.setScene(Public.menuScene);
                Public.publicStage.show();
                warn.setVisible(false);
                usernameIn.setText("");   passwordIn.setText("");
            }
            else{
                warn.setText("Yanlış Şifre");
                warn.setVisible(true);
            }

        }else{
            warn.setText("Geçersiz Kullanıcı Adı");
            warn.setStyle("-fx-text-fill: red");
            warn.setVisible(true);
        }

    }
    @FXML
    protected void signAction(){
        Public.publicStage.setTitle("Kayıt Ol");
        Public.publicStage.setScene(Public.signScene);
        Public.publicStage.show();
    }
}