package APCSFinal;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public abstract class CellTile
{
	private int xPos;
	private int yPos;
	//private int width;
	//private int height;

	public CellTile()
	{
		setPos(5,5);
		//setWidth(5);
		//setHeight(5);
	}

	public CellTile(int x, int y)
	{
		xPos=x;
		yPos=y;
		//height=5;
		//width=5;
	}

	/*public CellTile(int x, int y, int w, int h)
	{
		xPos=x;
		yPos=y;
		width=w;
		height=h;


	}*/

	public void setPos(int x, int y)
	{
		xPos=x;
		yPos=y;


	}
	
	public void setX( int x )
	{
		xPos=x;

	}
	
	public void setY( int y )
	{
		yPos=y;

	}

	/*public void setWidth(int w)
	{
		width=w;

	}
	
	public void setHeight(int h)
	{
		height=h;

	}*/
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}	

	/*public int getWidth()
	{
		return width;
	}	
	
	public int getHeight()
	{
		return height;
	}*/
	
	public abstract void draw(Graphics window);
	
	public String toString()
	{
		return getX() + " " + getY() /*+ " " + getWidth() + " " + getHeight()*/;
	}
}