package com.example.login_app_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView email;
    EditText pass, repass;
    Button confrim;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        email = (TextView) findViewById(R.id.email_reset);
        pass = (EditText) findViewById(R.id.password_reset);
        repass = (EditText) findViewById(R.id.repassword_reset);
        confrim = (Button) findViewById(R.id.btnconfrim);
        DB = new DatabaseHelper(this);

        Intent intent = getIntent();
        email.setText(intent.getStringExtra("Email"));

        confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = email.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();
                if (password.equals(repassword)) {

                    Boolean checkpasswordupdate = DB.updateUser(user,password);

                    if (checkpasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(ResetActivity.this, "Password Update Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "Password Not Update Success", Toast.LENGTH_SHORT).show();
                    }

                } else
                {
                    Toast.makeText(ResetActivity.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}