package com.example.crud.controller;

import com.example.crud.entity.Information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    public TextField id;
    public TextField productName;
    public TextField seller;
    public TextField price;

    public TableView<Information> tableView;
    public TableColumn<Information,Integer> col_id;
    public TableColumn<Information,String> col_productName;
    public TableColumn<Information,String> col_seller;
    public TableColumn<Information,String> col_price;
    public TableColumn<Information,String> col_edit;
    public TableColumn<Information,String> col_delete;

    public HBox hboxx;

    public ObservableList<Information> list = FXCollections.observableArrayList();
    List<Button> buttonList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_id.setCellValueFactory(new PropertyValueFactory<Information,Integer>("Id"));
        col_productName.setCellValueFactory(new PropertyValueFactory<Information,String>("Product"));
        col_seller.setCellValueFactory(new PropertyValueFactory<Information,String>("Seller"));
        col_price.setCellValueFactory(new PropertyValueFactory<Information,String>("Price"));
        col_edit.setCellValueFactory(new PropertyValueFactory<Information,String>("Edit"));
        col_delete.setCellValueFactory(new PropertyValueFactory<Information,String>("Delete"));
    }

    public void insert(ActionEvent actionEvent) {
        String id1 = id.getText();
        String productName1 = productName.getText();
        String seller1 = seller.getText();
        String price1 = price.getText();

        Font font = Font.font("Courier New", FontWeight.BOLD, 15);

        Button editButton = new Button("Edit");{
            editButton.setOnAction((ActionEvent event) -> {
                System.out.println("Hello Joy");
            });
        }

        editButton.setStyle("-fx-background-color: Orange; " + "-fx-text-fill: white");

        editButton.setFont(font);
        
        Button deleteButton = new Button("Delete");{
            deleteButton.setOnAction((ActionEvent event) -> {
                System.out.println("Hello Dear...");
            });
        }

        deleteButton.setStyle("-fx-background-color: red; " + "-fx-text-fill: white");
        deleteButton.setFont(font);

        /*Information information = new Information( Integer.parseInt(id1) , productName1,seller1,price1, editButton, deleteButton);
        list.add(information);
        tableView.setItems(list);*/
    }

    public void deleteAll(ActionEvent actionEvent) {

    }

    public void delete(ActionEvent actionEvent) {

    }

    public void update(ActionEvent actionEvent) {
        System.out.println("Update");
    }
}
