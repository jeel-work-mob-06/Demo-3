package com.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CustomeSecoundListActivity extends AppCompatActivity {

    String[] imageArray = {"https://villman.com/product_photos/h193hq_01.gif",
            "https://www.animatedimages.org/data/media/474/animated-printer-image-0013.gif",
            "https://i.pinimg.com/originals/90/92/bd/9092bd8b69197bcf6fe3e903c6315570.gif",
            "https://d3hjf51r9j54j7.cloudfront.net/wp-content/uploads/sites/9/2021/11/Z8000-Animated-GIF.gif",
            "https://i.pinimg.com/originals/b6/27/39/b627391ed72a80e98fe10e80deef4e28.gif",
            "https://platform.theverge.com/wp-content/uploads/sites/2/chorus/uploads/chorus_asset/file/7950335/beoplay_loop_2.gif?quality=90&strip=all&crop=0,2.6903425219201,100,94.61931495616"
    };
    String[] titleArray = {"Monitor",
            "Printers",
            "Fastrack Smartwatches",
            "Projector",
            "Best Selling Mobile Speakers",
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
    GridView listView;
    ArrayList<CustomList> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custome_secound_list);

        listView = findViewById(R.id.cust_list_sec);

        arrayList = new ArrayList<>();
        for(int i=0;i<imageArray.length;i++){
            CustomList list = new CustomList();
            list.setImage(imageArray[i]);
            list.setDec(decArray[i]);
            list.setOffer(offerArray[i]);
            list.setTitle(titleArray[i]);
            arrayList.add(list);
        }


        CustomeSecoundAdapter custAdepter = new CustomeSecoundAdapter(CustomeSecoundListActivity.this,arrayList);
        listView.setAdapter(custAdepter);

      /*
            click event for click product and redirect to next page
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(CustomeSecoundListActivity.this,CustomDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Image",arrayList.get(i).getImage());
                bundle.putString("Title",arrayList.get(i).getTitle());
                bundle.putString("Offer",arrayList.get(i).getOffer());
                bundle.putString("Description",arrayList.get(i).getDec());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });*/

        






    }
}