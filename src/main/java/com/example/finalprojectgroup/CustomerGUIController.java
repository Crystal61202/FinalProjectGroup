package com.example.finalprojectgroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class CustomerGUIController implements Initializable {

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> addressColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;
    @FXML
    private TableColumn<Customer, String> usernameColumn;
    @FXML
    private TableColumn<Customer, String> passwordColumn;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField passwordText;
    @FXML
    private TextField phoneText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField addressText;
    @FXML
    private TextField IDText;
    @FXML
    private ChoiceBox<String> accountBox = new ChoiceBox<>();

    @FXML
    private ProgressBar progressBar1;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Label label;

    private final String[]  accountList = {"GuestAccount","RegularAccount","ViPAccount"};

    ArrayList<Customer> cList = CustomerDatabase.getCustomers("src/main/resources/com/example/data/customer.txt");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Comparator<Customer> idComparator = Comparator.comparing(Customer::getID);
        cList.sort(idComparator);
        ObservableList<Customer> customerList = FXCollections.observableArrayList(cList);

        idColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("ID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("password"));

        customerTable.setItems(customerList);
        accountBox.getItems().addAll(accountList);


    }




    @FXML
    private void removeCustomer(ActionEvent event) {
        // Get the customer ID from the user.
        //String id = JOptionPane.showInputDialog("Enter the customer ID to remove:");
        Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();

        //Remove the selected customer from the table
        customerTable.getItems().remove(selectedCustomer);

        // Remove the customer from the customer list (cList).
        cList.remove(selectedCustomer);
        for(Customer i : cList){
            CustomerDatabase.addCustomer("src/main/resources/com/example/data/item.txt", i);
        }

        // Update the TableView to remove the customer data.
        customerTable.refresh();


    }
    public void add(ActionEvent event){
        String type = accountBox.getValue();
        Customer newCustomer;
        if (type.matches("GuestAccount")) {
            newCustomer = createGuestAccount();
        } else if (type.matches("RegularAccount")) {
            newCustomer = createRegularAccount();
        } else {
            newCustomer = createVIPAccount();
        }
        CustomerDatabase.addCustomer("src/main/resources/com/example/data/customer.txt", newCustomer);
    }
    private GuestAccount createGuestAccount(){
        GuestAccount guestAcc = new GuestAccount();
        setCommonCustomerProperties(guestAcc);
        return guestAcc;
    }
    private RegularAccount createRegularAccount(){
        RegularAccount regularAcc = new RegularAccount();
        setCommonCustomerProperties(regularAcc);
        return regularAcc;
    }
    private VIPAccount createVIPAccount(){
        VIPAccount vipAcc = new VIPAccount();
        setCommonCustomerProperties(vipAcc);
        return vipAcc;
    }
    public void setCommonCustomerProperties(Customer customer) {
        customer.setAccountType(accountBox.getValue());
        customer.setID(IDText.getText());
        customer.setName(nameText.getText());
        customer.setAddress(addressText.getText());
        customer.setPhone(phoneText.getText());
        customer.setUsername(usernameText.getText());
        customer.setPassword(passwordText.getText());
    }

    private void updateTable() {
        ArrayList<Customer> list = CustomerDatabase.getCustomers("src/main/resources/com/example/data/customer.txt");
        Comparator<Customer> idComparator = Comparator.comparing(Customer::getID);
        cList.sort(idComparator);
        ObservableList<Customer> customerList = FXCollections.observableArrayList(cList);
        customerTable.setItems(customerList);
    }

    public void clear(ActionEvent e){
        clearTextFields();
    }


    private void clearTextFields() {
        IDText.clear();
        usernameText.clear();
        nameText.clear();
        addressText.clear();
        phoneText.clear();
        passwordText.clear();
    }

}
