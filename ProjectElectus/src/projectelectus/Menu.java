package projectElectus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static projectElectus.ErrorLog.writeTo;

/**
 * This class creates the Menu frame when it is created as an object.  It also monitors whether the user 
 * clicks one of the buttons and creates the new Credits, Game and Tutorials accordingly, or exits the program.
 * @author Jack Baumann
 */
public class Menu extends JFrame implements MouseListener, Runnable {
    public Map<String, String> LogIn = new TreeMap<String, String>(){};
    private boolean[] key;
    private boolean mouse;
    private BufferedImage back;
    private MouseEvent mouseE;
    private Platform background = new Platform(0, 0, 0, 0, "MAIN MENU.gif", "background");
    private ArrayList<projectElectus.Entity> entityList = new ArrayList<>();
    private Scanner fileIn;
    /**
     * This constructor creates an object of the Menu class, sets the 
     * size of the frame, adds a Mouse Listener, sets the background color to black, 
     * and shows and updates the frame.
     */
    public Menu(){
        super("Project Electus");
	setSize(800,600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        setBackground(Color.BLACK);
        setVisible(true);
		
        new Thread(this).start();
    }
    /**
     * This method updates drawing on the screen.
     * @param window - the window to draw the Menu onto
     */
    @Override
    public void update(Graphics window)
    {
        paint(window);
    }
    /**
     * This method paints the drawing on the screen.
     * @param window - the window to draw the Menu onto
     */
    @Override
    public void paint(Graphics window)
    {
        background.drawI(window);
    }
    /**
     * This method overrides the MouseListener class method to detect when the user clicks the mouse.  
     * If the user clicks a menu button, then the corresponding option will run.
     * @param e - what the mouse is doing
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        Rectangle newGame = new Rectangle(312,130,212,59);
        Rectangle loadGame = new Rectangle(312,216,212,59);
        Rectangle instructions = new Rectangle(312,299,212,59);
        Rectangle credit = new Rectangle(312,383,212,59);
        Rectangle exit = new Rectangle(312,470,212,59);

        if(newGame.contains(e.getPoint()))
        {
            this.dispose();
            GameRunner game = new GameRunner();
        }
        if(loadGame.contains(e.getPoint()))
        {
            this.dispose();
            try
            {
                GameRunner game = new GameRunner(fileIn = new Scanner(new FileInputStream("Saves\\Saves.txt")));
            }
            catch(Exception x)
            {
                JOptionPane.showMessageDialog(null, "Unable to load in Menu.java " + x);
                writeTo("Unable to load in Menu.java  " + x);
            }
        }
        if(instructions.contains(e.getPoint()))
        {
            this.dispose();
            Instructions instruct = new Instructions();
        }
        if(credit.contains(e.getPoint()))
        {
            this.dispose();
            Credits credits = new Credits();
        }
        if(exit.contains(e.getPoint()))
        {
            System.exit(0);
            ErrorLog.close();
        }
    }
    /**
     * This method overrides the MouseListener class method to detect when the user holds the mouse button down.
     * @param e - what the mouse is doing
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
         mouse = true;
    }
    /**
     * This method overrides the MouseListener class method to detect when the user releases the mouse button after pressing it.
     * @param e - what the mouse is doing
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {
        mouse = false;
    }
    /**
     * This method overrides the MouseListener class method to detect when the user moves the mouse in the window.
     * @param e - what the mouse is doing
     */
    @Override
    public void mouseEntered(MouseEvent e){}
    /**
     * This method overrides the MouseListener class method to detect when the user moves the mouse out of the window.
     * @param e - what the mouse is doing
     */
    @Override
    public void mouseExited(MouseEvent e){}
    /**
     * This method continues to repaint the canvas window as long as the game is still open and running, and there are no errors or exceptions.
     */
    @Override
    public void run()
    {
        try
   	{
            while(true)
            {
                Thread.currentThread().sleep(8);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unable to run " + e);
            ErrorLog.writeTo("Unable to run credits " + e);
        }
    }
}