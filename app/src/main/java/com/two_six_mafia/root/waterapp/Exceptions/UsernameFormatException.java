package com.two_six_mafia.root.waterapp.Exceptions;

/**
 * Created by Aaron on 4/4/2017.
 */

public class UsernameFormatException extends Exception {
    private String message;
    public UsernameFormatException(String s) {
        message = s;
    }

    @Override
    public String toString() {
        return message;
    }
}
