package com.demo3;

import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    EditText first_name,last_name,email,contact,password,retype;
    Button submit,edit,logout;
    RadioGroup gender;
    RadioButton male,female;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    SQLiteDatabase db;
    String sGender;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        sp = getSharedPreferences(ConstantSp.PREF,MODE_PRIVATE);


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
        submit = findViewById(R.id.profile_submit);
        gender = findViewById(R.id.gender);
        edit = findViewById(R.id.profile_edit);
        logout = findViewById(R.id.profile_logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle("Logout");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Are you sure you want to logout?");

                builder.setPositiveButton("No", (dialog, which) -> {
                    dialog.dismiss();
                });

                builder.setNegativeButton("Yes", (dialog, which) -> {
                        sp.edit().clear().commit();
                        Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();


                });
                builder.setNeutralButton("Rate us", (dialog, which) -> {
                    Toast.makeText(ProfileActivity.this, "Rate us", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });



                builder.show();


            }
        });


        // Access RadioButton's Text via RadioGroup's Click event

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                sGender = radioButton.getText().toString();
                Toast.makeText(ProfileActivity.this,sGender, Toast.LENGTH_SHORT).show();
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

        submit.setOnClickListener(new View.OnClickListener() {
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
                }
                else if(gender.getCheckedRadioButtonId()==-1){
                    Toast.makeText(ProfileActivity.this, "Gender Required", Toast.LENGTH_SHORT).show();
                }

                else {
                   /* String selectQuarry = "SELECT * FROM user WHERE EMAIL='"+email.getText().toString()+"'";
                    Cursor cursor = db.rawQuery(selectQuarry,null);
                    if (cursor.getCount()>0){
                        Toast.makeText(ProfileActivity.this, "Email Already Exist", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        String insertQuarry = "INSERT INTO user(USERID,FIRSTNAME,LASTNAME,EMAIL,CONTACT,PASSWORD,GENDER) VALUES(NULL,'"+first_name.getText().toString()+"','"+last_name.getText().toString()+"','"+email.getText().toString()+"','"+contact.getText().toString()+"','"+password.getText().toString()+"','"+sGender+"')";
                        db.execSQL(insertQuarry);
                        Toast.makeText(ProfileActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    }*/
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData(true);
            }
        });

        setData(false);
    }

    private void setData(Boolean b) {

        if(b){
            retype.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
            edit.setVisibility(View.GONE);
        }
        else {
            retype.setVisibility(View.GONE);
            submit.setVisibility(View.GONE);
            edit.setVisibility(View.VISIBLE);

        }


        first_name.setEnabled(b);
        last_name.setEnabled(b);
        email.setEnabled(b);
        contact.setEnabled(b);
        password.setEnabled(b);
        retype.setEnabled(b);
        male.setEnabled(b);
        female.setEnabled(b);

        first_name.setText(sp.getString(ConstantSp.FirstName,""));
        last_name.setText(sp.getString(ConstantSp.LastName,""));
        email.setText(sp.getString(ConstantSp.Email,""));
        contact.setText(sp.getString(ConstantSp.Contact,""));
        password.setText(sp.getString(ConstantSp.Password,""));
        retype.setText(sp.getString(ConstantSp.Password,""));
        sGender = sp.getString(ConstantSp.Gender,"");
        if (sGender.equals("Male")){
            male.setChecked(true);
        }
        else {
            female.setChecked(true);
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String updateQuarry = "UPDATE user SET FIRSTNAME='"+first_name.getText().toString()+"',LASTNAME='"+last_name.getText().toString()+"',EMAIL='"+email.getText().toString()+"',CONTACT='"+contact.getText().toString()+"',PASSWORD='"+password.getText().toString()+"',GENDER='"+sGender+"' WHERE USERID='"+sp.getString(ConstantSp.UserId,"")+"'";
                db.execSQL(updateQuarry);
                Toast.makeText(ProfileActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}