package APCSFinal;
//http://codehackersblog.blogspot.com/2015/07/sliding-puzzle-game-in-java.html
//http://inventwithpython.com/blog/2012/02/20/i-need-practice-programming-49-ideas-for-game-clones-to-code/
//http://inventwithpython.com/slidepuzzle.py
//https://www.cs.cmu.edu/~adamchik/15-121/labs/HW-7%20Slide%20Puzzle/lab.html
import javax.swing.JFrame; 
import javax.swing.SwingUtilities;
 
 
public class TileRunner {
        public static final int WIDTH = 512;
        public static final int HEIGHT = 512;
       
        public static JFrame gui;
       
        public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                       
                        @Override
                        public void run() {
                                gui = new JFrame("Sliding Puzzle");
                                gui.setUndecorated(true);
                                gui.setSize(WIDTH, HEIGHT);
                               
                                TGGui tilo = new TGGui();
                                gui.add(tilo);
                               
                                gui.setVisible(true);
                        }
                });
        }
}