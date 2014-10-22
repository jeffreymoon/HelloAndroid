package com.moonfactory.helloandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Music extends Service {
    
    private MediaPlayer player;

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        player = MediaPlayer.create(this, R.raw.up);
        player.setLooping(true);
        player.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.left);
        player.start();
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

//    private static MediaPlayer mp = null;
//
//    public static void play(Context context, int resource) {
//        stop(context);
//        
//        if (Settings.getMusic(context)) {
//            mp = MediaPlayer.create(context, resource);
//            mp.setLooping(true);
//            mp .start();
//        }
//    }
//
//    public static void stop(Context context) {
//        if (mp != null) {
//            mp.stop();
//            mp.release();
//            mp = null;
//        }
//    }

}
