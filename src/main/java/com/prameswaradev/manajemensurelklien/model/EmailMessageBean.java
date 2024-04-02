package com.prameswaradev.manajemensurelklien.model;

import com.prameswaradev.manajemensurelklien.model.table.AbstractTableItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;
import java.util.Map;

public class EmailMessageBean extends AbstractTableItem {
    public static Map<String, Integer> formattedValues = new HashMap<>();
    private SimpleStringProperty sender;
    private SimpleStringProperty subject;
    private SimpleStringProperty size;
    private String content;

    public EmailMessageBean(String sender, String subject, Integer size, String content, boolean isRead) {
        super(isRead);
        this.sender = new SimpleStringProperty(sender);
        this.subject = new SimpleStringProperty(subject);
        this.size = new SimpleStringProperty(formatSize(size));
        this.content = content;
    }


    public String getSender() {
        return sender.get();
    }

    public SimpleStringProperty senderProperty() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender.set(sender);
    }

    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String formatSize(Integer size){
        String returnValue;
        if(size<= 0){
            returnValue =  "0";}

        else if(size<1024){
            returnValue = size + " B";
        }
        else if(size < 1048576){
            returnValue = size/1024 + " KB";
        }else{
            returnValue = size/1048576 + " MB";
        }
        formattedValues.put(returnValue, size);
        return returnValue;
    }

    @Override
    public String toString() {
        return "EmailMessageBean{" +
                "sender=" + sender +
                ", subject=" + subject +
                ", size=" + size +
                ", content='" + content + '\'' +
                '}';
    }
}
