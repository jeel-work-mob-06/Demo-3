package com.demo3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    EditText first_name,last_name,email,contact,password,retype;
    Button signup_btn;
    RadioGroup gender;
    CheckBox signup_terms;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        password = findViewById(R.id.password);
        retype = findViewById(R.id.retype);
        signup_btn = findViewById(R.id.signup_btn);
        gender = findViewById(R.id.gender);
        signup_terms = findViewById(R.id.signup_terms);

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
                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}