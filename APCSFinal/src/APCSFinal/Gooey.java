package APCSFinal;

import java.awt.Graphics; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Canvas;

import reviewLabs.Grid;
import reviewLabs.Piece;

public class Gooey extends Canvas implements MouseListener{

	private int mouseX, mouseY;
	private boolean mouseClicked, gameOver;
	private int mouseButton, prevMouseButton;
	private Grid board;
	
	private final static int WIDTH=50;
	private final static int HEIGHT=50;
	private final static int SCALE = 50;
	private final static int BOARDSIZE = 6;

	public Gooey()
	{
		mouseClicked = false;
		mouseX = mouseY = 0;
		mouseButton = 0;
		prevMouseButton = -1;
		
		board = new Grid(BOARDSIZE,BOARDSIZE);
		
		addMouseListener(this);
		setBackground(Color.WHITE);
	}

	public void mouseClicked(MouseEvent e)
	{
/////do not reset mouse/switch buttons
		mouseClicked = true;
		mouseX=e.getX();
		mouseY=e.getY();
		mouseButton = e.getButton();
		
		//repaint();
	}

	public void paint(Graphics window)
	{
/////set box lines to white
		window.setColor(Color.white);
		window.fillRect(0,0,640,480);
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.setColor(Color.black);
		window.drawString("Word Search", 420,55);
/////draw word search letters
		window.drawString("click the letters to create words", 420,85);
		//window.drawString("right mouse click == [O]", 420,105);

		window.drawRect(50,50,WIDTH,HEIGHT);
		window.drawRect(50,100,WIDTH,HEIGHT);
		window.drawRect(50,150,WIDTH,HEIGHT);
		window.drawRect(50,200,WIDTH,HEIGHT);
		window.drawRect(50,250,WIDTH,HEIGHT);
		window.drawRect(50,300,WIDTH,HEIGHT);
		
		window.drawRect(100,50,WIDTH,HEIGHT);
		window.drawRect(100,100,WIDTH,HEIGHT);
		window.drawRect(100,150,WIDTH,HEIGHT);
		window.drawRect(100,200,WIDTH,HEIGHT);
		window.drawRect(100,250,WIDTH,HEIGHT);
		window.drawRect(100,300,WIDTH,HEIGHT);
		
		window.drawRect(150,50,WIDTH,HEIGHT);
		window.drawRect(150,100,WIDTH,HEIGHT);
		window.drawRect(150,150,WIDTH,HEIGHT);
		window.drawRect(150,200,WIDTH,HEIGHT);
		window.drawRect(150,250,WIDTH,HEIGHT);
		window.drawRect(150,300,WIDTH,HEIGHT);
		
		window.drawRect(200,50,WIDTH,HEIGHT);
		window.drawRect(200,100,WIDTH,HEIGHT);
		window.drawRect(200,150,WIDTH,HEIGHT);
		window.drawRect(200,200,WIDTH,HEIGHT);
		window.drawRect(200,250,WIDTH,HEIGHT);
		window.drawRect(200,300,WIDTH,HEIGHT);
		
		window.drawRect(250,50,WIDTH,HEIGHT);
		window.drawRect(250,100,WIDTH,HEIGHT);
		window.drawRect(250,150,WIDTH,HEIGHT);
		window.drawRect(250,200,WIDTH,HEIGHT);
		window.drawRect(250,250,WIDTH,HEIGHT);
		window.drawRect(250,300,WIDTH,HEIGHT);
		
		window.drawRect(300,50,WIDTH,HEIGHT);
		window.drawRect(300,100,WIDTH,HEIGHT);
		window.drawRect(300,150,WIDTH,HEIGHT);
		window.drawRect(300,200,WIDTH,HEIGHT);
		window.drawRect(300,250,WIDTH,HEIGHT);
		window.drawRect(300,300,WIDTH,HEIGHT);

		Mat z = new Mat(6);
		z.drawMat();
		int rlen=72;
		int clen=80;
		for(int r=0;r<z.getRows();r++){
			for(int c=0;c<z.getColumns();c++){
				window.drawString(z.getLetter(r, c).toUpperCase(),rlen,clen);
				clen+=50;
				
			}
			clen=80;
			rlen+=50;
		}
		
		
		public void markBoard()
		{
			if(mouseX>=WIDTH/3&&mouseX<=WIDTH+50&&mouseY>=HEIGHT/3&&mouseY<=HEIGHT+50)
			{
				int r = mouseY/50-1;
				int c = mouseX/50-1;
				Piece piece = (Piece)board.getSpot(r,c);
				//if BUTTON1 was pressed and BUTTON1 was not pressed last mouse press
				if(mouseButton==MouseEvent.BUTTON1&&prevMouseButton!=mouseButton)		//left mouse button pressed
				{
					if(piece==null)
					{
						board.setSpot(r,c,new Piece(5+c*50+50,5+r*50+50,WIDTH/3-10,HEIGHT/3-10,"X",Color.GREEN));
						prevMouseButton=mouseButton;
					}
					//save the current button pressed to compare to next button pressed
					
				}
				//if BUTTON3 was pressed and BUTTON3 was not pressed last mouse press
				
			}
		}
	
		
/////check if letter is first/last in word
		/*if(mouseClicked)
		{
/////highlight square
			board.drawGrid(window);

/////change to determine complete word
			if(determineWinner(window))
			{
			  //make a new board	
				board = new Grid(BOARDSIZE,BOARDSIZE);
			  //clear the screen
			}	
			mouseClicked = false;
		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
