package com.example.javaproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Public {
    public static Stage publicStage = new Stage();
    public static FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    public static FXMLLoader signFxml = new FXMLLoader(HelloApplication.class.getResource("signUp.fxml"));
    public static FXMLLoader mainMenuFxml = new FXMLLoader(HelloApplication.class.getResource("mainMenu.fxml"));
    public static FXMLLoader MediaFxml = new FXMLLoader(HelloApplication.class.getResource("mediaMenu.fxml"));
    public static FXMLLoader reInfoFxml = new FXMLLoader(HelloApplication.class.getResource("reInfo.fxml"));
    public static FXMLLoader basvurFxml = new FXMLLoader(HelloApplication.class.getResource("basvurMenu.fxml"));
    public static Scene MediaScene;
    public static Scene basvurScene;
    public static Scene menuScene;
    public static Scene scene;
    public static Scene signScene;
    public static Scene reInfoScene;

    static {
        try {
            menuScene = new Scene(mainMenuFxml.load(),850,510);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            signScene = new Scene(signFxml.load(), 850,510);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            scene = new Scene(Public.fxmlLoader.load(), 850, 510);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            MediaScene = new Scene(Public.MediaFxml.load(), 850, 510);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reInfoScene = new Scene(reInfoFxml.load(), 850,510);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            basvurScene = new Scene(basvurFxml.load(), 850,510);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
