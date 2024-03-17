package com.prameswaradev.manajemensurelklien.controller;

import com.prameswaradev.manajemensurelklien.model.EmailMessageBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TreeView<String> emailFoldersTreeView;
    private TreeItem<String> root = new TreeItem<>();

    @FXML
    private TableView<EmailMessageBean> emailTableView;

    @FXML
    private TableColumn<EmailMessageBean, String> subjectCol;

    @FXML
    private TableColumn<EmailMessageBean, String> senderCol;

    @FXML
    private TableColumn<EmailMessageBean, String> sizeCol;


    @FXML
    private Button Button1;

    @FXML
    private WebView messageRenderer;

    @FXML
    private void button1Action(ActionEvent actionEvent){
        System.out.println("Button1 clicked");
    }

    final ObservableList<EmailMessageBean> data = FXCollections.observableArrayList(
            new EmailMessageBean("Hello gais 1", "any@gmail.com", 11110000),
            new EmailMessageBean("Hello gais 2", "ano@gmail.com", 2000011),
            new EmailMessageBean("Hello gais 3", "ani@gmail.com", 3000220),
            new EmailMessageBean("Hello gais 4", "anu@gmail.com", 4200)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageRenderer.getEngine().loadContent("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mollis lorem venenatis euismod molestie. Etiam suscipit metus sit amet molestie rhoncus. Donec metus tortor, varius vel lorem sollicitudin, ullamcorper gravida enim. Sed rhoncus egestas enim, et condimentum nibh placerat non. String pharetra ante vitae tellus efficitur hendrerit. Etiam rhoncus porta malesuada. Nullam aliquam leo ut feugiat pretium. Pellentesque bibendum purus eget diam rutrum condimentum. Ut interdum, metus vitae fermentum rutrum, nulla dui tempor enim, ut egestas quam elit sed sapien. Aliquam lacinia rhoncus nibh sit amet aliquet. Pellentesque turpis arcu, ultricies aliquet sodales nec, consectetur eget nulla. Maecenas posuere dignissim pellentesque.\n" +
                "\n </html>");
        subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Sender"));
        senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Subject"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Size"));
        emailTableView.setItems(data);

        sizeCol.setComparator(new Comparator<String>() {
            Integer i1, i2;
            @Override
            public int compare(String o1, String o2) {
                i1 = EmailMessageBean.formattedValues.get(o1);
                i2 = EmailMessageBean.formattedValues.get(o2);
                return i1.compareTo(i2);
            }
        });
        emailFoldersTreeView.setRoot(root);

        root.setValue("example@yahoo.com");
        root.setGraphic(resolveIcon(root.getValue()));

        TreeItem<String> Inbox = new TreeItem<String>("Inbox", resolveIcon("Inbox"));
        TreeItem<String> Sent = new TreeItem<String>("Sent", resolveIcon("Sent"));
        TreeItem<String> Subitem1 = new TreeItem<String>("Subitem1", resolveIcon("Subitem1"));
        TreeItem<String> Subitem2 = new TreeItem<String>("Subitem2",resolveIcon("Subitem2"));
        Sent.getChildren().addAll(Subitem1, Subitem2);
        TreeItem<String> Spam = new TreeItem<String>("Spam", resolveIcon("Spam"));
        TreeItem<String> Trash = new TreeItem<String>("Trash", resolveIcon("Trash"));

        root.getChildren().addAll(Inbox, Sent, Spam, Trash);
        root.setExpanded(true);
    }

    private Node resolveIcon(String treeItemValue) {
        String lowerCaseTreeItemValue = treeItemValue.toLowerCase();
        ImageView returnIcon;
        try {
            if (lowerCaseTreeItemValue.contains("inbox")) {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/inbox.png")));
            } else if (lowerCaseTreeItemValue.contains("sent")) {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/sent2.png")));
            } else if (lowerCaseTreeItemValue.contains("spam")) {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/spam.png")));
            } else if (lowerCaseTreeItemValue.contains("@")) {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/email.png")));
            } else {
                returnIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/folder.png")));
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid image location!!!");
            e.printStackTrace();
            returnIcon = new ImageView();
        }

        returnIcon.setFitHeight(16);
        returnIcon.setFitWidth(16);

        return returnIcon;
    }
}
