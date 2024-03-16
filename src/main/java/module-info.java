module com.prameswaradev.manajemensurelklien {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.prameswaradev.manajemensurelklien to javafx.fxml;
    exports com.prameswaradev.manajemensurelklien;
}