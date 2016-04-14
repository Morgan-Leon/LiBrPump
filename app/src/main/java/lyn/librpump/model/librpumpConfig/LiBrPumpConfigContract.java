package lyn.librpump.model.librpumpConfig;

import android.provider.BaseColumns;

import java.util.Date;

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
//                `a_trd`	NUMERIC,
//                `c_trd`	NUMERIC,
//                `deltaP_e`	NUMERIC,
//                `deltaX_a`	NUMERIC,
//                `deltaT_c`	NUMERIC,
//                `deltaT_h`	NUMERIC,
//        PRIMARY KEY(id)
//        );
        public static final String TABLE_NAME = "LiBrPump_config";
        public static final String COLUMN_NAME_TWAI = "Twai";
        public static final String COLUMN_NAME_TWCO = "Twco";
        public static final String COLUMN_NAME_TWEI = "Twei";
        public static final String COLUMN_NAME_TWEO = "Tweo";
        public static final String COLUMN_NAME_A_TRD = "a_trd";
        public static final String COLUMN_NAME_C_TRD = "c_trd";
        public static final String COLUMN_NAME_DELTAT_E = "deltaT_E";
        public static final String COLUMN_NAME_DELTAP_E = "deltaP_e";
        public static final String COLUMN_NAME_DELTAX_A = "deltaX_a";
        public static final String COLUMN_NAME_DELTAT_C = "deltaT_c";
        public static final String COLUMN_NAME_DELTAT_H = "deltaT_h";

        public static final String COLUMN_NAME_MODIFICATION_TIME = "modification_time";
        public static final String COLUMN_NAME_CREATE_TIME = "create_time";

    }
}
