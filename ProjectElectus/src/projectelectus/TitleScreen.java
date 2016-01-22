package projectElectus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class creates the Title Screen frame when it is created as an object.  It also monitors whether the user 
 * clicks clicks to go to the Menu and creates a new Menu.
 * @author Jack Baumann
 */
public class TitleScreen extends JFrame implements MouseListener, Runnable {
    private boolean[] key;
    private boolean mouse;
    private BufferedImage back;
    private MouseEvent mouseE;
    private Platform background = new Platform(0, 0, 0, 0, "TITLE SCREEN.gif", "background");
    private ArrayList<projectElectus.Entity> entityList = new ArrayList<>();
   
    /**
     * This constructor creates an object of the TitleScreen class, sets the 
     * size of the frame, adds a Mouse Listener, sets the background color to black, 
     * and shows and updates the frame.
     */
    public TitleScreen(){
        super("Project Electus");
	setSize(800,600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        setBackground(Color.BLACK);
        setVisible(true);
		
        new Thread(this).start();
            
        ErrorLog.create();
    }
    /**
     * This method updates drawing on the screen.
     * @param window - the window to draw the Title Screen onto
     */
    @Override
    public void update(Graphics window)
    {
        paint(window);
    }
    /**
     * This method paints the drawing on the screen.
     * @param window - the window to draw the Title Screen onto
     */
    @Override
    public void paint(Graphics window){
        background.drawI(window);
    }
    /**
     * This method overrides the MouseListener class method to detect when the user clicks the mouse.  
     * If the user clicks the menu button, then a new Menu will be created.
     * @param e - what the mouse is doing
     */
    @Override
    public void mouseClicked(MouseEvent e)
    {
        Rectangle next = new Rectangle(293,517,249,65);

        if(next.contains(e.getPoint()))
        {
            this.dispose();
            Menu menu = new Menu();
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