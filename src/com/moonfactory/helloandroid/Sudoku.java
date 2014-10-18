package com.moonfactory.helloandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sudoku extends ActionBarActivity implements OnClickListener {

    private static final String TAG = "Sudoku";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button continueButton = (Button)findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        Button newButton = (Button)findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        Button aboutButton = (Button)findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        Button exitButton = (Button)findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.about_button:
            Intent i = new Intent(this, About.class);
            startActivity(i);
        break;
        case R.id.new_button:
            openNewGameDialog();
        break;
        case R.id.exit_button:
            finish();
        break;
        default:
        break;
        }
    }
    
    private void openNewGameDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialoginterface, int i) {
                                startGame(i);
                            }
                        }).show();

    }
    
    private void startGame(int i) {
        Log.d(TAG , "clicked on " + i);
        Intent intent = new Intent(Sudoku.this, Game.class);
        intent.putExtra(Game.KEY_DIFFICULTY, i);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.settings:
    		startActivity(new Intent(this, Settings.class));
    		return true;
    	}
    	return false;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//        return true;
//        }
//        return super.onOptionsItemSelected(item);
    }
    
    @Override
    public void onResume() {
        super.onResume();
        Music.play(this, R.raw.up);
    }
    
    @Override
    public void onPause() {
        super.onPause();
        Music.stop(this);
    }
}
