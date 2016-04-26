package lyn.librpump.fragment.dummy;

import android.database.Cursor;

import lyn.librpump.model.librpump.LiBrPumpContract;
import lyn.librpump.model.librpumpConfig.LiBrPumpConfigContract.*;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lyn.librpump.model.LiBrPumpDBHelper;
import lyn.librpump.model.librpumpConfig.LiBrPumpConfigContract;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    private static LiBrPumpDBHelper dbHelper;
    private static SQLiteDatabase db;
    private static Cursor cursor;

    public  DummyContent(LiBrPumpDBHelper dbHelper){

        ITEMS.removeAll(ITEMS);

        this.dbHelper = dbHelper;
        db = this.dbHelper.getReadableDatabase();

        String[] projection = {
                LiBrPumpConfigEntry._ID,
                LiBrPumpConfigEntry.COLUMN_NAME_TWAI,
                LiBrPumpConfigEntry.COLUMN_NAME_TWCO,
                LiBrPumpConfigEntry.COLUMN_NAME_TWEI,
                LiBrPumpConfigEntry.COLUMN_NAME_TWEO,
                LiBrPumpConfigEntry.COLUMN_NAME_TITLE,
                LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME
        };
        String sortOrder =
                LiBrPumpConfigEntry.COLUMN_NAME_CREATE_TIME + " DESC";

        cursor = db.query(LiBrPumpConfigEntry.TABLE_NAME,projection,null,null,null,null,sortOrder);
        if(cursor.moveToFirst()) {
            System.out.print("CURSOR ====" +  cursor.getCount());
            int i = 0;
//          for循环易错
            while (cursor.moveToNext()){
                i++;
                String title = cursor.getString(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TITLE));
                Double iTwai = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWAI));
                Double iTwco = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWCO));
                Double iTwei = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWEI));
                Double iTweo = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWEO));

                addItem(createDummyItem(i, title, iTwai.toString(), iTwco.toString(), iTwei.toString(), iTweo.toString()));
            }

//            for(int i= 0; i < cursor.getCount(); i++){
//
//            }


        }

    }


    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

//    private static final int COUNT = 25;

    static {
        // Add some sample items.
//        String[] projection = {
//                LiBrPumpConfigEntry._ID,
//                LiBrPumpConfigEntry.COLUMN_NAME_TWAI,
//                LiBrPumpConfigEntry.COLUMN_NAME_TITLE,
//                LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME
//        };
//        String sortOrder =
//                LiBrPumpConfigEntry.COLUMN_NAME_CREATE_TIME + " DESC";
//        cursor = db.query(LiBrPumpConfigEntry.TABLE_NAME,projection,null,null,null,null,sortOrder);
//        if(cursor.moveToFirst()) {
//            for (int i = 1; i <= cursor.getCount(); i++) {
//                cursor.move(i);
//                String title = cursor.getString(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TITLE));
//                Double iTwai = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWAI));
//                Double iTwco = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWCO));
//                Double iTwei = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWEI));
//                Double iTweo = cursor.getDouble(cursor.getColumnIndex(LiBrPumpConfigEntry.COLUMN_NAME_TWEO));
//
//                addItem(createDummyItem(i, title, iTwai.toString(), iTwco.toString(), iTwei.toString(), iTweo.toString()));
//            }
//        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position, String title, String iTwai, String iTwco, String iTwei, String iTweo) {

        return new DummyItem(String.valueOf(position), title, iTwai, iTwco, iTwei, iTweo);
    }

//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String title;
        public final String iTwai;
        public final String iTwco;
        public final String iTwei;
        public final String iTweo;

//        public DummyItem(String id, String content, String details) {
//            this.id = id;
//            this.content = content;
//            this.details = details;
//        }
        public DummyItem(String id, String title, String iTwai, String iTwco, String iTwei, String iTweo) {
            this.id = id;
            this.title = title;
            this.iTwai = iTwai;
            this.iTwco = iTwco;
            this.iTwei = iTwei;
            this.iTweo = iTweo;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
