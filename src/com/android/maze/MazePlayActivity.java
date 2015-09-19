package com.android.maze;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
  
public class MazePlayActivity extends Activity {
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      View mazeView = new MazeView(this);
      setContentView(mazeView);
   }
}