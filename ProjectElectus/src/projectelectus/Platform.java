package projectElectus;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This class creates and manages any Platforms in the game. Entity.Java extends Platform.java, and all Enemies, Entities, and Characters are Platforms.
 * @author Jack Baumann and Micheal Peterson
 */
public class Platform implements Locatable
{
    private double xPos, yPos, width, height;
    private String name;
    private Color color;
    private Rectangle rect;
    private Image sprite;

    /**
     * This constructor creates a Platform at a given location, with a specific given height and width, and names the Platform object.
     * @param x - x-coordinate of the Platform
     * @param y - y-coordinate of the Platform
     * @param w - width of the Platform
     * @param h - height of the Platform
     * @param n - name of the Platform
     */
    public Platform(double x, double y, double w, double h, String n){
        xPos = x;
	yPos = y;
	width = w;
	height = h;
	name = n;
	rect= new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    /**
     * This constructor creates a Platform at a given location, with a specific given height and width, and names the Platform object and its sprite.
     * @param x - x-coordinate of the Platform
     * @param y - y-coordinate of the Platform
     * @param w - width of the Platform
     * @param h - height of the Platform
     * @param fileName - name of the file where the Platform's sprite is stored
     * @param n - name of the Platform
     */
    public Platform(double x, double y, double w, double h, String fileName, String n){
        xPos = x;
	yPos = y;
	width = w;
	height = h;
	name = n;
	rect= new Rectangle((int)x, (int)y, (int)width, (int)height);
        try{sprite = new ImageIcon("Graphics\\" + fileName).getImage();}
        catch(Exception e){System.out.print(e);}
    }
    /**
     * This method sets the x coordinate on the canvas for the Platform.
     * @param x  - the x coordinate of the Platform
     */
    @Override
    public void setX(double x){
	xPos = x;
    }
    /**
     * This method sets the y coordinate on the canvas for the Platform.
     * @param y  - the y coordinate of the Platform
     */
    @Override
    public void setY(double y){
	yPos = y;
    }
    /**
     * This method sets the x and y coordinates on the canvas for the Platform.
     * @param x - the x coordinate of the Platform
     * @param y - the y coordinate of the Platform
     */
    @Override
    public void setPos(double x, double y){
	xPos = x;
	yPos = y;
    }
    /**
     * This method sets the width of the Platform when it appears on the canvas.
     * @param w - the width of the Platform
     */
    public void setWidth(double w){
	width = w;
    }
    /**
     * This method sets the height of the Platform when it appears on the canvas.
     * @param h - the height of the Platform
     */
    public void setHeight(double h){
	height = h;
    }
    /**
     * This method sets the color of the Platform when it appears on the canvas.
     * @param col - the color of the Platform
     */
    public void setColor(Color col){
	color = col;
    }
    /**
     * This method sets the name of the Platform.
     * @param newName - the name of the Platform
     */
    public void setName(String newName){
	name = newName;
    }
    /**
     * This method sets the name of the sprite to the given string.
     * @param file - the name of the Platform's sprite
     */
    public void setSprite(String file)
    {
        try{sprite = new ImageIcon("Graphics\\" + file).getImage();}
        catch(Exception e){System.out.print(e);}
    }
    /**
     * This method sets the sprite of the Platform to the given image.
     * @param file - the sprite of the Platform
     */
    public void setSprite(Image file)
    {
        try{sprite = file;}
        catch(Exception e){System.out.print(e);}
    }
    /**
     * This method returns the x coordinate of the Platform.
     * @return the x coordinate of the Platform
     */
    @Override
    public double getX(){
        return xPos;
    }
    /**
     * This method returns the x coordinate of the Platform.
     * @return the x coordinate of the Platform
     */
    @Override
    public double getY(){
	return yPos;
    }
    /**
     * This method returns the width of the Platform.
     * @return the width of the Platform
     */
    public double getWidth(){
	return width;
    }
    /**
     * This method returns the height of the Platform.
     * @return the height of the Platform
     */
    public double getHeight(){
    	return height;
    }
    /**
     * This method returns the color of the Platform.
     * @return the color of the Platform
     */
    public Color getColor(){
	return color;
    }
    /**
     * This method returns the name of the Platform.
     * @return the name of the Platform
     */
    public String getName(){
	return name;
    }
    /**
     * This method returns the Rectangular object of the Platform.
     * @return the rectangle of the Platform's area
     */
    public Rectangle getRect(){
	return rect;
    }
    /**
     * This method draws the Platform in the given window. It sets the platform to its stored color, and then fills in a rectangle and redefines rect.
     * @param window - the window to draw the platform on
     */
    public void draw(Graphics window){
        window.setColor(color);
        window.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
        rect= new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
    /**
     * This method draws the Platform in the given window. It sets the platform to its given color, and then fills in a rectangle and redefines rect.
     * @param window - the window to draw the platform on
     * @param col - the color of the rectangle
     */
    public void draw(Graphics window, Color col){
        window.setColor(col);
        window.fillRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
        rect= new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
    /**
     * This method draws the Platform's sprite to the given window. It throws and error if it can not load the sprite. Lastly, it redefines rect.
     * @param window - the window to draw the Platform on
     */
    public void drawI(Graphics window){
        try
        {
                window.drawImage(sprite, (int)getX(), (int)getY(), null);
        }
        catch(Exception e)
        {
                JOptionPane.showMessageDialog(null, "Unable to load image" + e);
        }
        rect= new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
    /**
     * This method tests two Platforms to see if they are the same Platform.
     * @param obj - the object to compare to the Platform
     * @return true or false depending on whether the two Platforms are the same or not the same.
     */
    public boolean equals(Object obj){
        return obj == this;
    }
}