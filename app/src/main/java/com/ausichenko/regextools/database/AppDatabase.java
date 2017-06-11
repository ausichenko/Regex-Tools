package com.ausichenko.regextools.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ausichenko.regextools.database.dao.PatternDao;
import com.ausichenko.regextools.database.entity.PatternEntity;

@Database(entities = {PatternEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    static final String DATABASE_NAME = "regex-db";

    public abstract PatternDao patternDao();
}
