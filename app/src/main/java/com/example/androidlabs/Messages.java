package com.example.androidlabs;

public class Messages {
    private boolean sent;
    private String text;
    private long id;


    public Messages() {
        text = new String();
        sent = true;
        id = 0;

    }


    public Messages(String text, boolean sent, long id) {
        this.text = text;
        this.sent = sent;
        this.id = id;
    }

    public String getMessage() {

        return this.text;

    }

    public boolean getBoolean() {

        return this.sent;

    }
    public long getId(){

        return this.id;
    }

}
