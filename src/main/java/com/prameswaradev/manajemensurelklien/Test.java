package com.prameswaradev.manajemensurelklien;

import com.prameswaradev.manajemensurelklien.model.EmailMessageBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test {
    public static void main(String[] args) {
        final EmailAccountBean emailAccountBean = new EmailAccountBean("pramesdev05@gmail.com", "ykfu ljso lybd vlgn");

        ObservableList<EmailMessageBean> data = FXCollections.observableArrayList();
        emailAccountBean.addEmailsToData(data);
    }
}
