package com.techelevator.model;

public class Message {
    private int messageId;
    private String messageBody;


    public Message() {}

    public Message(int messageId, String messageText, String url) {
        this.messageId = messageId;
        this.messageBody = messageText;

    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
