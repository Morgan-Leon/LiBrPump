package lyn.librpump.model.librpumpConfig;

import android.content.ContentValues;
import android.provider.BaseColumns;

import java.util.Date;

import lyn.librpump.kernel.pump.Pump;
import lyn.librpump.util.CommonMethod;

/**
 * Created by lyn on 16/4/14.
 */
public final class LiBrPumpConfigContract {
    public LiBrPumpConfigContract(){}

    public static  abstract  class  LiBrPumpConfigEntry implements BaseColumns {
//        CREATE TABLE `LiBr.config` (
//                `id`	INTEGER NOT NULL,
//                `Twai`	NUMERIC,
//                `Twco`	NUMERIC,
//                `Twei`	NUMERIC,
//                `Tweo`	NUMERIC,
//                `deltaT_e`	NUMERIC,
//                `a_TDR`	NUMERIC,
//                `c_TDR`	NUMERIC,
//                `deltaP_e`	NUMERIC,
//                `deltaX_a`	NUMERIC,
//                `deltaT_c`	NUMERIC,
//                `deltaT_h`	NUMERIC,
//        PRIMARY KEY(id)
//        );
        public static final String TABLE_NAME = "LiBrPump_config";
        public static final String COLUMN_NAME_NULLABLE = "null";

        public static final String COLUMN_NAME_TWAI = "Twai";
        public static final String COLUMN_NAME_TWCO = "Twco";
        public static final String COLUMN_NAME_TWEI = "Twei";
        public static final String COLUMN_NAME_TWEO = "Tweo";
        public static final String COLUMN_NAME_A_TDR = "a_tdr";
        public static final String COLUMN_NAME_C_TDR = "c_tdr";
        public static final String COLUMN_NAME_DELTAT_E = "deltaT_e";
        public static final String COLUMN_NAME_DELTAP_E = "deltaP_e";
        public static final String COLUMN_NAME_DELTAX_A = "deltaX_a";
        public static final String COLUMN_NAME_DELTAT_C = "deltaT_c";
        public static final String COLUMN_NAME_DELTAT_H = "deltaT_h";

        public static final String COLUMN_NAME_MODIFICATION_TIME = "modification_time";
        public static final String COLUMN_NAME_CREATE_TIME = "create_time";

        public static ContentValues generateValues(Pump p){

            ContentValues pumpConfigValues = new ContentValues();

            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_TWAI, p.getTwai());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_TWCO, p.getTwco());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_TWEI, p.getTwei());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_TWEO, p.getTweo());

            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_A_TDR , p.getA_tdr());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_C_TDR , p.getC_tdr());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_E , p.getDeltaT_e());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_DELTAP_E , p.getDeltaP_e());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_DELTAX_A , p.getDeltaX_a());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_C , p.getDeltaT_c());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_DELTAT_H , p.getDeltaT_h());

            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_CREATE_TIME , CommonMethod.getCurrentTime());
            pumpConfigValues.put(LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME , CommonMethod.getCurrentTime());

            return  pumpConfigValues;
        }

    }
}
