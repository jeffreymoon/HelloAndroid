package com.moonfactory.helloandroid;

import static android.provider.BaseColumns._ID;
import static com.moonfactory.helloandroid.Constants.TABLE_NAME;
import static com.moonfactory.helloandroid.Constants.TIME;
import static com.moonfactory.helloandroid.Constants.TITLE;
import static com.moonfactory.helloandroid.Constants.CONTENT_URI;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Events extends Activity {

    private EventsData events;
    private static int[] TO = { R.id.rowid, R.id.time, R.id.title, };
    private static String ORDER_BY = TIME + " DESC";
    private static String[] FROM = { _ID, TIME, TITLE, };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvent("Hello, Android");
        Cursor cursor = getEvents();
        showEvents(cursor);
    }

    private void addEvent(String string) {
//        SQLiteDatabase db = events.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(TITLE, string);
//        db.insertOrThrow(TABLE_NAME, null, values);
        getContentResolver().insert(CONTENT_URI, values);
    }

    private Cursor getEvents() {
//        SQLiteDatabase db = events.getReadableDatabase();
//        Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null, null,
//                ORDER_BY);
//        startManagingCursor(cursor);
//        return cursor;
        return managedQuery(CONTENT_URI, FROM, null, null, ORDER_BY);
    }

    private void showEvents(Cursor cursor) {
        // SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
        // R.layout.item, cursor, FROM, TO);
        // setListAdapter(adapter);
        StringBuilder builder = new StringBuilder("Saved events:\n");
        while (cursor.moveToNext()) {
        long id = cursor.getLong(0);
        long time = cursor.getLong(1);
        String title = cursor.getString(2);
        builder.append(id).append(": ");
        builder.append(time).append(": ");
        builder.append(title).append("\n");
        }
        TextView text = (TextView) findViewById(R.id.text);
        text.setText(builder);
    }
}
