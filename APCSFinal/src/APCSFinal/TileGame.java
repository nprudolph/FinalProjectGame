package APCSFinal;

import java.awt.event.KeyEvent;
import java.util.Random;
 
 
public class TileGame {
        private int width;
        private int difficulty;
        private int[][] board;
        private int zX, zY;
        private int forbidden;
       
        public TileGame(int width, int difficulty) {
                this.width = width;
                this.difficulty = difficulty;
               
                board = new int[width][width];
               
                int ctr = 1;
                for(int i = 0; i < width; i++) {
                        for(int j = 0; j < width; j++) {
                                board[j][i] = ctr++;
                        }
                }
                board[width - 1][width - 1] = 0;
                zX = width - 1;
                zY = width - 1;
                forbidden = 2;
               
                shuffle();
        }
       
        private void shuffle() {
                Random random = new Random();
                int i = 0;
                while(i < difficulty) {
                        int v = random.nextInt(4);
                       
                        switch(v) {
                        case 1:
                                if(up() && forbidden != 1) {
                                        i++;
                                        forbidden = 2;
                                }
                                break;
                        case 2:
                                if(down() && forbidden != 2) {
                                        i++;
                                        forbidden = 1;
                                }
                                break;
                        case 3:
                                if(left() && forbidden != 3) {
                                        i++;
                                        forbidden = 4;
                                }
                                break;
                        case 4:
                                if(right() && forbidden != 4) {
                                        i++;
                                        forbidden = 3;
                                }
                                break;
                        }
                }
        }
       
        private boolean up() {
                if(zY > 0) {
                        board[zX][zY] = board[zX][zY - 1];
                        board[zX][zY - 1] = 0;
                        zY--;
                        return true;
                }
                return false;
        }
        private boolean down() {
                if(zY < width - 1) {
                        board[zX][zY] = board[zX][zY + 1];
                        board[zX][zY + 1] = 0;
                        zY++;
                        return true;
                }
                return false;
        }
        private boolean left() {
                if(zX > 0) {
                        board[zX][zY] = board[zX - 1][zY];
                        board[zX - 1][zY] = 0;
                        zX--;
                        return true;
                }
                return false;
        }
        private boolean right() {
                if(zX < width - 1) {
                        board[zX][zY] = board[zX + 1][zY];
                        board[zX + 1][zY] = 0;
                        zX++;
                        return true;
                }
                return false;
        }
       
        public boolean isCorrect() {
                int ctr = 1;
                for(int i = 0; i < width; i++) {
                        for(int j = 0; j < width; j++) {
                                if(board[j][i] == ctr++ || (i == width - 1 && j == width - 1))
                                        continue;
                                else
                                        return false;
                        }
                }
                return true;
        }
       
        public int getValueAt(int x, int y) {
                if(x >= 0  && x <= width - 1 && y >= 0 && y <= width-1) {
                        return board[x][y];
                }
                return 0;
        }
       
        public void keyPressed(int key) {
                switch(key) {
                case KeyEvent.VK_UP:
                        up();
                        break;
                case KeyEvent.VK_DOWN:
                        down();
                        break;
                case KeyEvent.VK_LEFT:
                        left();
                        break;
                case KeyEvent.VK_RIGHT:
                        right();
                        break;
                }
        }
}