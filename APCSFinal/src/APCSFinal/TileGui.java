package APCSFinal;

import java.awt.Color; 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
 

import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
 
public class TileGui extends JPanel {
 
        private static int size = 4;
        private static final int FONT_SIZE = 40;
        private static int difficulty = 1000;
       
        private TileGame game;
        private Font font;
        private Color backgroundColor, numColor, borderColor;
       
        private int slotWidth, slotHeight, slotXOffset, slotYOffset;
        //for moving windown when clicked and dragged
        private int winX, winY, boardX, boardY;
        private boolean winmoved;
       
        public TileGui() {
                game = new TileGame(size, difficulty);
                font = new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE);
               
                slotWidth = TileRunner.WIDTH / size;
                slotHeight = TileRunner.HEIGHT / size;
                slotXOffset = slotWidth / 2 - FONT_SIZE / 4;
                slotYOffset = slotHeight / 2 + FONT_SIZE / 3;
               
                backgroundColor = new Color(153,0,255);
                numColor = new Color(255,173,51);
                borderColor = new Color(0, 0, 102);
                winmoved = false;
               
                setFocusable(true);
                requestFocus();
               
                //moves window -- change to drawwindow
                /*public void paint(Graphics window)
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
            		}*/
                
                //window moves when clicked
                addMouseMotionListener(new MouseMotionAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                                if(winmoved) {
                                        winX = e.getXOnScreen() - boardX;
                                        winY = e.getYOnScreen() - boardY;
                                        TileRunner.gui.setLocation(winX, winY);
                                }
                                else {
                                        winmoved = true;
                                        boardX = e.getX();
                                        boardY = e.getY();
                                }
                        }
                       
                        @Override
                        public void mouseMoved(MouseEvent e) {
                                winmoved = false;
                        }
                });
               
                
                addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                                int key = e.getKeyCode();
                                game.keyPressed(key);
                                repaint();
                                if(game.isCorrect()) {
                                  //add option box
                                	int y = 0;
                                	int n = 1;
                                	int restart = JOptionPane.showConfirmDialog(TileRunner.gui, "Play again","End game", JOptionPane.YES_NO_OPTION);
                                	if (restart == JOptionPane.NO_OPTION){
                                        System.exit(0);
                                	}
                                	difficulty+= 10;
                                	//size+=1;
                                	game = new TileGame(size, difficulty);
                                	repaint();                                        
                                }
                        }
                });
        }
       
        @Override
        public void paint(Graphics g) {
                Graphics2D board = (Graphics2D)g;
                board.setFont(font);
                board.setColor(backgroundColor);
                board.fillRect(0, 0, getWidth(), getHeight());
                drawBorders(board);
               
                board.setColor(numColor);
                for(int r = 0; r < 4; r++) {
                        for(int c = 0; c < 4; c++) {
                                if(game.getSpot(r, c) != 0)
                                        board.drawString(""+game.getSpot(r, c), slotXOffset + r * slotWidth, slotYOffset + c * slotHeight);
                        }
                }
        }
        private void drawBorders(Graphics2D board) {
                board.setColor(borderColor);
                for(int i = 0; i < 3; i++)
                        board.drawRect(i, i, TileRunner.WIDTH - 1 - 2 * i, TileRunner.HEIGHT - 1 - 2 * i);
               
                for(int  i = 1; i < 4; i++) {
                        int level = i * slotHeight;
                        board.drawLine(0, level, TileRunner.WIDTH, level);
                        board.drawLine(0, level + 1, TileRunner.WIDTH, level + 1);
                        board.drawLine(0, level + 2, TileRunner.WIDTH, level + 2);
 
                        board.drawLine(level, 0, level, TileRunner.HEIGHT);
                        board.drawLine(level + 1, 0, level + 1, TileRunner.HEIGHT);
                        board.drawLine(level + 2, 0, level + 2, TileRunner.HEIGHT);
                }
        }
}