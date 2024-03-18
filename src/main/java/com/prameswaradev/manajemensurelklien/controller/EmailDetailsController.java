package com.prameswaradev.manajemensurelklien.controller;

import com.prameswaradev.manajemensurelklien.model.Singleton;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailDetailsController implements Initializable {

    private Singleton singleton;

    @FXML
    private WebView webView;

    @FXML
    private Label subjectLabel;

    @FXML
    private Label SenderLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        singleton = Singleton.getIntance();
        System.out.println("EmailDetailsController initialized");

        subjectLabel.setText("Subject: " + singleton.getMessage().getSubject());
        SenderLabel.setText("Subject: " + singleton.getMessage().getSender());

        webView.getEngine().loadContent(singleton.getMessage().getContent());


    }
}
