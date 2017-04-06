package com.two_six_mafia.root.waterapp.Exceptions;

/**
 * Created by Aaron on 4/4/2017.
 */

public class NameFormatException extends Exception {
    private final String message;
    public NameFormatException(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
