package com.prameswaradev.manajemensurelklien.controller;

import com.prameswaradev.manajemensurelklien.model.EmailMessageBean;
import com.prameswaradev.manajemensurelklien.view.ViewFactory;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmailDetailsController extends AbstractController implements Initializable {


    @FXML
    private WebView webView;

    @FXML
    private Label subjectLabel;

    @FXML
    private Label SenderLabel;

    public EmailDetailsController(ModelAccess modelAccess) {
        super(modelAccess);
    }

    @FXML
    void ilegalOpperationAction() throws Exception {
        ViewFactory view= new ViewFactory();
        Scene mainScene = view.getMainScene();
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EmailMessageBean selectedMessage = getModelAccess().getSelectedMessage();

//        singleton = Singleton.getIntance();
        System.out.println("EmailDetailsController initialized");

        subjectLabel.setText("Subject: " + selectedMessage.getSubject());
        SenderLabel.setText("Subject: " + selectedMessage.getSender());
        webView.getEngine().loadContent(selectedMessage.getContent());


    }
}
