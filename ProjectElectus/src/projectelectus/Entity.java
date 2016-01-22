package projectElectus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
/**
 * This class creates and manages any entities in the game. Enemies and the Character are entities.
 * @author Jack Baumann and Michael Peterson
 */
public class Entity extends Platform
{
    private double xSpeed, ySpeed;
    private long savedTime;
    /**
     * This constructor creates an entity at a given location, with a specific 
     * given height and width, names the entity object, and sets the entity's speed,
     * and colors the entity red.
     * @param x - coordinate of the entity
     * @param y - y-coordinate of the entity
     * @param w - width of the entity
     * @param h - height of the entity
     * @param n - name of the entity
     */
    public Entity(double x, double y, double w, double h, String n){
	super(x, y, w, h, n);
	xSpeed = 0;
	ySpeed = 0;
    }
    /**
     * This constructor creates an entity at a given location, with a specific 
     * given height and width, names the entity object, and sets the entity's speed,
     * and colors the entity red.
     * @param x - coordinate of the entity
     * @param y - y-coordinate of the entity
     * @param w - width of the entity
     * @param h - height of the entity
     * @param f - name of the file where the entity's sprite is stored
     * @param n - name of the entity
     */
    public Entity(double x, double y, double w, double h, String f, String n){
	super(x, y, w, h, f, n);
	xSpeed = 0;
	ySpeed = 0;
    }
    /**
     * This constructor creates an entity at a given location, with a specific 
     * given height and width, names the entity object, and sets the entity's speed,
     * and colors the entity red.
     * @param x - coordinate of the entity
     * @param y - y-coordinate of the entity
     * @param w - width of the entity
     * @param h - height of the entity
     * @param xS - the x speed of the entity
     * @param yS - the y speed of the entity
     * @param f - name of the file where the entity's sprite is stored
     * @param n - name of the entity
     */
    public Entity(double x, double y, double w, double h, double xS, double yS, String f, String n){
	super(x, y, w, h, f, n);
	xSpeed = xS;
	ySpeed = yS;
        setColor(Color.RED);
    }
    /**
     * This method will set the speed at which the entity moves horizontally.
     * @param newXSpeed - the speed the entity moves horizontally expressed as a double
     */
    public void setXSpeed(double newXSpeed){
    	xSpeed = newXSpeed;
    }
    /**
     * This method will set the speed at which the entity moves vertically.
     * @param newYSpeed - the speed the entity moves vertically expressed as a double
     */
    public void setYSpeed(double newYSpeed){
    	ySpeed = newYSpeed;
    }
    /**
     * This method will save the time during the use of animations.
     * @param time - the time the animation occurs during
     */
    public void setSavedTime(long time)
    {
        savedTime = time;
    }
    /**
     * This method will return the entity's stored xSpeed.
     * @return the double xSpeed for the entity
     */
    public double getXSpeed(){
    	return xSpeed;
    }
    /**
     * This method will return the entity's stored ySpeed.
     * @return the double ySpeed for the entity
     */
    public double getYSpeed(){
    	return ySpeed;
    }
    /**
     * This method will return stored savedTime used with animations.
     * @return the savedTime used with animations
     */    
    public long getSavedTime()
    {
        return savedTime;
    }
    /**
     * This method calculates and returns the composite x and y speeds used to 
     * interpret the entity's movement.
     * @return the composite speed of the entity
     */
    public double getCompSpeed(){
    	return Math.sqrt(Math.pow(ySpeed, 2) + Math.pow(xSpeed, 2));
    }
    /**
     * This method will draw the entity in a new position on the given window. 
     * The new position will correspond with its xSpeed, or horizontal movement 
     * value, and its ySpeed, or vertical movement value.
     * @param window - the window the entity will be drawn on
     */
    public void moveAndDraw(Graphics window)
    {
        draw(window, Color.BLACK);
        setY(getY() - ySpeed);
        setX(getX() - xSpeed);
        draw(window, getColor());
    }
    /**
     * This method will draw the entity with a given image in a new position on 
     * the given window. The new position will correspond with its xSpeed, or 
     * horizontal movement value, and its ySpeed, or vertical movement value.
     * @param window - the window the entity will be drawn on
     */ 
    public void moveAndDrawI(Graphics window)
    {
        setY(getY() - ySpeed);
        setX(getX() - xSpeed);
        drawI(window);
    }
    /**
     * This method checks whether the platform is touching the given rectangle.
     * @param r - rectangle to check for contact with
     * @return true or false respective to whether it is touching the given rectangle
     */
    public boolean contact(Rectangle r)
    {
    	return this.getRect().intersects(r);
    }
    /**
     * This method checks whether the given entity is touching the top of another entity.
     * @param e - entity to check for contact with
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactUp(Entity e)
    {
        return this.getRect().intersectsLine(e.getRect().x, e.getRect().y + e.getRect().height,
                e.getRect().x + e.getRect().width, e.getRect().y + e.getRect().height);
    }
    /**
     * This method checks whether the given entity is touching the bottom of another entity.
     * @param e - entity to check for contact with
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactDown(Entity e)
    {
        return this.getRect().intersectsLine(e.getRect().x, e.getRect().y,
                e.getRect().x + e.getRect().width, e.getRect().y);
    }
    /**
     * This method checks whether the given entity is touching the left of another entity.
     * @param e - entity to check for contact with
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactLeft(Entity e)
    {
        return this.getRect().intersectsLine(e.getRect().x + e.getRect().width, e.getRect().y,
                e.getRect().x + e.getRect().width, e.getRect().y + e.getRect().height);
    }
    /**
     * This method checks whether the given entity is touching the right of another entity.
     * @param e - entity to check for contact with
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactRight(Entity e)
    {
        return this.getRect().intersectsLine(e.getRect().x, e.getRect().y,
                e.getRect().x, e.getRect().y + e.getRect().height);
    }
    /**
     * This method checks whether the entity is touching the top of any entity in the list
     * @param stuff - list of entities to check to see if they are touching
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactAnyUp(ArrayList<Entity> stuff)
    {
        for(Entity e: stuff)
        {
             if(this.contactUp(e))
                 return true;
        }      
        return false;
    }
    /**
     * This method checks whether the entity is touching the bottom of any entity in the list
     * @param stuff - list of entities to check to see if they are touching
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactAnyDown(ArrayList<Entity> stuff)
    {
        for(Entity e: stuff)
        {
             if(this.contactDown(e))
                 return true;
        }      
        return false;
    }
    /**
     * This method checks whether the entity is touching the left of any entity in the list
     * @param contacted - list of entities to check to see if they are touching
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactAnyLeft(ArrayList<Entity> contacted)
    {
        for(Entity e: contacted)
        {
             if(this.contactLeft(e))
                 return true;
        }      
        return false;
    }
    /**
     * This method checks whether the entity is touching the right of any entity in the list
     * @param contacted - list of entities to check to see if they are touching
     * @return true or false respective to whether the given entity is touching another entity
     */
    public boolean contactAnyRight(ArrayList<Entity> contacted)
    {
        for(Entity e: contacted)
        {
             if(this.contactRight(e))
                 return true;
        }      
        return false;
    }
}