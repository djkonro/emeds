package com.emeds.android.emeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by konro on 8/7/16.
 */

public class PopulateDb {

    public static void populate(SQLiteDatabase db){
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_ENTRY_ID, "H1");
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_TITLE, "Hospital 1");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_ENTRY_ID, "H2");
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_TITLE, "Hospital 2");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_ENTRY_ID, "H3");
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_TITLE, "Hospital 3");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_ENTRY_ID, "H4");
        values.put(EmedsDb.HospitalEntry.COLUMN_NAME_TITLE, "Hospital 4");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);


        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_ENTRY_ID, "P1");
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_TITLE, "Pharmacy 1");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_ENTRY_ID, "P2");
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_TITLE, "Pharmacy 2");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_ENTRY_ID, "P3");
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_TITLE, "Pharmacy 3");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_ENTRY_ID, "P4");
        values.put(EmedsDb.PharmacyEntry.COLUMN_NAME_TITLE, "Pharmacy 4");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_ENTRY_ID, "C1");
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_TITLE, "Clinic 1");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_ENTRY_ID, "C2");
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_TITLE, "Clinic 2");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_ENTRY_ID, "C3");
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_TITLE, "Clinic 3");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_ENTRY_ID, "C4");
        values.put(EmedsDb.ClinicEntry.COLUMN_NAME_TITLE, "Clinic 4");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.OtherEntry.COLUMN_NAME_ENTRY_ID, "O1");
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_TITLE, "Other 1");
        db.insert(EmedsDb.OtherEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_ENTRY_ID, "O2");
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_TITLE, "Other 2");
        db.insert(EmedsDb.OtherEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_ENTRY_ID, "O3");
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_TITLE, "Other 3");
        db.insert(EmedsDb.OtherEntry.TABLE_NAME, null, values);
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_ENTRY_ID, "O4");
        values.put(EmedsDb.OtherEntry.COLUMN_NAME_TITLE, "Other 4");
        db.insert(EmedsDb.OtherEntry.TABLE_NAME, null, values);

    }
}
