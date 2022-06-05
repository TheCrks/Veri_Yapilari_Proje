package com.example.javaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Public.publicStage.setTitle("Giriş Yapınız");
        Public.publicStage.setScene(Public.scene);
        Public.publicStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}