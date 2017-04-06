package com.two_six_mafia.root.waterapp.Exceptions;

/**
 * Created by Aaron on 4/4/2017.
 */

public class PasswordFormatException extends Exception {
    public String message;
    public PasswordFormatException(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
