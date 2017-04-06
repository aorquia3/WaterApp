package com.two_six_mafia.root.waterapp.Controller;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import com.two_six_mafia.root.waterapp.Exceptions.EmailFormatException;
import com.two_six_mafia.root.waterapp.Exceptions.NameFormatException;
import com.two_six_mafia.root.waterapp.Exceptions.PasswordFormatException;
import com.two_six_mafia.root.waterapp.Exceptions.UsernameFormatException;
import com.two_six_mafia.root.waterapp.Model.*;
import com.two_six_mafia.root.waterapp.R;

public class RegistrationActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private Spinner userType;
    private EditText nameField;
    private EditText emailField;
    private EditText usernameField;
    private EditText passwordField;
    private EditText confirmPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userType = (Spinner) findViewById(R.id.userType);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        usernameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);
        confirmPasswordField = (EditText) findViewById(R.id.confirmpassword);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, UserType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userType.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button cancel = (Button) findViewById(R.id.Cancel_Registration);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        Button register = (Button) findViewById(R.id.addPurityReport);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Sets the cancel button to go to the Welcome Page
     */
    protected void cancel() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Protects against entering blank registration
     */
    protected void register() {
        Person user;
        UserList users = UserList.getInstance();

        UserType type = (UserType) userType.getSelectedItem();
        switch (type) {
            case USER:
                user = new User();
                break;
            case WORKER:
                user = new Worker();
                break;
            case MANAGER:
                user = new Manager();
                break;
            case ADMIN:
                user = new Admin();
                break;
            default:
                user = new User();
                break;
        }

        try {
            user.setName(nameField.getText().toString());
            user.setUsername(usernameField.getText().toString());
            user.setEmail(emailField.getText().toString());
            user.setPassword(passwordField.getText().toString());
            user.setUserType(type);


            //Add the user to registered users
            users.addUser(user);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } catch(NameFormatException e) {
            nameField.setError(e.toString());
        } catch(EmailFormatException e) {
            emailField.setError(e.toString());
        } catch(UsernameFormatException e) {
            usernameField.setError(e.toString());
        } catch(PasswordFormatException e) {
            passwordField.setError(e.toString());
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Registration Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
