/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ausichenko.regextools.database;

import com.ausichenko.regextools.database.entity.PatternEntity;

import java.util.ArrayList;
import java.util.List;

/** Generates dummy data and inserts them into the database */
class DatabaseInitUtil {

    private static final String[] NAME = new String[]{
            "One", "Two", "Three", "Four"};
    private static final String[] PATTERN = new String[]{
            "Patter 1", "Patter 2", "Patter 3", "Patter 4"};

    static void initializeDb(AppDatabase db) {
        List<PatternEntity> products = new ArrayList<>(NAME.length);

        generateData(products);

        insertData(db, products);
    }

    private static void generateData(List<PatternEntity> products) {
        for (int i = 0; i < NAME.length; i++) {
            PatternEntity product = new PatternEntity();
            product.setId(i);
            product.setName(NAME[i]);
            product.setPattern(PATTERN[i]);
            products.add(product);
        }
    }

    private static void insertData(AppDatabase db, List<PatternEntity> patterns) {
        db.beginTransaction();
        try {
            db.patternDao().insertAll(patterns);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
