package com.example.android.resturant;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthActivity extends AppCompatActivity {
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);
                int user = username.getText().toString().trim().length();
                int pass = password.getText().toString().trim().length();

                if (user==0 || pass ==0) {
                    if (user == 0) {
                        username.setError("This field needs to be filled");
                    }
                    if (pass == 0) {
                        password.setError("This field needs to be filled");
                    }
                } else {
                    Intent intent = new Intent(AuthActivity.this, ViewOrderSummaryActivity.class);
                    startActivity(intent);
                    Snackbar.make(view, "Login Successful", Snackbar.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
