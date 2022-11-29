package com.example.login_app_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    EditText email;
    Button reset;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        email = (EditText) findViewById(R.id.etEmail);
        reset = (Button) findViewById(R.id.btnreset);
        DB = new DatabaseHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString();

                Boolean checkuser = DB.checkUser(user);
                if(checkuser==true)
                {
                    Intent intent  =new Intent(getApplicationContext(), ResetActivity.class);
                    intent.putExtra("Email", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(PasswordActivity.this, "user does not exists", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}