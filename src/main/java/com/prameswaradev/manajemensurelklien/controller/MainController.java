package com.prameswaradev.manajemensurelklien.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private Button Button1;

    @FXML
    private void button1Action(ActionEvent actionEvent){
        System.out.println("Button1 clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("The document loaded..");
    }
}
