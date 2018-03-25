package com.example.mobivision.kajiapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    String user ="user";
    String pass ="user";

    private EditText memail_user, mpassword_user;
    Button mdaftar_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memail_user = (EditText) findViewById(R.id.email_user);
        mpassword_user = (EditText) findViewById(R.id.password_user);
        mdaftar_user = (Button) findViewById(R.id.daftar_user);
    }

    public void showSignIn(View view) {
        Intent a = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(a);
    }

    public void showSignUp(View view) {
        Intent a = new Intent(LoginActivity.this, Daftar.class);
        startActivity(a);
    }
}
