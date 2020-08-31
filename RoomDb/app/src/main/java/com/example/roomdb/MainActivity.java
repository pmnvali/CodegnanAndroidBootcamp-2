package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_rollno,et_name;
    TextView tv;
    MyRoomDatabase database;
    List<MyTable> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = new ArrayList<>();
        et_rollno = findViewById(R.id.rollNo);
        et_name = findViewById(R.id.name);
        tv = findViewById(R.id.datatextview);
        database = Room.databaseBuilder(this,MyRoomDatabase.class,"MyDb")
                .allowMainThreadQueries()
                .build();
    }

    public void save(View view) {
        String rollno = et_rollno.getText().toString();
        String name = et_name.getText().toString();
        List<MyTable> list = database.myDao().find(rollno);
        for(int i = 0;i<list.size();i++){
            if(rollno.equals(list.get(i).getRollno())){
                Toast.makeText(this,
                        rollno+" Already existed", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        MyTable table = new MyTable(rollno,name);
        database.myDao().inserData(table);
        Toast.makeText(this,
                "Data Inserted", Toast.LENGTH_SHORT).show();
        et_name.setText("");
        et_rollno.setText("");

    }

    public void read(View view) {
      tv.setText("");
        myList = database.myDao().readData();
        for(int i = 0;i<myList.size();i++){
            tv.append(myList.get(i).getRollno()+" "+myList.get(i).getName()+"\n");
        }

    }

    public void update(View view) {
        String rollno = et_rollno.getText().toString();
        String name = et_name.getText().toString();
        List<MyTable> list = database.myDao().find(rollno);
        for(int i = 0;i<list.size();i++){
            if(rollno.equals(list.get(i).getRollno())){
                Toast.makeText(this,
                        rollno+" Already existed", Toast.LENGTH_SHORT).show();
                MyTable table = new MyTable(rollno,name);
                database.myDao().update(table);
                Toast.makeText(this,
                        "Data Updated", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void delete(View view) {
        String rollno = et_rollno.getText().toString();
        String name = et_name.getText().toString();
        List<MyTable> list = database.myDao().find(rollno);
        for(int i = 0;i<list.size();i++){
            if(rollno.equals(list.get(i).getRollno())){
                Toast.makeText(this,
                        rollno+" Already existed", Toast.LENGTH_SHORT).show();
                MyTable table = new MyTable(rollno,name);
                database.myDao().delete(table);
                Toast.makeText(this,
                        "Data deleted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}