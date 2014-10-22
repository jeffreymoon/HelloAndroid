package com.moonfactory.helloandroid;

import android.net.Uri;
import android.provider.BaseColumns;

public interface Constants extends BaseColumns {

    public static final String TABLE_NAME = "events";
    public static final String TIME = "time";
    public static final String TITLE = "title";
    public static final String AUTHORITY = "com.moonfactory.helloandroid";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + TABLE_NAME);
}
