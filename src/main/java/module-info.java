module com.prameswaradev.manajemensurelklien {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.prameswaradev.manajemensurelklien to javafx.fxml;
    exports com.prameswaradev.manajemensurelklien;
    exports com.prameswaradev.manajemensurelklien.controller;
    opens com.prameswaradev.manajemensurelklien.controller to javafx.fxml;
    exports com.prameswaradev.manajemensurelklien.model;
    opens com.prameswaradev.manajemensurelklien.model to javafx.fxml;
}