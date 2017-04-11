package com.two_six_mafia.root.waterapp;
import com.two_six_mafia.root.waterapp.Exceptions.PasswordFormatException;
import com.two_six_mafia.root.waterapp.Model.Person;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aaron on 4/10/17.
 */

public class PasswordValidationTest {
    Person buster;

    @Before
    public void setup() throws Exception {
        buster = new Person();
        buster.setUsername("buster1!");
    }

    @Test(expected=PasswordFormatException.class)
    //Try a password that is too short.
    public void testPasswordTooShortFails() throws Exception {
        buster.setPassword("R1@");
    }
    @Test(expected=PasswordFormatException.class)
    //Try a password that is the same as the username.
    public void testPasswordContainsUsernameFails() throws Exception {
        buster.setPassword("buster1!");
    }

    @Test(expected=PasswordFormatException.class)
    //Try a password that has no numbers
    public void testPasswordNoNumberFails() throws Exception {
        buster.setPassword("R@ndom");
    }

    @Test(expected=PasswordFormatException.class)
    //Try a password with no special characters
    public void testPasswordNoSpecialCharacterFails() throws Exception {
        buster.setPassword("Rand0m");
    }

    @Test
    //Try a good password
    public void testGoodPassword() throws Exception {
        buster.setPassword("R@nd0m");
    }
}
