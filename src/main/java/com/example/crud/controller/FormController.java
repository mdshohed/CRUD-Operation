package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.Validation;
import com.example.crud.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class FormController extends DatabaseConnection implements Initializable {
    public TextField firstField;
    public TextField lastField;
    public TextField emailField;
    public PasswordField passwordField;
    public Button exitBtn;
    public Button nextBtn;
    public TableView<User> tableView;
    public TableColumn<User, String> firstNameCol = new TableColumn<>("FirstName");
    public TableColumn<User,String> lastNameCol;
    public TableColumn<User,String> emailCol;
    public TableColumn<User,String> passwordCol;
    public TableColumn<User,Button> editBtnCol;
    public TableColumn<User,Button> deleteBtnCol;

    final ObservableList<User> users = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        editBtnCol.setCellValueFactory(new PropertyValueFactory<>("edit"));
        deleteBtnCol.setCellValueFactory(new PropertyValueFactory<>("delete"));
        showTable();
    }

    public void insert(ActionEvent actionEvent) {
        String firstName = firstField.getText();
        String lastName = lastField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        Validation validation = new Validation();
        if(firstName.equals("")||lastName.equals("")||email.equals("")||password.equals("")){
            validation.alert3("Null Text", "Please fill text Field");
            return;
        }
        firstField.setText("");
        lastField.setText("");
        emailField.setText("");
        passwordField.setText("");

        Button editButton = new Button("edit");{
            editButton.setOnAction((ActionEvent event) ->{
                System.out.println("Hello!");
            });
            editButton.setStyle("-fx-background-color: orange; -fx-text-fill: white; -fx-text-alignment: center");
            editButton.setFont(Font.font("Courier New", FontWeight.BOLD, 15));
        }
        Button deleteButton = new Button("delete");{
            deleteButton.setOnAction((ActionEvent event)->{
                System.out.println("Hello!");
            });
            deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white");
            deleteButton.setFont(Font.font("Courier New", FontWeight.BOLD,15));
        }

        Connection connection = getConnections();
        try {
            if (!connection.isClosed()){
                String sql = "INSERT INTO curd(firstName, lastName, email, password) VALUE(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);
                preparedStatement.executeUpdate();
                validation.alert1("Success!","Successfully set data!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showTable();
    }

    public void reset(ActionEvent actionEvent) {
        firstField.setText("");
        lastField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }

    public void exit(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void showTable()  {
        Connection connection = getConnections();
        tableView.getItems().clear();
        try {
            if(!connection.isClosed()){
                String sql = "SELECT * FROM curd";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    User user = new User(firstName, lastName, email, password, null, null);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tableView.setItems(users);
    }
    public void downloadTable(){
        System.out.println("hello!");
//        tableView.getItems().clear();
    }
}
