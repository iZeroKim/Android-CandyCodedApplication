package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    //Function that creates the mapIntent
    public void createMapIntent(View view){
        //Address Uri
        Uri myUri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        //ACTION_VIEW intent
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, myUri);
        //Package
        mapIntent.setPackage("com.google.android.apps.maps");
        //Check if there is an activity that can handle the intent
        if(mapIntent.resolveActivity(getPackageManager()) != null){
            startActivity(mapIntent);
        } else {
            Toast.makeText(this, "No map app found", Toast.LENGTH_LONG).show();
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    //Function that creates the phoneIntent
    public void createPhoneIntent(View view){
        //ACTION_DIAL intent
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        //Intent data
        Uri data = Uri.parse("tel:0123456789");
        phoneIntent.setData(data);
        //Start activity
        startActivity(phoneIntent);

    }
}
