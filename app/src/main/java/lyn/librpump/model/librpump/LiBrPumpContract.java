package lyn.librpump.model.librpump;

import android.provider.BaseColumns;

/**
 * Created by lyn on 16/4/14.
 */
public final class LiBrPumpContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public LiBrPumpContract () {}

    /* Inner class that defines the table contents */
    public static abstract class LiBrPumpEntry implements BaseColumns {
        public static final String TABLE_NAME = "LiBrPump";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

    }
}
