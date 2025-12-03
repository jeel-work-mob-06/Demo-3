package com.demo3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

        Button login,signup; // can be access in whole file
        EditText username,password;
        TextView txt_fp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       //  Button login1;  this is limited in this method
        login = findViewById(R.id.main_btn);
        username = findViewById(R.id.name_user);
        password = findViewById(R.id.name_pass);
        signup = findViewById(R.id.signup);
        txt_fp = findViewById(R.id.txt_fp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().trim().equals("")) {
                    username.setError("Username Required");
                } else if (password.getText().toString().trim().equals("")) {
                    password.setError("Password Required");
                } else if (password.getText().toString().trim().length()<6) {
                    password.setError("Password must be 6 charecters");
                } else {
                    System.out.println("Login Succesfully");
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "Login Done", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        signup.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Signup Button Clicked", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        txt_fp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v,"Forgot Password Clicked",Snackbar.LENGTH_LONG).show();
                return true;
            }
        });
    }
}