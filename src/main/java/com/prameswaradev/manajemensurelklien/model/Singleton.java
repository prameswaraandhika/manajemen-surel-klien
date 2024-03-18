package com.prameswaradev.manajemensurelklien.model;

public class Singleton {

    private Singleton(){}
    private static final Singleton instance = new Singleton();
    public static Singleton getIntance(){
        return instance;
    }


    private EmailMessageBean message;
    public EmailMessageBean getMessage() {
        return message;
    }

    public void setMessage(EmailMessageBean message) {
        this.message = message;
    }


}
