package com.example.roomdb;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class MyTable {

    @PrimaryKey @NonNull
    String rollno;

    String name;


    public MyTable(@NonNull String rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    @NonNull
    public String getRollno() {
        return rollno;
    }

    public void setRollno(@NonNull String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
