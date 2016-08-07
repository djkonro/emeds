package com.emeds.android.emeds;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by konro on 8/6/16.
 */

public class EmedsDbHelper extends SQLiteOpenHelper {

    public static boolean dbExist = false;
    public static SQLiteDatabase db;
    private Context context;
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Emeds.db";


    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES1 =
            "CREATE TABLE " + EmedsDb.HospitalEntry.TABLE_NAME + " (" +
                    EmedsDb.HospitalEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
                    EmedsDb.HospitalEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    EmedsDb.HospitalEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
                    " )";
    private static final String SQL_CREATE_ENTRIES2 =
            "CREATE TABLE " + EmedsDb.PharmacyEntry.TABLE_NAME + " (" +
                    EmedsDb.PharmacyEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
                    EmedsDb.PharmacyEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    EmedsDb.PharmacyEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
                    " )";
    private static final String SQL_CREATE_ENTRIES3 =
            "CREATE TABLE " + EmedsDb.ClinicEntry.TABLE_NAME + " (" +
                    EmedsDb.ClinicEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
                    EmedsDb.ClinicEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    EmedsDb.ClinicEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
                    " )";
    private static final String SQL_CREATE_ENTRIES4 =
            "CREATE TABLE " + EmedsDb.OtherEntry.TABLE_NAME + " (" +
                    EmedsDb.OtherEntry._ID + " INTEGER PRIMARY KEY autoincrement," +
                    EmedsDb.OtherEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    EmedsDb.OtherEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
                    " )";

    public EmedsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES1);
        db.execSQL(SQL_CREATE_ENTRIES2);
        db.execSQL(SQL_CREATE_ENTRIES3);
        db.execSQL(SQL_CREATE_ENTRIES4);

        PopulateDb.populate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}