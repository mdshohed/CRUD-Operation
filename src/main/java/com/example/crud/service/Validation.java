package com.example.crud.service;

import javafx.scene.control.Alert;

public class Validation {
    public void alert1(String s1, String s2){
        Alert s = new Alert(Alert.AlertType.CONFIRMATION);
        s.setTitle(s1);
        s.setContentText(s2);
        s.show();
    }
    public void alert2(String s1, String s2){
        Alert s = new Alert(Alert.AlertType.ERROR);
        s.setTitle(s1);
        s.setContentText(s2);
        s.show();
    }
    public void alert3(String s1, String s2){
        Alert s = new Alert(Alert.AlertType.WARNING);
        s.setTitle(s1);
        s.setContentText(s2);
        s.show();
    }
}
