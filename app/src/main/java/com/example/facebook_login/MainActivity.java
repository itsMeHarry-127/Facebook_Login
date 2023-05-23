package com.example.facebook_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtAccount;
    EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtAccount = (EditText)  findViewById(R.id.txtAccount);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        if (getIntent().getBooleanExtra("EXIT",false)) {
            finish();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        txtAccount.setText("");
        txtPassword.setText("");
    }

    public void onLogin(View view) {
            if (txtAccount.getText().toString().equals("admin") && txtPassword.getText().toString().equals("123456") ) {
                Toast.makeText(MainActivity.this, "You have logged in!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login fail!", Toast.LENGTH_SHORT).show();
            }
    }

    public void openHomePage() {
        Intent intent = new Intent(this, HomeActitvity.class);
        startActivity(intent);
    }


}