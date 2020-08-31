package com.example.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void inserData(MyTable table);

    @Query("select *from student")
    public List<MyTable> readData();

    @Update
    public void update(MyTable table);

    @Delete
    public void delete(MyTable table);

    @Query("select *from student where rollno like:rolno")
    public List<MyTable> find(String rolno);


}
