package lyn.librpump.model.librpump;

import android.content.ContentValues;
import android.provider.BaseColumns;

import lyn.librpump.kernel.pump.Pump;
import lyn.librpump.util.CommonMethod;

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


        public static ContentValues generateValues(Pump pump) {

            ContentValues pumpValues = new ContentValues();

            pumpValues.put(COLUMN_NAME_T1I, pump.e.getT1i());
            pumpValues.put(COLUMN_NAME_P1I, pump.e.getP1i());
            pumpValues.put(COLUMN_NAME_H1I, pump.e.getH1i());
            pumpValues.put(COLUMN_NAME_X1I, pump.e.getX1i());

            pumpValues.put(COLUMN_NAME_T1O, pump.e.getT1o());
            pumpValues.put(COLUMN_NAME_P1O, pump.e.getP1o());
            pumpValues.put(COLUMN_NAME_H1O, pump.e.getH1o());
            pumpValues.put(COLUMN_NAME_X1O, pump.e.getX1o());

            pumpValues.put(COLUMN_NAME_T2O, pump.a.getT2o());
            pumpValues.put(COLUMN_NAME_P2O, pump.a.getP2o());
            pumpValues.put(COLUMN_NAME_H2O, pump.a.getH2o());
            pumpValues.put(COLUMN_NAME_X2O, pump.a.getX2o());

            pumpValues.put(COLUMN_NAME_T6I, pump.a.getT6i());
            pumpValues.put(COLUMN_NAME_P6I, pump.a.getP6i());
            pumpValues.put(COLUMN_NAME_H6I, pump.a.getH6i());
            pumpValues.put(COLUMN_NAME_X6I, pump.a.getX6i());

            pumpValues.put(COLUMN_NAME_T3O, pump.c.getT3o());
            pumpValues.put(COLUMN_NAME_P3O, pump.c.getP3o());
            pumpValues.put(COLUMN_NAME_H3O, pump.c.getH3o());
            pumpValues.put(COLUMN_NAME_X3O, pump.c.getX3o());

            pumpValues.put(COLUMN_NAME_T4WO, pump.g.getT4wo());
            pumpValues.put(COLUMN_NAME_P4WO, pump.g.getP4wo());
            pumpValues.put(COLUMN_NAME_H4WO, pump.g.getH4wo());
            pumpValues.put(COLUMN_NAME_X4WO, pump.g.getX4wo());

            pumpValues.put(COLUMN_NAME_T4O, pump.g.getT4o());
            pumpValues.put(COLUMN_NAME_P4O, pump.g.getP4o());
            pumpValues.put(COLUMN_NAME_H4O, pump.g.getH4o());
            pumpValues.put(COLUMN_NAME_X4O, pump.g.getX4o());

            pumpValues.put(COLUMN_NAME_T5I, pump.g.getT5i());
            pumpValues.put(COLUMN_NAME_P5I, pump.g.getP5i());
            pumpValues.put(COLUMN_NAME_H5I, pump.g.getH5i());
            pumpValues.put(COLUMN_NAME_X5I, pump.g.getX5i());

            pumpValues.put(COLUMN_NAME_T7O, pump.h.getT7o());
            pumpValues.put(COLUMN_NAME_P7O, pump.h.getP7o());
            pumpValues.put(COLUMN_NAME_H7O, pump.h.getH7o());
            pumpValues.put(COLUMN_NAME_X7O, pump.h.getX7o());

            pumpValues.put(COLUMN_NAME_T8O, pump.h.getT8o());
            pumpValues.put(COLUMN_NAME_P8O, pump.h.getP8o());
            pumpValues.put(COLUMN_NAME_H8O, pump.h.getH8o());
            pumpValues.put(COLUMN_NAME_X8O, pump.h.getX8o());

            pumpValues.put(COLUMN_NAME_Q_G, pump.getQ_g());
            pumpValues.put(COLUMN_NAME_Q_E, pump.getQ_e());
            pumpValues.put(COLUMN_NAME_Q_C, pump.getQ_c());
            pumpValues.put(COLUMN_NAME_Q_A, pump.getQ_a());

            pumpValues.put(COLUMN_NAME_COP, pump.getCOP());

            pumpValues.put(COLUMN_NAME_CREATE_TIME , CommonMethod.getCurrentTime());
            pumpValues.put(COLUMN_NAME_MODIFICATION_TIME , CommonMethod.getCurrentTime());

            return pumpValues;
        }





    }
}
