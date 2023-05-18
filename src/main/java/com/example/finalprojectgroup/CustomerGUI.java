import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerGUI extends Application {

    private Label label;
    private Button addButton;
    private Button removeButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        label = new Label("No customers");
        addButton = new Button("Add Customer");
        removeButton = new Button("Remove Customer");

        addButton.setOnAction(e -> {
            // Add customer code here
        });

        removeButton.setOnAction(e -> {
            // Remove customer code here
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, addButton, removeButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
