package com.two_six_mafia.root.waterapp.Exceptions;

/**
 * Created by Aaron on 4/4/2017.
 */

public class EmailFormatException extends Exception {
    private String message;
    public EmailFormatException(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
