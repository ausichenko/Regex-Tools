package com.ausichenko.regextools.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ausichenko.regextools.database.entity.PatternEntity;

import java.util.List;

@Dao
public interface PatternDao {
    @Query("SELECT * FROM pattern")
    LiveData<List<PatternEntity>> getAll();

    @Insert
    void insertAll(PatternEntity... pattern);

    @Delete
    void delete(PatternEntity pattern);
}
