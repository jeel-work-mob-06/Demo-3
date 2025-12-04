package com.demo3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomListActivity extends AppCompatActivity {

    String[] imageArray = {"https://rukminim2.flixcart.com/image/400/400/xif0q/monitor/s/k/q/-original-imahathge2dfftdg.jpeg?q=70",
            "https://rukminim2.flixcart.com/image/400/400/xif0q/printer/s/8/d/-original-imafkykednshkhx5.jpeg?q=70",
            "https://rukminim2.flixcart.com/image/400/400/xif0q/smartwatch/5/v/s/-original-imagxrhetgfuebnn.jpeg?q=70",
            "https://rukminim2.flixcart.com/image/400/400/kcf4lu80/speaker/mobile-tablet-speaker/h/u/f/srs-xb23-sony-original-imaftk66vjxp86h5.jpeg?q=70",
            "https://rukminim2.flixcart.com/image/400/400/l58iaa80/headphone/k/z/m/nord-buds-ce-oneplus-original-imagfyk4hyvgg6ze.jpeg?q=70",
            "https://rukminim2.flixcart.com/image/400/400/xif0q/projector/q/s/3/-original-imahhcffsrf38hf6.jpeg?q=70"
    };
    String[] titleArray = {"Monitor",
                            "Printers",
                            "Fastrack Smartwatches",
                            "Projector","Best Selling Mobile Speakers",
                            "Best Truewireless Headphones"};
    String[] offerArray = {"From ₹8279",
                            "From ₹2336",
                            "From ₹1,399",
                            "From ₹6990",
                            "From ₹499*","Grab Now"};
    String[] decArray = {"DELL",
                        "Canon",
                        "Top Offers | BT Calling",
                        "Egate","Sony,",
                        "boAt & more","boAt, Oneplus & more"};
    ListView cust_lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list);


        cust_lst = findViewById(R.id.custom_lst);
        CustomeListAdapter custAdepter = new CustomeListAdapter(CustomListActivity.this,imageArray,titleArray,offerArray,decArray);
        cust_lst.setAdapter(custAdepter);
    }
}