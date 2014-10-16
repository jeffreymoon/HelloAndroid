package com.moonfactory.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Game extends Activity {
    private static final String TAG = "Sudoku";
    
    public static final String KEY_DIFFICULTY = "difficulty";
    public static final int DIFFICULTY_EASY = 0;
    public static final int DIFFICULTY_MEDIUM = 1;
    public static final int DIFFICULTY_HARD = 2;
    
    private int puzzle[] = new int[9 * 9];
    private PuzzleView puzzleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        
        int diff = getIntent().getIntExtra(KEY_DIFFICULTY, DIFFICULTY_EASY);
        puzzle = getPuzzle(diff);
        calculateUstdTiles();
        
        puzzleView = new PuzzleView(this);
        setContentView(puzzleView);
        puzzleView.requestFocus();
        
    }
    
    protected void showKeypadOrError(int x, int y) {
        
    }
    
    protected boolean setTileIfValid(int x, int y, int value) {
        return false;
    }
    
    protected int[] getUsedTiles(int x, int y) {
        return null;
    }
    
    private void calculateUstdTiles() {
        
    }
    
    private int[] getPuzzle(int diff) {
        return null;
    }
    
    static private String toPuzzleString(int[] puz) {
        return null;
    }
    
    static protected int[] fromPuzzleString(String string) {
        return null;
    }
    
    private int getTile(int x, int y) {
        return 0;
    }
    
    private void setTile(int x, int y, int value) {
        
    }
    
    protected String getTileString(int x, int y) {
        return null;
    }
}
