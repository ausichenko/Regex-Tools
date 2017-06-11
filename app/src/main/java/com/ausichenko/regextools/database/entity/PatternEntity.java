package com.ausichenko.regextools.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.ausichenko.regextools.model.Pattern;

@Entity(tableName = "patterns")
public class PatternEntity implements Pattern {
    @PrimaryKey
    private int id;

    private String name;
    private String pattern;

    public PatternEntity() {}

    @Ignore
    public PatternEntity(String name, String pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    public PatternEntity(Pattern pattern) {
        this.id = pattern.getId();
        this.name = pattern.getName();
        this.pattern = pattern.getPattern();
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
