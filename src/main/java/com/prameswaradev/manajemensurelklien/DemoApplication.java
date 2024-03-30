package com.prameswaradev.manajemensurelklien;

import com.prameswaradev.manajemensurelklien.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class DemoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = ViewFactory.defaultFactory;
        Scene scene = viewFactory.getMainScene();
        stage.setTitle("SIMSUR");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}