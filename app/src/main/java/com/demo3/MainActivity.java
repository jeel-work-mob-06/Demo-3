package com.demo3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
        public static EditText email,password;
        TextView txt_fp;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    SQLiteDatabase db;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       //  Button login1;  this is limited in this method
        login = findViewById(R.id.main_btn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.name_pass);
        signup = findViewById(R.id.signup);
        txt_fp = findViewById(R.id.txt_fp);

        sp = getSharedPreferences(ConstantSp.PREF,MODE_PRIVATE);

        db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        String tableQuarry = "CREATE TABLE IF NOT EXISTS user(USERID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME VARCHAR(50),LASTNAME VARCHAR(50),EMAIL VARCHAR(50),CONTACT VARCHAR(50),PASSWORD VARCHAR(50),GENDER VARCHAR(10))";
        db.execSQL(tableQuarry);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().trim().equals("")) {
                    email.setError("Username Required");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Valid Email Id Required");
                }else if (password.getText().toString().trim().equals("")) {
                    password.setError("Password Required");
                } else if (password.getText().toString().trim().length()<6) {
                    password.setError("Password must be 6 charecters");
                } else {
                    String selectQuarry = "SELECT * FROM user WHERE EMAIL='"+email.getText().toString()+"' AND PASSWORD='"+password.getText().toString()+"'";
                    Cursor cursor = db.rawQuery(selectQuarry,null);
                    if (cursor.getCount()>0){

                        while (cursor.moveToNext()){

                            String sUserId = cursor.getString(0);
                            String sFirstName = cursor.getString(1);
                            String sLastName = cursor.getString(2);
                            String sEmail = cursor.getString(3);
                            String sContact = cursor.getString(4);
                            String sPassword = cursor.getString(5);
                            String sGender = cursor.getString(6);

                            sp.edit().putString(ConstantSp.UserId,sUserId).commit();
                            sp.edit().putString(ConstantSp.FirstName,sFirstName).commit();
                            sp.edit().putString(ConstantSp.LastName,sLastName).commit();
                            sp.edit().putString(ConstantSp.Email,sEmail).commit();
                            sp.edit().putString(ConstantSp.Contact,sContact).commit();
                            sp.edit().putString(ConstantSp.Password,sPassword).commit();
                            sp.edit().putString(ConstantSp.Gender,sGender).commit();



                            //Log.d("Response","User Id : "+sUserId+"\nFirst Name : "+sFirstName+"\nLast Name : "+sLastName+"\nEmail : "+sEmail+"\nContact : "+sContact+"\nPassword : "+sPassword+"\nGender : "+sGender);
                        }

                        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);


                        /*Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        *//*Snackbar.make(v, "Login Done", Snackbar.LENGTH_SHORT).show();*//*
                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("Email",email.getText().toString());
                        bundle.putString("Password",password.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);*/
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Email/Password", Toast.LENGTH_SHORT).show();
                    }



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