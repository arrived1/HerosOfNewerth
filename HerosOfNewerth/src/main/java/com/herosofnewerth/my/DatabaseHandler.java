package com.herosofnewerth.my;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum TABLE {
    SkillDeathMetch,
    SkillSingleRandom,
    HeroDeathMetch,
    HeroSingleRandom
}

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_SIZE = 30;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "statisticManagerHoN";
    private static final String TABLE_STATISTIC_SKILL_SINGLE_RANDOM = "statisticSkillSingleRandom";
    private static final String TABLE_STATISTIC_SKILL_DEATH_MATCH = "statisticSkillDeathMatch";
    private static final String TABLE_STATISTIC_HERO_SINGLE_RANDOM = "statisticHeroSingleRandom";
    private static final String TABLE_STATISTIC_HERO_DEATH_MATCH = "statisticHeroDeathMatch";
    private static String TABLE_STATISTIC = "";

    private static final String KEY_ID = "id";
    private static final String KEY_SCORE = "score";
    private static final String KEY_CHANCES_LEFT = "chancesLeft";
    private static final String KEY_TIME = "time";

    public DatabaseHandler(Context context, TABLE type) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        if(type == TABLE.SkillDeathMetch) {
            TABLE_STATISTIC = TABLE_STATISTIC_SKILL_SINGLE_RANDOM;
        }
        if(type == TABLE.SkillSingleRandom) {
            TABLE_STATISTIC = TABLE_STATISTIC_SKILL_DEATH_MATCH;
        }
        if(type == TABLE.HeroDeathMetch) {
            TABLE_STATISTIC = TABLE_STATISTIC_HERO_DEATH_MATCH;
        }
        if(type == TABLE.HeroSingleRandom) {
            TABLE_STATISTIC = TABLE_STATISTIC_HERO_SINGLE_RANDOM;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db, TABLE_STATISTIC_SKILL_SINGLE_RANDOM);
        createTable(db, TABLE_STATISTIC_SKILL_DEATH_MATCH);
        createTable(db, TABLE_STATISTIC_HERO_DEATH_MATCH);
        createTable(db, TABLE_STATISTIC_HERO_SINGLE_RANDOM);
    }

    private void createTable(SQLiteDatabase db, String tableName) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + tableName + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_SCORE + " TEXT,"
                + KEY_CHANCES_LEFT + " TEXT,"
                + KEY_TIME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATISTIC_SKILL_SINGLE_RANDOM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATISTIC_SKILL_DEATH_MATCH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATISTIC_HERO_SINGLE_RANDOM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATISTIC_HERO_DEATH_MATCH);
        onCreate(db);
    }

    public void addRecord(DataBaseRecord record) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SCORE, record.getScore());
        values.put(KEY_CHANCES_LEFT, record.getChancesLeft());
        values.put(KEY_TIME, record.getTime());

        db.insert(TABLE_STATISTIC, null, values);
        db.close();
    }


    public ArrayList<DataBaseRecord> getAllRecords() {
        ArrayList<DataBaseRecord> recordList = new ArrayList<DataBaseRecord>();

        String selectQuery = "SELECT  * FROM " + TABLE_STATISTIC;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DataBaseRecord record = new DataBaseRecord(cursor.getString(1),
                                                           cursor.getString(2),
                                                           cursor.getString(3));
                recordList.add(record);
            } while (cursor.moveToNext());
        }
        sortRecords(recordList);
        return recordList;
    }

    public void cleanup() {
        int size = size();

        if(size() > DATABASE_SIZE) {
            ArrayList<DataBaseRecord> records = getAllRecords();
            sortRecords(records);

            for(int i = DATABASE_SIZE; i < size; ++i) {
                deleteRecord(i);
            }
        }
        size = size();
    }

    public void deleteRecord(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STATISTIC,
                  KEY_ID + " = ?",
                  new String[] { String.valueOf(id) });
        db.close();
    }

    public int size() {
        String countQuery = "SELECT  * FROM " + TABLE_STATISTIC;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = 0;

        if(cursor != null && !cursor.isClosed()){
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }

    private void sortRecords(ArrayList<DataBaseRecord> array) {
        Collections.sort(array, new DataBaseRecordComparator());
    }

//    public DataBaseRecord getRecord(int id) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_STATISTIC,
//                new String[] { KEY_ID, KEY_SCORE, KEY_CHANCES_LEFT, KEY_TIME },
//                KEY_ID + "=?",
//                new String[] { String.valueOf(id) },
//                null, null, null, null);
//
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        DataBaseRecord record = new DataBaseRecord(
//                cursor.getString(1),
//                cursor.getString(2),
//                cursor.getString(3));
//        return record;
//    }
//
//    public int updateRecord(DataBaseRecord record) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_SCORE, record.getScore());
//        values.put(KEY_CHANCES_LEFT, record.getChancesLeft());
//        values.put(KEY_TIME, record.getTime());
//
//        return db.update(TABLE_STATISTIC,
//                         values,
//                         KEY_ID + " = ?",
//                         new String[] { String.valueOf(record.getId()) });
//    }
//

}
