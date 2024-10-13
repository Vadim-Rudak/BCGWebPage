package com.bears.webPage.domain;

public class Message {

    private String UserGetMessage;
    private String TextMessage;

    public Message(String userGetMessage, String textMessage) {
        UserGetMessage = userGetMessage;
        TextMessage = textMessage;
    }

    public String getUserGetMessage() {
        return UserGetMessage;
    }

    public void setUserGetMessage(String userGetMessage) {
        UserGetMessage = userGetMessage;
    }

    public String getTextMessage() {
        return TextMessage;
    }

    public void setTextMessage(String textMessage) {
        TextMessage = textMessage;
    }
}
