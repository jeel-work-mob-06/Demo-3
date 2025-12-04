package com.demo3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SpinnerListActivity extends AppCompatActivity {

    Spinner spinner; // variable for spinner
    // String[] countryArray = {"India", "Austrelia","Caneda"};
    //    ListView lst1;


    // Grid view Variable Declaration
    GridView gdview;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner_list);
        spinner = findViewById(R.id.spinner);

        arrayList = new ArrayList<>();
        arrayList.add("India");
        arrayList.add("Caneda");
        arrayList.add("Austrelia");
        arrayList.add("Us");
        arrayList.add("Demo");
        arrayList.add("frans");
        arrayList.add("Irland");

        arrayList.remove(4);
        arrayList.set(4,"France");
        arrayList.add(2,"London");


        ArrayAdapter arrayAdapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(SpinnerListActivity.this, arrayList.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*
         ListView Code
        lst1 = findViewById(R.id.list1);
        ArrayAdapter listAdapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1,arrayList);
        lst1.setAdapter(listAdapter);

        lst1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerListActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        gdview = findViewById(R.id.gd_view);
        ArrayAdapter gdAdapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1,arrayList);
        gdview.setAdapter(gdAdapter);

        gdview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerListActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AutoCompleteTextView auto_txt;
        auto_txt = findViewById(R.id.auto_txt);
        ArrayAdapter autoAdapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1,arrayList);
        auto_txt.setAdapter(autoAdapter);
        auto_txt.setThreshold(1);

        auto_txt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerListActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        MultiAutoCompleteTextView multi_txt;
        multi_txt = findViewById(R.id.multi_txt);
        ArrayAdapter multiAdapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1,arrayList);
        multi_txt.setAdapter(multiAdapter);
        multi_txt.setThreshold(1);
        multi_txt.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        multi_txt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerListActivity.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}