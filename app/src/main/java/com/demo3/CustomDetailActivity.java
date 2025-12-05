package com.demo3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class CustomDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView title,desc,offer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_detail);

        imageView = findViewById(R.id.cust_detail_image);
        title = findViewById(R.id.cust_detail_title);
        offer = findViewById(R.id.cust_detail_offer);
        desc = findViewById(R.id.cust_detail_desc);

        Bundle bundle = getIntent().getExtras();
        title.setText(bundle.getString("Title"));
        offer.setText(bundle.getString("Offer"));
        desc.setText(bundle.getString("Description"));
        Glide.with(CustomDetailActivity.this).asGif().load(bundle.getString("Image")).placeholder(R.mipmap.ic_launcher).into(imageView);


    }
}