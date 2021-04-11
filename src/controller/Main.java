package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Statement;

public class Main extends Application {
   public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("home/home.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
