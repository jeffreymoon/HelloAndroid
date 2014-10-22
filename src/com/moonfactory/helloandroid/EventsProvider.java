package com.moonfactory.helloandroid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class EventsProvider extends ContentProvider {
    private static final int EVENTS = 1;
    private static final int EVENTS_ID = 2;

    private static final String CONTENT_TYPE
    = "vnd.android.cursor.dir/vnd.example.envet";

    private static final String CONTENT_ITEM_TYPE
    = "vnd_android.cursor.item.example.event";
    
    private EventsData events;
    private UriMatcher uriMatcher;
    @Override
    public int delete(Uri arg0, String arg1, String[] arg2) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public String getType(Uri arg0) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Uri insert(Uri arg0, ContentValues arg1) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean onCreate() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
            String arg4) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
        // TODO Auto-generated method stub
        return 0;
    }

}
