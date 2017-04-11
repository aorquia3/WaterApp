package com.two_six_mafia.root.waterapp.Exceptions;


/**
 * Checking the emails
 */
public class EmailFormatException extends Exception {
    private final String message;
    public EmailFormatException(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
