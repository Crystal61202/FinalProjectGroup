import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomerGUI extends Application {

    private Controller customerList;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer_gui.fxml"));
        AnchorPane root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rental App");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
