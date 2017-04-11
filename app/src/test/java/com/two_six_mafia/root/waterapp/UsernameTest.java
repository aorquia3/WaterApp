package com.two_six_mafia.root.waterapp;

import com.two_six_mafia.root.waterapp.Exceptions.UsernameFormatException;
import com.two_six_mafia.root.waterapp.Model.Person;
import com.two_six_mafia.root.waterapp.Model.UserList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the username function in class person
 * Created by rjara on 4/10/2017.
 */

public class UsernameTest {
    Person newPerson = new Person();
    UserList userList = UserList.getInstance();
    @Test(expected=UsernameFormatException.class)
    //Try a username that is too short
    public void usernameTooShort() throws Exception {
        newPerson.setUsername("d");
    }
    @Test(expected=UsernameFormatException.class)
    //Try a username that is already being used
    public void usernameTaken() throws Exception {
        newPerson.setUsername("Pilot");
        userList.addUser(newPerson);
        newPerson.setUsername("Pilot");
    }
    @Test(expected=UsernameFormatException.class)
    //Try a username that contains cursing
    public void usernameCursing() throws Exception {
        newPerson.setUsername("fuckBoy69");
    }
    @Test
    //Enter a valid username
    public void usernameValid() throws Exception {
        newPerson.setUsername("Pablo55");
    }

}
