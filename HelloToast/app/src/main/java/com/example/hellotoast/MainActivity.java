package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    int count = 0;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //findViewById()
        b = findViewById(R.id.countButton);
        tv = findViewById(R.id.resultTextview);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tv.setText(String.valueOf(count));

            }
        });

    }

    public void displayToast(View view) {
        //Context: It is an Application environment or particular class environment
        Toast.makeText(this,"Welcome to Codegnan android Bootcamp",
                Toast.LENGTH_LONG).show();

    }
}