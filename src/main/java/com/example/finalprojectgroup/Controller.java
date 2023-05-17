package com.example.finalprojectgroup;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.example.finalprojectgroup.Item;

public class Controller implements Initializable {
    @FXML
    private TableView<Item> table;

    @FXML
    private TableColumn<Item, String> idColumn;
    @FXML
    private TableColumn<Item, String> titleColumn;
    @FXML
    private TableColumn<Item, String> rentalTypeColumn;
    @FXML
    private TableColumn<Item, String> loanTypeColumn;
    @FXML
    private TableColumn<Item, Integer> numberOfCopiesColumn;
    @FXML
    private TableColumn<Item, Double> rentalFeeColumn;
    @FXML
    private TableColumn<Item, String> rentalStatusColumn;
    @FXML
    private TableColumn<Item, String> genreColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Item> list  = ItemDatabase.getRecord("src/main/resources/com/example/data/item.txt");
        Comparator<Item> idComparator = Comparator.comparing(Item::getID);
        Collections.sort(list, idComparator);
        ObservableList<Item> itemList = FXCollections.observableArrayList(list);
        idColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("ID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
        rentalTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("rentType"));
        loanTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("loanType"));
        numberOfCopiesColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("numberOfCopies"));
        rentalFeeColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("rentalFee"));
        rentalStatusColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("rentalStatus"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("genre"));
        table.setItems(itemList);
    }
}

