package com.example.implicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b_url,b_call,b_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_url = findViewById(R.id.urlButton);
        b_call = findViewById(R.id.callButton);
        b_location = findViewById(R.id.locationButton);

        b_url.setOnClickListener(this);
        b_call.setOnClickListener(this);
        b_location.setOnClickListener(this);
        
        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.urlButton:
                openUrl();
                break;
            case R.id.callButton:
                makeACall();
                break;
                
            case R.id.locationButton:
                openLocation();
                break;
        }
        
    }

    private void openLocation() {
        //Uri u = Uri.parse("geo:23.3441,85.3096?q=<23.3441>,<85.3096>");
        Uri u = Uri.parse("geo:23.3441,85.3096?q=hospital");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    private void makeACall() {
        Uri u = Uri.parse("tel:1234567890");
        Intent i = new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);

        
    }

    private void openUrl() {
        //In ImplicitIntent we should have to pass two parameters
        //1.ACTION  and   2.URI class Object
        Uri u = Uri.parse("https://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }


}