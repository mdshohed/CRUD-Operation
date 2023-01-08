module com.example.crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.crud to javafx.fxml;
    exports com.example.crud;
    exports com.example.crud.controller;
    opens com.example.crud.controller to javafx.fxml;
    exports com.example.crud.entity;
    opens com.example.crud.entity to javafx.fxml;
    exports com.example.crud.service;
    opens com.example.crud.service to javafx.fxml;
}