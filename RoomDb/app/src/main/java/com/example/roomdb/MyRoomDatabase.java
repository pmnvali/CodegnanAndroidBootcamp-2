package com.example.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = MyTable.class,version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    public abstract MyDao myDao();


}
