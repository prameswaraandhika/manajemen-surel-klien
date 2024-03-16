package com.prameswaradev.manajemensurelklien.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    @FXML
    private Button Button1;

    @FXML
    private WebView messageRenderer;

    @FXML
    private void button1Action(ActionEvent actionEvent){
        System.out.println("Button1 clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageRenderer.getEngine().loadContent("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mollis lorem venenatis euismod molestie. Etiam suscipit metus sit amet molestie rhoncus. Donec metus tortor, varius vel lorem sollicitudin, ullamcorper gravida enim. Sed rhoncus egestas enim, et condimentum nibh placerat non. Integer pharetra ante vitae tellus efficitur hendrerit. Etiam rhoncus porta malesuada. Nullam aliquam leo ut feugiat pretium. Pellentesque bibendum purus eget diam rutrum condimentum. Ut interdum, metus vitae fermentum rutrum, nulla dui tempor enim, ut egestas quam elit sed sapien. Aliquam lacinia rhoncus nibh sit amet aliquet. Pellentesque turpis arcu, ultricies aliquet sodales nec, consectetur eget nulla. Maecenas posuere dignissim pellentesque.\n" +
                "\n </html>");
        System.out.println("The document loaded..");
    }
}
