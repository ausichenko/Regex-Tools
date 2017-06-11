package com.ausichenko.regextools.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pattern {
    @PrimaryKey
    private int id;

    private String name;
    private String pattern;
}
