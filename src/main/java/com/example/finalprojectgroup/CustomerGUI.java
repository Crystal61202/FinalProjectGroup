package com.example.finalprojectgroup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CustomerGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer_gui.fxml"));
        AnchorPane root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer page");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
