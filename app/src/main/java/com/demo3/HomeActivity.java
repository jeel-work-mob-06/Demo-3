package com.demo3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    TextView email,password;
    RadioButton male,female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        email = findViewById(R.id.home_email);
        password = findViewById(R.id.home_pass);
       /*
         Saprate variable for Radio button
        male = findViewById(R.id.radio_male);
        female = findViewById(R.id.radio_female);*/

        // RadioGroup variable crated for initalize Radio group
        RadioGroup gender;

        // Checkbox variables
        CheckBox cricket,hockey,chess,football;

        email.setText(MainActivity.email.getText().toString());
        password.setText(MainActivity.password.getText().toString());

        Bundle bundle = getIntent().getExtras();
        email.setText(bundle.getString("Email"));
        password.setText(bundle.getString("Password"));

        // Radio Click Event via saprate id of radio buttion

        /*male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, male.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, female.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/

        // store Radiobutton id in variable
        gender = findViewById(R.id.radio_gender);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int i) {
                RadioButton rb = findViewById(i);
                Toast.makeText(HomeActivity.this, rb.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        // storing id in a checkbox variable

        cricket = findViewById(R.id.check_cric);
        football = findViewById(R.id.check_foot);
        chess = findViewById(R.id.check_chess);
        hockey = findViewById(R.id.check_hockey);

        /*cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cricket.isChecked()) {

                }
            }
        });*/
        /*
         Saprate code to display hobby via saprate checkbox
        cricket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean b) {

                if (b) {
                    Toast.makeText(HomeActivity.this, cricket.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        chess.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean b) {

                if(b){
                Toast.makeText(HomeActivity.this,chess.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        hockey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean b) {

                if(b) {
                    Toast.makeText(HomeActivity.this, hockey.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        football.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean b) {

                if(b) {
                    Toast.makeText(HomeActivity.this, football.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        // Button refrence for hobby
        Button btn_hobby;
        btn_hobby = findViewById(R.id.btn_hobby);

        btn_hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                if(cricket.isChecked()){
                    // Toast.makeText(HomeActivity.this, cricket.getText().toString(), Toast.LENGTH_SHORT).show();
                    sb.append(cricket.getText().toString()+"\n");
                }
                if (chess.isChecked()) {
                    //Toast.makeText(HomeActivity.this, chess.getText().toString(), Toast.LENGTH_SHORT).show();
                    sb.append(chess.getText().toString()+"\n");
                }
                if (football.isChecked()) {
                    //Toast.makeText(HomeActivity.this, football.getText().toString(), Toast.LENGTH_SHORT).show();
                    sb.append(football.getText().toString()+"\n");
                }
                if (hockey.isChecked()){
                    //Toast.makeText(HomeActivity.this, hockey.getText().toString(), Toast.LENGTH_SHORT).show();
                    sb.append(hockey.getText().toString()+"\n");
                }
                Toast.makeText(HomeActivity.this, sb.toString().trim() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}