package com.example.androidlabs;

public class Messages {
    private boolean sent;
    private String text;

    public Messages() {
        text = new String();
        sent = true;
    }


    public Messages(String text, boolean sent) {
        this.text = text;
        this.sent = sent;
    }

    public String getMessage() {

        return this.text;

    }

    public boolean getBoolean() {

        return this.sent;

    }

}
