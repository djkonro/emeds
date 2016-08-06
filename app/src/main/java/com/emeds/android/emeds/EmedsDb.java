package com.emeds.android.emeds;

import android.provider.BaseColumns;

/**
 * Created by konro on 8/6/16.
 */

public class EmedsDb {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public EmedsDb() {}

    /* Inner class that defines the table contents */
    public static abstract class HospitalEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
    }
}
