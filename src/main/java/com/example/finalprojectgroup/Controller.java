package com.example.finalprojectgroup;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML
    private ChoiceBox<String> genreBox = new ChoiceBox<>();
    private final String[] availableGenre = {"Horror", "Drama", "Comedy", "Action"};

    @FXML
    private ChoiceBox<String> rentalTypeBox = new ChoiceBox<>();
    private final String[] rentalList = {"VideoGame","OldMovieRecord","DVD"};

    @FXML
    private ChoiceBox<String> loanTypeBox= new ChoiceBox<>();
    private final String[] loanTypeList = {"2-day loan","1-week loan"};
    @FXML
    private TextField yearText;
    @FXML
    private TextField titleText;
    @FXML
    private TextField copiesText;
    @FXML
    private TextField feeText;

    ArrayList<Item> list  = ItemDatabase.getRecord("src/main/resources/com/example/data/item.txt");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Comparator<Item> idComparator = Comparator.comparing(Item::getID);
        list.sort(idComparator);
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

        genreBox.getItems().addAll(availableGenre);
        rentalTypeBox.getItems().addAll(rentalList);
        loanTypeBox.getItems().addAll(loanTypeList);
    }

    public void delete(ActionEvent e) {
        // Get the selected item from the table
        Item selectedItem = table.getSelectionModel().getSelectedItem();

        // Remove the selected item from the table
        table.getItems().remove(selectedItem);

        // Update the table view
        table.refresh();

        // Delete the selected item from the database
        list.remove(selectedItem);

        ItemDatabase.deleteAllItems();

        for(Item i: list){
            ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",i);
        }
    }

    public void clear(ActionEvent e){
        clearTextFields();
    }


    public void add(ActionEvent e) {
        String type = rentalTypeBox.getValue();
        Item newItem;

        if (type.matches("VideoGame")) {
            newItem = createVideoGame();
        } else if (type.matches("OldMovieRecord")) {
            newItem = createOldMovieRecord();
        } else {
            newItem = createDVD();
        }

        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt", newItem);
        updateTable();
    }

    private VideoGame createVideoGame() {
        VideoGame game = new VideoGame();
        setCommonItemProperties(game);
        return game;
    }

    private OldMovieRecord createOldMovieRecord() {
        OldMovieRecord movie = new OldMovieRecord();
        setCommonItemProperties(movie);
        movie.setGenre(genreBox.getValue());
        return movie;
    }

    private DVD createDVD() {
        DVD dvd = new DVD();
        setCommonItemProperties(dvd);
        dvd.setGenre(genreBox.getValue());
        return dvd;
    }

    private void setCommonItemProperties(Item item) {
        item.setRentType(rentalTypeBox.getValue());
        item.setYear(Integer.parseInt(yearText.getText()));
        item.setTitle(titleText.getText());
        item.setLoanType(loanTypeBox.getValue());
        item.setNumberOfCopies(Integer.parseInt(copiesText.getText()));
        item.setRentalFee(Double.parseDouble(feeText.getText()));
        item.setRentalStatus();
        item.setID();
    }

    private void updateTable() {
        ArrayList<Item> list = ItemDatabase.getRecord("src/main/resources/com/example/data/item.txt");
        Comparator<Item> idComparator = Comparator.comparing(Item::getID);
        list.sort(idComparator);
        ObservableList<Item> itemList = FXCollections.observableArrayList(list);
        table.setItems(itemList);
    }

    private void clearTextFields() {
        yearText.clear();
        titleText.clear();
        copiesText.clear();
        feeText.clear();
    }


}


