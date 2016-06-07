package APCSFinal;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics; 

import java.awt.Color;
import java.awt.Font;

public class Grid
{
	private CellTile[][] grid;
	
	public Grid()
	{
		setSize(0,0);
	}

	public Grid(int rows, int cols)
	{
		grid = new CellTile[rows][cols];

	}

	public void setSize(int rows, int cols)
	{
		grid = new CellTile[rows][cols];

	}

	public void setSpot(int row,int col, CellTile val)
	{
		grid[row][col]=val;

	}
	
	public CellTile getSpot(int row, int col)
	{
		return grid[row][col];
	}
	
	public int getNumRows()
	{
		return grid.length;
	}
	
	public int getNumCols()
	{
		return grid[0].length;
	}

	public boolean drawGrid(Graphics window)
	{
		boolean full=true;
		
		//for loop for row
		for(int r=0;r<grid.length;r++){
		//for(Cell[] r : grid){

			//for loop for col
			for(int c=0;c<grid[r].length;c++){
			//for(Cell c: r){
				//get current Cell
					//if it is null
				if(grid[r][c]==null){
				//if(c==null){
					full = false;
				}
					//else
				else{
					//c.draw(window);
					grid[r][c].draw(window);
				}
			}
		}

		return full;
	}
	
	public String toString()
	{
		String output="";

		for(int r=0; r<grid.length; r++)
		{
			for(int c=0; c<grid[r].length; c++)
			{
				output+=" "+grid[r][c];
			}
			output+="\n";
		}



		



		return output;
	}
}