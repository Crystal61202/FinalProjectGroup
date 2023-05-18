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
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void addCustomer(ActionEvent event) {
        Customer customer = new Customer();
        customer.setId("123456789");
        customer.setName("Minh");
        customer.setAddress("Phu Nhuan");
        customer.setPhone("123-456-7890");
        customer.setUsername("Minh1234");
        customer.setPassword("kddkl;sj");

        if (allowAdminToCreateOrAdjustCustomers()) {
            customerList.add(customer);
            customerTable.refresh();
        }
    }

    private void removeCustomer(ActionEvent event) {
        // Get the customer ID from the user.
        String id = JOptionPane.showInputDialog("Enter the customer ID to remove:");

        // Remove the customer from the customer list.
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                customerList.remove(customer);
                break;
            }
        }

        // Update the TableView to remove the customer data.
        customerTable.refresh();
    }

    private boolean allowAdminToCreateOrAdjustCustomers() {
        // Get the value of the CheckBox object.
        CheckBox allowAdminToCreateOrAdjustCustomersCheckBox = (CheckBox)
            FXMLLoader.load(getClass().getResource("CustomerGUI.fxml")).lookup("#allowAdminToCreateOrAdjustCustomers");

        return allowAdminToCreateOrAdjustCustomersCheckBox.isSelected();
    }
}
