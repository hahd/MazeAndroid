package com.android.maze;

import java.util.*;
import java.io.*;


public class Maze{

	//Fields
	public boolean[][] maze=new boolean[41][61];
	protected boolean[][] prize=new boolean[41][61];
	public int prizecount;
	public int X;
	public int Y;

	//Constructor
	public Maze(){

		X=1;
		Y=1;
		prizecount=0;
		for (int i=0;i<41;i++){
			for (int k=0;k<61;k++){
				maze[i][k]=false;
				prize[i][k]=false;
			}
		}

	}

	//Methods
	public void GenerateMaze(){
		Stack<Integer> StackListX=new Stack<Integer>();
		Stack<Integer> StackListY=new Stack<Integer>();

		maze[1][1]=true;
		StackListX.push(1);
		StackListY.push(1);
		while (StackListX.size()>0){
			int xpos=(Integer)StackListX.peek();
			int ypos=(Integer)StackListY.peek();

			//System.out.println(check(xpos, ypos));
			//System.out.println(xpos);
			//System.out.println(ypos);

			if (check(xpos, ypos)==true){
				int direction=Direction();
				if (direction==1){
					if ((xpos+2)<41){
						if (maze[xpos+2][ypos]==false){
							maze[xpos+2][ypos]=true;
							maze[xpos+1][ypos]=true;
							StackListX.push(xpos+2);
							StackListY.push(ypos);

						}
					}
				}
				else if (direction==2){
					if ((xpos-2)>0){
						if (maze[xpos-2][ypos]==false){
							maze[xpos-2][ypos]=true;
							maze[xpos-1][ypos]=true;
							StackListX.push(xpos-2);
							StackListY.push(ypos);

						}
					}
				}
				else if (direction==3){
					if ((ypos+2)<61){
						if (maze[xpos][ypos+2]==false){
							maze[xpos][ypos+1]=true;
							maze[xpos][ypos+2]=true;
							StackListX.push(xpos);
							StackListY.push(ypos+2);

						}
					}
				}
				else if (direction==4){
					if ((ypos-2)>0){
						if (maze[xpos][ypos-2]==false){
							maze[xpos][ypos-2]=true;
							maze[xpos][ypos-1]=true;
							StackListX.push(xpos);
							StackListY.push(ypos-2);

						}
					}
				}
			}
			else{
				StackListX.pop();
				StackListY.pop();
			}
		}
	}

	public void GeneratePrize(int n){
		for (int i=0;i<n;i++){
			while (true){
				int x=(int) Math.ceil (Math.random () *19);
				int y=(int) Math.ceil (Math.random () *29);
				if (!prize[2*x+1][2*y+1] && !(x==0&&y==0)){
					prize[2*x+1][2*y+1]=true;
					prizecount+=1;
					break;
				}
			}
		}
	}
	public void MoveUp(){
		if (maze[X-1][Y]){
			X-=1;
			if (prize[X][Y]){
				prize[X][Y]=false;
				prizecount-=1;
			}
		}
	}
	public void MoveDown(){
		if (maze[X+1][Y]){
			X+=1;
			if (prize[X][Y]){
				prize[X][Y]=false;
				prizecount-=1;
			}
		}
	}
	public void MoveLeft(){
		if (maze[X][Y-1]){
			Y-=1;
			if (prize[X][Y]){
				prize[X][Y]=false;
				prizecount-=1;
			}
		}
	}
	public void MoveRight(){
		if (maze[X][Y+1]){
			Y+=1;
			if (prize[X][Y]){
				prize[X][Y]=false;
				prizecount-=1;
			}
		}
	}

	private int Direction(){
		return (int) Math.ceil (Math.random () / 0.25);
	}

	private boolean check(int x, int y){
		boolean ans=false;

		if (x-2>0){
			if (maze[x-2][y]==false){
				ans=true;
			}
		}
		if (x+2<41){
			if (maze[x+2][y]==false){
				ans=true;
			}
		}
		if (y-2>0){
			if (maze[x][y-2]==false){
				ans=true;
			}
		}
		if (y+2<61){
			if (maze[x][y+2]==false){
				ans=true;
			}
		}
		return ans;
	}

	public boolean[][] getMaze() {
		return maze;
	}
	public boolean[][] getPrize() {
		return prize;
	}
	/*public int getPrizecount() {
		return prizecount;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}*/
}
