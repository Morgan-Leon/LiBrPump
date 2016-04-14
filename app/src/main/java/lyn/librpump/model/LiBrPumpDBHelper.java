package lyn.librpump.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
//            `a_TDR`	NUMERIC,
//            `c_TDR`	NUMERIC,
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
                    LiBrPumpConfigEntry.COLUMN_NAME_A_TDR + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_C_TDR + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_E + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAP_E + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAX_A + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_C + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_H + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpConfigEntry.COLUMN_NAME_CREATE_TIME + INTEGER_TYPE+ COMMA_SEP +
                    LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME + INTEGER_TYPE +
                    " )";


//    FOREIGN KEY(`Field1`) REFERENCES LiBr.id
    private static final String SQL_CREATE_ENTRIES_LIBRPUMP =
            "CREATE TABLE " + LiBrPumpEntry.TABLE_NAME + " (" +
                    LiBrPumpEntry._ID + " INTEGER PRIMARY KEY," +
                    LiBrPumpEntry.COLUMN_NAME_T1I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P1I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H1I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X1I + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T1O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P1O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H1O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X1O + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T2O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P2O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H2O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X2O + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T6I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P6I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H6I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X6I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_T3O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P3O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H3O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X3O + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T4WO + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P4WO + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H4WO + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X4WO + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T4O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P4O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H4O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X4O + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T5I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P5I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H5I + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X5I + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T7O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P7O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H7O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X7O + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_T8O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_P8O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_H8O + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_X8O + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_Q_G + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_Q_E + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_Q_C + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_Q_A + NUMERIC_TYPE + COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_COP + NUMERIC_TYPE + COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_CONFIG_ID + INTEGER_TYPE+ COMMA_SEP +

                    LiBrPumpEntry.COLUMN_NAME_CREATE_TIME + INTEGER_TYPE+ COMMA_SEP +
                    LiBrPumpEntry.COLUMN_NAME_MODIFICATION_TIME + INTEGER_TYPE+ COMMA_SEP +
                    "CONSTRAINT " + LiBrPumpEntry.COLUMN_NAME_CONFIG_ID  +
                    " FOREIGN KEY(" + LiBrPumpConfigEntry._ID + ")" +
                    " REFERENCES " + LiBrPumpConfigEntry.TABLE_NAME + "(" + LiBrPumpConfigEntry._ID + ")" +
                    
            " )";


    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS " + LiBrPumpConfigEntry.TABLE_NAME + COMMA_SEP + LiBrPumpEntry.TABLE_NAME;

    public LiBrPumpDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_LIBRPUMP_CONFIG);
        db.execSQL(SQL_CREATE_ENTRIES_LIBRPUMP);
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

    public long insertToConfig(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long newRowId = db.insert(LiBrPumpConfigEntry.TABLE_NAME, "null", values);
        return  newRowId;
    }

    public long insert(ContentValues pumpConfigValues, ContentValues pumpValues){
        SQLiteDatabase db = this.getWritableDatabase();
        long configId = insertToConfig(pumpConfigValues);
        pumpValues.put(LiBrPumpEntry.COLUMN_NAME_CONFIG_ID, configId);
        return  db.insert(LiBrPumpEntry.TABLE_NAME,"null",pumpValues);
    }

    public Cursor query(String sql,String[] args){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,args);
        return  cursor;
    }
}
