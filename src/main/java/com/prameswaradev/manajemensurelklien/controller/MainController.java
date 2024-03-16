package com.prameswaradev.manajemensurelklien.controller;

import com.prameswaradev.manajemensurelklien.EmailMessageBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<EmailMessageBean> emailTableView;

    @FXML
    private TableColumn<EmailMessageBean, String> subjectCol;

    @FXML
    private TableColumn<EmailMessageBean, String> senderCol;

    @FXML
    private TableColumn<EmailMessageBean, Integer> sizeCol;


    @FXML
    private Button Button1;

    @FXML
    private WebView messageRenderer;

    @FXML
    private void button1Action(ActionEvent actionEvent){
        System.out.println("Button1 clicked");
    }

    final ObservableList<EmailMessageBean> data = FXCollections.observableArrayList(
            new EmailMessageBean("Hello gais 1", "any@gmail.com", 10000),
            new EmailMessageBean("Hello gais 2", "ano@gmail.com", 20000),
            new EmailMessageBean("Hello gais 3", "ani@gmail.com", 30000),
            new EmailMessageBean("Hello gais 4", "anu@gmail.com", 40000)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageRenderer.getEngine().loadContent("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mollis lorem venenatis euismod molestie. Etiam suscipit metus sit amet molestie rhoncus. Donec metus tortor, varius vel lorem sollicitudin, ullamcorper gravida enim. Sed rhoncus egestas enim, et condimentum nibh placerat non. Integer pharetra ante vitae tellus efficitur hendrerit. Etiam rhoncus porta malesuada. Nullam aliquam leo ut feugiat pretium. Pellentesque bibendum purus eget diam rutrum condimentum. Ut interdum, metus vitae fermentum rutrum, nulla dui tempor enim, ut egestas quam elit sed sapien. Aliquam lacinia rhoncus nibh sit amet aliquet. Pellentesque turpis arcu, ultricies aliquet sodales nec, consectetur eget nulla. Maecenas posuere dignissim pellentesque.\n" +
                "\n </html>");
        subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Sender"));
        senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Subject"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, Integer>("Size"));
        emailTableView.setItems(data);
        System.out.println("The document loaded..");
    }
}
