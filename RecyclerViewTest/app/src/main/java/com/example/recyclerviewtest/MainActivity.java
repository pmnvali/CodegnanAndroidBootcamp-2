package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycler);
        int images[] = {R.drawable.alpha,
        R.drawable.beta,R.drawable.cupcake,
        R.drawable.donut,R.drawable.eclair,
        R.drawable.froyo,R.drawable.gingerbread,
        R.drawable.honeycomb,
        R.drawable.icecreamsandwich,
        R.drawable.jellybean,
        R.drawable.kitkat,
        R.drawable.lollipop,
        R.drawable.marshmallow,
        R.drawable.nougat,
        R.drawable.oreo,R.drawable.pie, R.drawable.q,R.drawable.r};
        String version_names[] = {"Alpha","Beta","cupcake","donut","eclair","froyo",
        "gingerbread","honeycomb","icecreamsandwich","jellybean","kitkat","lollipop",
                "marshmallow","nougat","oreo","pie","q","R"
        };

        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this,images,version_names);
        rv.setAdapter(adapter);


    }
}