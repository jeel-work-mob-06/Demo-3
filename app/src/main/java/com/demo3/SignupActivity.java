package com.demo3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    EditText first_name,last_name,email,contact,password,retype;
    Button signup_btn;
    RadioGroup gender;
    RadioButton male,female;
    CheckBox signup_terms;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    SQLiteDatabase db;
    String sGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        String tableQuarry = "CREATE TABLE IF NOT EXISTS user(USERID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME VARCHAR(50),LASTNAME VARCHAR(50),EMAIL VARCHAR(50),CONTACT VARCHAR(50),PASSWORD VARCHAR(50),GENDER VARCHAR(10))";
        db.execSQL(tableQuarry);

        male = findViewById(R.id.gender_male);
        female = findViewById(R.id.gender_female);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        password = findViewById(R.id.password);
        retype = findViewById(R.id.retype);
        signup_btn = findViewById(R.id.signup_btn);
        gender = findViewById(R.id.gender);
        signup_terms = findViewById(R.id.signup_terms);

        // Access RadioButton's Text via RadioGroup's Click event

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                sGender = radioButton.getText().toString();
                Toast.makeText(SignupActivity.this,sGender, Toast.LENGTH_SHORT).show();
            }
        });

       /*
            accessed by click event of Radio Button
       male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupActivity.this, male.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupActivity.this, female.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first_name.getText().toString().trim().equals("")) {
                    first_name.setError("First Name Required");
                } else if (last_name.getText().toString().trim().equals("")) {
                    last_name.setError("Last Name Required");
                } else if (email.getText().toString().trim().equals("")) {
                    email.setError("Email Required");

                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Valid Email Id Required");
                }
                else if (contact.getText().toString().trim().length()<10) {
                    contact.setError("Contact Required");
                } else if (password.getText().toString().trim().equals("")) {
                    password.setError("Password Required");
                } else if (password.getText().toString().trim().length()<6) {
                    password.setError("Password must be 6 charecters");
                } else if (!retype.getText().toString().trim().equals(password.getText().toString().trim())) {
                    retype.setError("Password not matched");
                } else if (!signup_terms.isChecked()) {
                    Toast.makeText(SignupActivity.this, "Terms and Conditions Required", Toast.LENGTH_SHORT).show();
                }
                else if(gender.getCheckedRadioButtonId()==-1){
                    Toast.makeText(SignupActivity.this, "Gender Required", Toast.LENGTH_SHORT).show();
                    }

                else {
                    String selectQuarry = "SELECT * FROM user WHERE EMAIL='"+email.getText().toString()+"'";
                    Cursor cursor = db.rawQuery(selectQuarry,null);
                    if (cursor.getCount()>0){
                        Toast.makeText(SignupActivity.this, "Email Already Exist", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String insertQuarry = "INSERT INTO user(USERID,FIRSTNAME,LASTNAME,EMAIL,CONTACT,PASSWORD,GENDER) VALUES(NULL,'"+first_name.getText().toString()+"','"+last_name.getText().toString()+"','"+email.getText().toString()+"','"+contact.getText().toString()+"','"+password.getText().toString()+"','"+sGender+"')";
                        db.execSQL(insertQuarry);
                        Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}