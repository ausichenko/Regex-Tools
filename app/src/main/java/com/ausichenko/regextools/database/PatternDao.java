package com.ausichenko.regextools.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PatternDao {
    @Query("SELECT * FROM pattern")
    List<Pattern> getAll();

    @Insert
    void insertAll(Pattern... pattern);

    @Delete
    void delete(Pattern pattern);
}
