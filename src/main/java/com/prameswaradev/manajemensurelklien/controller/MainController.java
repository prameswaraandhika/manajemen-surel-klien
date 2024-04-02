package com.prameswaradev.manajemensurelklien.controller;

import com.prameswaradev.manajemensurelklien.model.DummyDataEmail;
import com.prameswaradev.manajemensurelklien.model.EmailMessageBean;
import com.prameswaradev.manajemensurelklien.model.folder.EmailFolderBean;
import com.prameswaradev.manajemensurelklien.model.table.BoldableRowFactory;
import com.prameswaradev.manajemensurelklien.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MainController extends AbstractController implements Initializable {


    @FXML
    private TreeView<String> emailFoldersTreeView;
    private TreeItem<String> root = new TreeItem<>();
    private MenuItem showDetails = new MenuItem("Show details");

    private DummyDataEmail dummyDataEmail = new DummyDataEmail();


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
    private Button unread;

    @FXML
    private WebView messageRenderer;

    public MainController(ModelAccess modelAccess) {
        super(modelAccess);
    }

    @FXML
    private void button1Action(ActionEvent actionEvent){
        System.out.println("Button1 clicked");
    }

    @FXML
    private void unreadAction(ActionEvent actionEvent){
        EmailMessageBean message = getModelAccess().getSelectedMessage();
        if(message != null){
            boolean value = message.isRead();
            message.setRead(!value);
            EmailFolderBean<String> selectedFolder = getModelAccess().getSelectedFolder();
            if(selectedFolder != null){
                if(value){
                    selectedFolder.incrementUnreadMessagesCount(1);
                }else{
                    selectedFolder.decrementUnreadMessagesCount();
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        messageRenderer.getEngine().loadContent("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc mollis lorem venenatis euismod molestie. Etiam suscipit metus sit amet molestie rhoncus. Donec metus tortor, varius vel lorem sollicitudin, ullamcorper gravida enim. Sed rhoncus egestas enim, et condimentum nibh placerat non. String pharetra ante vitae tellus efficitur hendrerit. Etiam rhoncus porta malesuada. Nullam aliquam leo ut feugiat pretium. Pellentesque bibendum purus eget diam rutrum condimentum. Ut interdum, metus vitae fermentum rutrum, nulla dui tempor enim, ut egestas quam elit sed sapien. Aliquam lacinia rhoncus nibh sit amet aliquet. Pellentesque turpis arcu, ultricies aliquet sodales nec, consectetur eget nulla. Maecenas posuere dignissim pellentesque.\n" +
//                "\n </html>");
        emailTableView.setRowFactory(e -> new BoldableRowFactory<>());
        var viewFactory = ViewFactory.defaultFactory;
        subjectCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Sender"));
        senderCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Subject"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<EmailMessageBean, String>("Size"));
//        emailTableView.setItems(data);

        sizeCol.setComparator(new Comparator<String>() {
            Integer i1, i2;
            @Override
            public int compare(String o1, String o2) {
                i1 = EmailMessageBean.formattedValues.get(o1);
                i2 = EmailMessageBean.formattedValues.get(o2);
                return i1.compareTo(i2);
            }
        });

        EmailFolderBean<String> root = new EmailFolderBean<>("");
        emailFoldersTreeView.setRoot(root);
        emailFoldersTreeView.setShowRoot(false);

        EmailFolderBean<String> barosanu = new EmailFolderBean<>("example@yahoo.com");
        root.getChildren().add(barosanu);
        emailFoldersTreeView.setRoot(root);
//        root.setValue("example@yahoo.com");
//        root.setGraphic(viewFactory.resolveIcon(root.getValue()));
        EmailFolderBean<String> Inbox = new EmailFolderBean<>("Inbox", "CompleteInbox");
        EmailFolderBean<String> Sent = new EmailFolderBean<>("Sent", "CompleteSent");
        Sent.getChildren().add(new EmailFolderBean<>("Subfolder1", "SubFolder1Complete"));
        Sent.getChildren().add(new EmailFolderBean<>("Subfolder2", "SubFolder1Complete2"));
        EmailFolderBean<String> Spam = new EmailFolderBean<>("Spam", "CompleteSpam");

        barosanu.getChildren().addAll(Inbox, Sent, Spam);

        Inbox.getData().addAll(DummyDataEmail.Inbox);
        Sent.getData().addAll(DummyDataEmail.Sent);
        Spam.getData().addAll(DummyDataEmail.Spam);



        emailTableView.setContextMenu(new ContextMenu(showDetails));
        emailFoldersTreeView.setOnMouseClicked(e ->{
            EmailFolderBean<String> item = (EmailFolderBean<String>)emailFoldersTreeView.getSelectionModel().getSelectedItem();
            if(item != null && !item.isTopElement()){
                emailTableView.setItems(item.getData());
                getModelAccess().setSelectedFolder(item);
                //clear the selected message:
                getModelAccess().setSelectedMessage(null);
            }
        });
        emailTableView.setOnMouseClicked(e ->{
            var message = emailTableView.getSelectionModel().getSelectedItem();
            if (message != null){
                messageRenderer.getEngine().loadContent(message.getContent());
                getModelAccess().setSelectedMessage(message);
                messageRenderer.getEngine().loadContent(message.getContent());
//                singleton.setMessage(message);
            }
        });
        showDetails.setOnAction(e -> {
            Scene scene = viewFactory.getEmailDetailScene();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        });
    }


}
