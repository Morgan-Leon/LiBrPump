package lyn.librpump.fragment.dummy;

import android.database.Cursor;

import lyn.librpump.model.librpump.LiBrPumpContract;
import lyn.librpump.model.librpumpConfig.LiBrPumpConfigContract.*;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
    private LiBrPumpDBHelper dbHelper;
    private SQLiteDatabase db;
    private Cursor c;

    public DummyContent(LiBrPumpDBHelper dbHelper){
//        this.dbHelper = dbHelper;
//        db = dbHelper.getReadableDatabase();
//        String[] projection = {
//                LiBrPumpConfigEntry._ID,
//                LiBrPumpConfigEntry.COLUMN_NAME_TITLE,
//                LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME
//        };
//        String sortOrder =
//                LiBrPumpConfigEntry.COLUMN_NAME_CREATE_TIME + " DESC";
//        String selection = LiBrPumpConfigEntry._ID + "> ";
//        String selectionArgs[] = {"0"};
//
//        c = db.query(LiBrPumpConfigEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
//        c.getString(c.getColumnIndexOrThrow(LiBrPumpConfigEntry.COLUMN_NAME_MODIFICATION_TIME));
    }


    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
