package projectElectus;

import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;
/**
 * This class creates the game frame and canvas for the game. GameRunner.java then uses Game.java to continue game operations.
 * @author Jack Baumann and Michael Peterson
 */
public class GameRunner extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    /**
     * This constructor creates a JFrame with a width of WIDTH, a height of HEIGHT, and a name of "Project Electus", which will exit when it is closed.
     * It then creates and shows the Game in the frame.
     */
    public GameRunner()
    {
        super("Project Electus");
        setSize(WIDTH,HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Game game = new Game();
        ((Component) game).setFocusable(true);
	getContentPane().add(game);
	
        setVisible(true);
    }
    /**
     * This constructor creates a JFrame with a width of WIDTH, a height of HEIGHT, and a name of "Project Electus", which will exit when it is closed.
     * It then creates and shows the Game in the frame with the loaded save values.
     * @param load - the Scanner to scan the save file with
     */
    GameRunner(Scanner load)
    {
        super("Project Electus");
        setSize(WIDTH,HEIGHT);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Game game = new Game(load);
        ((Component) game).setFocusable(true);
	getContentPane().add(game);
	
        setVisible(true);
    }
}