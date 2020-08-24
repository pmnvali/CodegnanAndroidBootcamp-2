package com.example.explicitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_userInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_userInput = findViewById(R.id.userInput);
    }

    public void openSecondActivity(View view) {
        //In ExplicitIntent we should have to pass 2 parameters
        //1.Context and 2.Activity class name
        String userData = et_userInput.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("key",userData);

        startActivity(i);

    }
}