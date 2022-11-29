package com.example.login_app_v2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;


    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;

    private Button btnRegister;
    private TextView tvLogin;

    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {

        username =  findViewById(R.id.etUsername);
        email = findViewById(R.id.etEmail);
        password =  findViewById(R.id.etPassword);
        confirmPassword =  findViewById(R.id.etConfirmPassword);


        btnRegister = findViewById(R.id.btnRegister);

        tvLogin = findViewById(R.id.tvLogin);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnRegister:
                postDataToSQLite();
                break;

            case R.id.tvLogin:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {

        if (!databaseHelper.checkUser(email.getText().toString().trim())) {

            user.setUsername(username.getText().toString().trim());
            user.setEmail(email.getText().toString().trim());
            user.setPassword(password.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            emptyInputEditText();
            Intent intentRegister = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intentRegister);
            Toast.makeText(RegisterActivity.this, "Success ", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(RegisterActivity.this, "cannot add user ", Toast.LENGTH_LONG).show();
            // Snack Bar to show error message that record already exists
        }


    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        username.setText(null);
        email.setText(null);
        password.setText(null);
        confirmPassword.setText(null);
    }
}