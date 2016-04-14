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

        public static final String COLUMN_NAME_T1I  = "T1i";
        public static final String COLUMN_NAME_P1I  = "P1i";
        public static final String COLUMN_NAME_H1I  = "H1i";
        public static final String COLUMN_NAME_X1I  = "X1i";

        public static final String COLUMN_NAME_T1O  = "T1o";
        public static final String COLUMN_NAME_P1O  = "P1o";
        public static final String COLUMN_NAME_H1O  = "H1o";
        public static final String COLUMN_NAME_X1O  = "X1o";

        public static final String COLUMN_NAME_T2O  = "T2o";
        public static final String COLUMN_NAME_P2O  = "P2o";
        public static final String COLUMN_NAME_H2O  = "H2o";
        public static final String COLUMN_NAME_X2O  = "X2o";

        public static final String COLUMN_NAME_T6I  = "T6i";
        public static final String COLUMN_NAME_P6I  = "P6i";
        public static final String COLUMN_NAME_H6I  = "H6i";
        public static final String COLUMN_NAME_X6I  = "X6i";

        public static final String COLUMN_NAME_T3O  = "T3o";
        public static final String COLUMN_NAME_P3O  = "P3o";
        public static final String COLUMN_NAME_H3O  = "H3o";
        public static final String COLUMN_NAME_X3O  = "X3o";

        public static final String COLUMN_NAME_T4WO  = "T4wo";
        public static final String COLUMN_NAME_P4WO  = "P4wo";
        public static final String COLUMN_NAME_H4WO  = "H4wo";
        public static final String COLUMN_NAME_X4WO  = "X4wo";

        public static final String COLUMN_NAME_T4O  = "T4o";
        public static final String COLUMN_NAME_P4O  = "P4o";
        public static final String COLUMN_NAME_H4O  = "H4o";
        public static final String COLUMN_NAME_X4O  = "X4o";

        public static final String COLUMN_NAME_T5I  = "T5i";
        public static final String COLUMN_NAME_P5I  = "P5i";
        public static final String COLUMN_NAME_H5I  = "H5i";
        public static final String COLUMN_NAME_X5I  = "X5i";

        public static final String COLUMN_NAME_T7O  = "T7o";
        public static final String COLUMN_NAME_P7O  = "P7o";
        public static final String COLUMN_NAME_H7O  = "H7o";
        public static final String COLUMN_NAME_X7O  = "X7o";

        public static final String COLUMN_NAME_T8O  = "T8o";
        public static final String COLUMN_NAME_P8O  = "P8o";
        public static final String COLUMN_NAME_H8O  = "H8o";
        public static final String COLUMN_NAME_X8O  = "X8o";

        public static final String COLUMN_NAME_Q_G  = "q_g";
        public static final String COLUMN_NAME_Q_E  = "q_e";
        public static final String COLUMN_NAME_Q_C  = "q_c";
        public static final String COLUMN_NAME_Q_A  = "q_a";

        public static final String COLUMN_NAME_COP  = "cop";

        public static final String COLUMN_NAME_CONFIG_ID = "config_id";

        public static final String COLUMN_NAME_MODIFICATION_TIME = "modification_time";
        public static final String COLUMN_NAME_CREATE_TIME = "create_time";







    }
}
