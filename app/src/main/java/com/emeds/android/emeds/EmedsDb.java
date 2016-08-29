package com.emeds.android.emeds;

import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * Created by konro on 8/6/16.
 */

public class EmedsDb {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public EmedsDb() {}

    public static final String ENTRY_ID = "entryid";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String LOCATION = "location";

    /* Inner class that defines the table contents */
    public static abstract class HospitalEntry implements BaseColumns {
        public static final String TABLE_NAME = "hospital_entry";
    }

    public static abstract class PharmacyEntry implements BaseColumns {
        public static final String TABLE_NAME = "pharmacy_entry";
    }

    public static abstract class ClinicEntry implements BaseColumns {
        public static final String TABLE_NAME = "clinic_entry";
    }

    public static Cursor getCursor(String tablename){
        //mTitleImageView.setImageResource(R.mipmap.hospitals);
        return EmedsListFragment.db.query(
                tablename,
                null, // Columns - null selects all columns
                null,
                null,
                null, // groupBy
                null, // having
                null // orderBy
        );
    }
}
