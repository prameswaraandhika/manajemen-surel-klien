package com.prameswaradev.manajemensurelklien.controller;

import com.prameswaradev.manajemensurelklien.model.EmailMessageBean;
import com.prameswaradev.manajemensurelklien.model.folder.EmailFolderBean;


public class ModelAccess {
    private EmailMessageBean selectedMessage;
    private EmailFolderBean<String> selectedFolder;


    public EmailMessageBean getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(EmailMessageBean selectedMessage) {
        this.selectedMessage = selectedMessage;
    }

    public void setSelectedFolder(EmailFolderBean<String> selectedFolder) {
        this.selectedFolder = selectedFolder;
    }


    public EmailFolderBean<String> getSelectedFolder() {
        return selectedFolder;
    }
}
