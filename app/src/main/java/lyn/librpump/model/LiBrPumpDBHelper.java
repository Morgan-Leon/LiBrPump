package lyn.librpump.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import lyn.librpump.model.librpump.LiBrPumpContract.*;
import lyn.librpump.model.librpumpConfig.LiBrPumpConfigContract.*;


/**
 * Created by lyn on 16/4/14.
 */
public class LiBrPumpDBHelper extends SQLiteOpenHelper{

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "lyn.LiBrPump.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMERIC_TYPE = " NUMERIC";
    private static final String INTEGER_TYPE = " INTEGER";


    private static final String COMMA_SEP = ",";


//    CREATE TABLE `LiBr.config` (
//            `id`	INTEGER NOT NULL,
//            `Twai`	NUMERIC,
//            `Twco`	NUMERIC,
//            `Twei`	NUMERIC,
//            `Tweo`	NUMERIC,
//            `deltaT_e`	NUMERIC,
//            `a_trd`	NUMERIC,
//            `c_trd`	NUMERIC,
//            `deltaP_e`	NUMERIC,
//            `deltaX_a`	NUMERIC,
//            `deltaT_c`	NUMERIC,
//            `deltaT_h`	NUMERIC,
//    PRIMARY KEY(id)
//    );

    private static final String SQL_CREATE_ENTRIES_LIBRPUMP_CONFIG  =
            "CREATE TABLE " + LiBrPumpConfigEntry.TABLE_NAME + " (" +
                    LiBrPumpConfigEntry._ID + " INTEGER PRIMARY KEY," +
                    LiBrPumpConfigEntry.COLUMN_NAME_TWAI + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_TWCO + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_TWEI + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_TWEO + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_TWCO + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_A_TRD + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_C_TRD + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_E + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAP_E + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAX_A + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_C + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_H + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpConfigEntry.COLUMN_NAME_CREATE_TIME + INTEGER_TYPE+ COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME + INTEGER_TYPE+ COMMA_SEP +
                    " )";

    private static final String SQL_CREATE_ENTRIES_LIBRPUMP =
            "CREATE TABLE " + LiBrPumpEntry.TABLE_NAME + " (" +
                    LiBrPumpEntry._ID + " INTEGER PRIMARY KEY," +
                    LiBrPumpEntry.COLUMN_NAME_ID + TEXT_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
            " )";


    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS " + LiBrPumpEntry.TABLE_NAME;

    public LiBrPumpDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_LIBRPUMP_CONFIG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
