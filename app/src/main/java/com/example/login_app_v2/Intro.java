package com.example.login_app_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro extends AppCompatActivity {
    Button btnSignIn,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


    }

    public void go_SignIn(View view){

        btnSignIn = findViewById(R.id.btnSignIn);
        Intent intent = new Intent(Intro.this,LoginActivity.class);
        startActivity(intent);

    }

    public void go_SignUp(View view){
        btnSignUp = findViewById(R.id.btnSignUp);
        Intent intent = new Intent(Intro.this,RegisterActivity.class);
        startActivity(intent);

    }
}