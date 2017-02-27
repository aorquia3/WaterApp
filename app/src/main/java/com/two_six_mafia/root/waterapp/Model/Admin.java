package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by rjara on 2/22/2017.
 */

public class Admin extends Person {
    /**
     *
     * @return true if the users account has been deleted.
     */
    public boolean deleteAccount() {
        return true;
    }

    /**
     *
     * @return true if the user has successfully been banned.
     */
    public boolean banUser() {
        return true;
    }

    /**
     *
     * @return true if the user has been unblocked
     */
    public boolean unblockUser() {
        return true;
    }
}
