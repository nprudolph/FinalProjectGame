package APCSFinal;

import javax.swing.JFrame; 
import javax.swing.SwingUtilities;
 
 
public class TileRunner {
        public static final int WIDTH = 512;
        public static final int HEIGHT = 512;
        public static JFrame gui;
        public static void main(String[] args) {
            gui = new JFrame("Sliding Puzzle");
            gui.setUndecorated(true);
            gui.setSize(WIDTH, HEIGHT);
            TileGui tilo = new TileGui();
            gui.add(tilo);
            gui.setVisible(true);
        }
}