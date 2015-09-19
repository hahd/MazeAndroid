package com.android.maze;

import java.util.*;
import java.io.*;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
public class MazeView extends TileView { 
	
	public int MaxX;
	public int MaxY;
	public int sposx=0;
	public int sposy=0;
	public int eposx; 
	public int eposy;
	public RectF rect;
    public  Paint paint;
    Maze viewMaze= new Maze();
    public MazeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	protected void onDraw(Canvas canvas) {
		
		canvas.drawLine(sposx, sposy,eposx, eposy,paint
        );
		
		Update();
	      try {  
	          Thread.sleep(30);  
	       } catch (InterruptedException e) { }
	       
	       invalidate();  // Force a re-draw
	}
	

	 private void Update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	   public void onSizeChanged(int w, int h, int oldW, int oldH) {
	      // Set the movement bounds for the ball
	      MaxX = w-1;
	      MaxY = h-1;
	 }

}
