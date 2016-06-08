package APCSFinal;

import java.awt.event.KeyEvent;
import java.util.Random;
 
 
public class TileGame {
        private int width;
        private int difficulty;
        private int[][] board;
        private int gridX, gridY;
        private int outofbounds;
       
        public TileGame(int width, int difficulty) {
                this.width = width;
                this.difficulty = difficulty;
               
                board = new int[width][width];
                
                int tileval = 1;
                for(int r = 0; r < width; r++) {
                        for(int c = 0; c < width; c++) {
                                board[c][r] = tileval++;
                        }
                }
                board[width - 1][width - 1] = 0;
                gridX = width - 1;
                gridY = width - 1;
                //keeps
                outofbounds = 2;
               
                shuffle();
        }
       
        private void shuffle() {
                Random rand = new Random();
                for(int i=0;i < difficulty;i++) {
                        int t = rand.nextInt(4);
                        if(t==1){
                        	up();
                        }
                        else if(t==2){
                        	down();
                        }
                        else if(t==3){
                        	left();
                        }
                        else if(t==4){
                        	right();
                        }       
                }
        }
       
        //move empty tile in each direction
        private boolean up() {
                if(gridY > 0) {
                        board[gridX][gridY] = board[gridX][gridY - 1];
                        board[gridX][gridY - 1] = 0;
                        gridY--;
                        return true;
                }
                return false;
        }
        private boolean down() {
                if(gridY < width - 1) {
                        board[gridX][gridY] = board[gridX][gridY + 1];
                        board[gridX][gridY + 1] = 0;
                        gridY++;
                        return true;
                }
                return false;
        }
        private boolean left() {
                if(gridX > 0) {
                        board[gridX][gridY] = board[gridX - 1][gridY];
                        board[gridX - 1][gridY] = 0;
                        gridX--;
                        return true;
                }
                return false;
        }
        private boolean right() {
                if(gridX < width - 1) {
                        board[gridX][gridY] = board[gridX + 1][gridY];
                        board[gridX + 1][gridY] = 0;
                        gridX++;
                        return true;
                }
                return false;
        }
       
        public boolean isCorrect() {
                int ctr = 1;
                for(int i = 0; i < width; i++) {
                        for(int j = 0; j < width; j++) {
                                if(board[j][i] == ctr++ || (i == width - 1 && j == width - 1)){
                                        continue;
                                }
                                else{
                                	return false;
                            }
                    }
            }
                return true;
        }
       
        public int getSpot(int x, int y) {
        	if(x >= 0  && x <= width - 1 && y >= 0 && y <= width-1) {
        		return board[x][y];
            }
            return 0;
        }
       
        public void keyPressed(int key) {
                
                if(key==KeyEvent.VK_UP){
                        up();
                }
                else if(key==KeyEvent.VK_DOWN){
                        down();
                }
                else if(key==KeyEvent.VK_LEFT){
                        left();
        		}
                else if(key==KeyEvent.VK_RIGHT){
                        right();
                }
        }
}