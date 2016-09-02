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
        values.put(EmedsDb.ENTRY_ID, "BueaH1");
        values.put(EmedsDb.NAME, "Government District Hospital");
        values.put(EmedsDb.PHONE, "6 - - - - - - - -");
        values.put(EmedsDb.LOCATION, "Likoko Street, Bokwango ");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaH2");
        values.put(EmedsDb.NAME, "7th Day Adventist Hospital");
        values.put(EmedsDb.PHONE, "233322270");
        values.put(EmedsDb.LOCATION, "Buea main Road, Soppo");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaH3");
        values.put(EmedsDb.NAME, "Mount Mary Hospital");
        values.put(EmedsDb.PHONE, "233322469");
        values.put(EmedsDb.LOCATION, "Soppo, Buea ");
        db.insert(EmedsDb.HospitalEntry.TABLE_NAME, null, values);


        values.put(EmedsDb.ENTRY_ID, "BueaP1");
        values.put(EmedsDb.NAME, "Amazing Pharmacy");
        values.put(EmedsDb.PHONE, "699316829");
        values.put(EmedsDb.LOCATION, "Malingo, Buea");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaP2");
        values.put(EmedsDb.NAME, "Winner's Pharmacy");
        values.put(EmedsDb.PHONE, "677692831");
        values.put(EmedsDb.LOCATION, "Buea main road, soppo ");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaP3");
        values.put(EmedsDb.NAME, "Royal Pharmacy");
        values.put(EmedsDb.PHONE, "6 - - - - - - - -");
        values.put(EmedsDb.LOCATION, "Buea main road, Soppo ");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaP4");
        values.put(EmedsDb.NAME, "Salvation Pharmacy");
        values.put(EmedsDb.PHONE, "694410601");
        values.put(EmedsDb.LOCATION, "Buea main road, soppo");
        db.insert(EmedsDb.PharmacyEntry.TABLE_NAME, null, values);


        values.put(EmedsDb.ENTRY_ID, "BueaC1");
        values.put(EmedsDb.NAME, "Solidarity Health Foundation");
        values.put(EmedsDb.PHONE, "677615757");
        values.put(EmedsDb.LOCATION, "Checkpoint, Buea");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaC2");
        values.put(EmedsDb.NAME, "ST Veronica's Medical Center");
        values.put(EmedsDb.PHONE, "233322419");
        values.put(EmedsDb.LOCATION, "Bunduma, Buea");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaC4");
        values.put(EmedsDb.NAME, "Health For All Foundation");
        values.put(EmedsDb.PHONE, "6 - - - - - - - -");
        values.put(EmedsDb.LOCATION, "UB Junction");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);

        values.put(EmedsDb.ENTRY_ID, "BueaC3");
        values.put(EmedsDb.NAME, "St Albert");
        values.put(EmedsDb.PHONE, "677664668");
        values.put(EmedsDb.LOCATION, "UB Junction");
        db.insert(EmedsDb.ClinicEntry.TABLE_NAME, null, values);

    }
}
