package com.demo3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase db;
    SharedPreferences sp;

    ArrayList<CustomUserList> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_list);

        sp = getSharedPreferences(ConstantSp.PREF,MODE_PRIVATE);

        listView = findViewById(R.id.custom_lst);
        db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);
        String tableQuarry = "CREATE TABLE IF NOT EXISTS user(USERID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME VARCHAR(50),LASTNAME VARCHAR(50),EMAIL VARCHAR(50),CONTACT VARCHAR(50),PASSWORD VARCHAR(50),GENDER VARCHAR(10))";
        db.execSQL(tableQuarry);

        String selectQuarry = "SELECT * FROM user ORDER BY USERID DESC";
        Cursor cursor = db.rawQuery(selectQuarry,null);
        if (cursor.getCount()>0){

            arrayList = new ArrayList<>();

            while (cursor.moveToNext()){

                String sUserId = cursor.getString(0);
                String sFirstName = cursor.getString(1);
                String sLastName = cursor.getString(2);
                String sEmail = cursor.getString(3);
                String sContact = cursor.getString(4);
                String sPassword = cursor.getString(5);
                String sGender = cursor.getString(6);

                CustomUserList list = new CustomUserList();
                list.setUserId(cursor.getString(0));
                list.setFirstName(cursor.getString(1));
                list.setLastName(cursor.getString(2));
                list.setEmail(cursor.getString(3));
                list.setContact(cursor.getString(4));
                list.setGender(cursor.getString(6));
                arrayList.add(list);
            }

            UserListAdapter adapter = new UserListAdapter(UserListActivity.this,arrayList);
            listView.setAdapter(adapter);
        }
        else {
            Toast.makeText(UserListActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
        }



    }
}
