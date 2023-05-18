package com.example.finalprojectgroup;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerGUI.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();

        CustomerGUIController controller = loader.getController();
        controller.setDatabase(new CustomerDatabase());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
