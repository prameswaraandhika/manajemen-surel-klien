package com.prameswaradev.manajemensurelklien;

import com.prameswaradev.manajemensurelklien.model.EmailMessageBean;
import javafx.collections.ObservableList;


import java.util.Properties;
import javax.mail.*;
import javax.mail.Flags.Flag;

public class EmailAccountBean {
    private String email;
    private String password;
    private Properties properties;
    private Store store;
    private Session session;
    private Integer loginState = EmailConstants.LOGIN_STATE_NOT_READY;

    public EmailAccountBean(String email, String password) {
        this.email = email;
        this.password = password;
        properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.auth", "true");
        properties.put("incomingHost", "imap.gmail.com");
        properties.put("outgoingHost", "smtp.gmail.com");

        Authenticator auth = new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(email, password);
            }
        };

        //Connecting:
        session = Session.getInstance(properties, auth);
        try {
            this.store = session.getStore();
            store.connect(properties.getProperty("incomingHost"), email, password);
            System.out.println("EmailAccountBean constructed succesufully!!!");
            loginState = EmailConstants.LOGIN_STATE_SUCCEDED;
        } catch (Exception e) {
            e.printStackTrace();
            loginState = EmailConstants.LOGIN_STATE_FAILED_BY_CREDENTIALS;
        }
    }

    public void addEmailsToData(ObservableList<EmailMessageBean> data){
        try {
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            for(int i = folder.getMessageCount(); i > 0; i--){

                Message message = folder.getMessage(i);
                EmailMessageBean messageBean = new EmailMessageBean(message.getSubject(),
                        message.getFrom()[0].toString(),
                        message.getSize(),
                        "",
                        message.getFlags().contains(Flags.Flag.SEEN));
                System.out.println("Got: " + messageBean);
                data.add(messageBean);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getLoginState() {
        return loginState;
    }

    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }
}
