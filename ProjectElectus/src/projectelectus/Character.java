package projectElectus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * This class creates and manages the player's character.
 * @author Jack Baumann and Micheal Peterson
 */
public class Character extends Entity
{
    private int health, hitDamage, projectileDamage, explosionDamage, 
            walkSpeed, runSpeed, explosionSize, expirence;
    private double projectileSpeed;
    private Rectangle vision = new Rectangle();
    private boolean fly = false;
    private long hitTime;
    private ArrayList<Image> left = new ArrayList<Image>();
    private ArrayList<Image> right = new ArrayList<Image>();
    public ArrayList<String> inventory = new ArrayList<String>();
    //public Set<String> powers = new TreeSet<String>(){};
    /**
     * This constructor creates a character at a given location, with a specific given 
     * height and width, names the character object, and colors the character white.
     * It also assigns the character health, damage, explosion, experience, and speed values.
     * @param x - x-coordinate of the character
     * @param y-coordinate of the character
     * @param w - width of the character
     * @param h - height of the character
     * @param n - name of the character
     */
    public Character(int x, int y, int w, int h, String n){
	super(x, y, w, h, n);
	health = 10;
	hitDamage = 10;
        projectileDamage = 20;
        explosionDamage = 25;
        explosionSize = 5;
	walkSpeed = 8;
	runSpeed = 10;
        projectileSpeed = 10;
        expirence = 0;
        setColor(Color.WHITE);
        try
        {
            left.add(new ImageIcon("Graphics\\Character\\Hero 3.png").getImage());
            left.add(new ImageIcon("Graphics\\Character\\Hero 4.png").getImage());
            left.add(new ImageIcon("Graphics\\Character\\Hero 5.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 3 R.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 4 R.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 5 R.png").getImage());
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(null, "Unable to load explosion Images" + e); 
            ErrorLog.writeTo("Unable to load explosion Images" + e);
         }
    }
    /**
     * This constructor creates a character at a given location, with a specific given 
     * height and width, names the character object, and colors the character white.
     * It also assigns the character health, damage, explosion, experience, and speed values.
     * @param x - x-coordinate of the character
     * @param y - coordinate of the character
     * @param w - width of the character
     * @param h - height of the character
     * @param f - name of the file where the character's sprite is stored
     * @param n - name of the character
     */
    public Character(int x, int y, int w, int h, String f, String n){
	super(x, y, w, h, f, n);
	health = 100;
	hitDamage = 10;
        projectileDamage = 10;
        explosionDamage = 25;
        explosionSize = 5;
	walkSpeed = 8;
	runSpeed = 10;
        projectileSpeed = 10;
        expirence = 0;
        setColor(Color.WHITE);
        try
        {
            left.add(new ImageIcon("Graphics\\Character\\Hero 3.png").getImage());
            left.add(new ImageIcon("Graphics\\Character\\Hero 4.png").getImage());
            left.add(new ImageIcon("Graphics\\Character\\Hero 5.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 3 R.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 4 R.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 5 R.png").getImage());
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(null, "Unable to load explosion Images" + e); 
            ErrorLog.writeTo("Unable to load explosion Images" + e);
         }
    }
    
    public Character(int x, int y, int w, int h, int life, boolean fly, String f, String n){
	super(x, y, w, h, f, n);
	health = life;
	hitDamage = 10;
        projectileDamage = 10;
        explosionDamage = 25;
        explosionSize = 5;
	walkSpeed = 10;
	runSpeed = 10;
        projectileSpeed = 10;
        expirence = 0;
        setFly(fly);
        setColor(Color.WHITE);
        try
        {
            left.add(new ImageIcon("Graphics\\Character\\Hero 3.png").getImage());
            left.add(new ImageIcon("Graphics\\Character\\Hero 4.png").getImage());
            left.add(new ImageIcon("Graphics\\Character\\Hero 5.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 3 R.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 4 R.png").getImage());
            right.add(new ImageIcon("Graphics\\Character\\Hero 5 R.png").getImage());
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(null, "Unable to load explosion Images" + e); 
            ErrorLog.writeTo("Unable to load explosion Images" + e);
         }
    }
    /**
     * This method sets the health of the character to the given value.
     * @param newHealth - the health value to be assigned
     */
    public void setHealth(int newHealth){
    	health = newHealth;
    }
    /**
     * This method sets the damage the character's attack does.
     * @param newHitDamage - the damage value to be assigned
     */
    public void setHitDamage(int newHitDamage){
    	hitDamage = newHitDamage;
    }
    /**
     * This method sets the speed that the character travels at.
     * @param newWalkSpeed - the speed that the character will travel at
     */
    public void setWalkSpeed(int newWalkSpeed){
    	walkSpeed = newWalkSpeed;
    }
    /**
     * This method sets the speed the character runs at.
     * @param newRunSpeed - the speed that the character will run at
     */
    public void setRunSpeed(int newRunSpeed){
    	runSpeed = newRunSpeed;
    }
    /**
     * This method sets the damage the character's projectile attack does.
     * @param p - the damage value to be assigned
     */
    public void setProjectileDamge(int p){
    	projectileDamage = p;
    }
    /**
     * This method sets the speed the projectile moves at.
     * @param p - the speed that the projectile will travel at
     */       
    public void setProjectileSpeed(double p){
    	projectileSpeed = p;
    }
    /**
     * This method sets the distance that the enemies can see the character from.
     * @param p - the distance that the enemies can see the character from
     */
    public void setVision(Rectangle vis){
    	vision = vis;
    }
    /**
     * This method allows the player to fly or to stop flying.
     * @param fl - whether the player is flying or not
     */
    public void setFly(boolean fl){
        fly = fl;
    }
    /**
     * This method sets the damage the character's explosion attack does.
     * @param x - the damage value to be assigned
     */
    public void setExplosionDamge(int x){
    	explosionDamage = x;
    }
    /**
     * This method sets the experience of the character to the given value.
     * @param x - the experience value to be assigned
     */
    public void setExpierence(int x){
    	expirence = x;
    }
    /**
     * This method sets the size of the character's explosion.
     * @param s - the size of the explosion
     */
    public void setExplosionSize(int s)
    {
        explosionSize = s;
    }
    /**
     * This method sets the time of the last time the enemy got hit.
     * @param time - the time of the last time the enemy got hit.
     */
    public void setHitTime(long time)
    {
         hitTime = time;
    }
     /**
     * This method returns the amount of health the character has.
     * @return the amount of health a character has
     */
    public int getHealth(){
    	return health;
    }
    /**
     * This method returns the amount of damage the character does.
     * @return the amount of damage a character does
     */
    public int getHitDamage(){
    	return hitDamage;
    }
    /**
     * This method returns the speed the character walks at.
     * @return the speed the character walks at
     */
    public int getWalkSpeed(){
    	return walkSpeed;
    }
    /**
     * This method returns the damage the character's projectile does.
     * @return the damage the character's projectile does
     */ 
    public int SetProjectileDamge(){
    	return projectileDamage;
    }
    /**
     * This method returns the speed the character's projectile moves at.
     * @return the speed the character's projectile moves at
     */
    public double getProjectileSpeed(){
    	return projectileSpeed;
    }
    /**
     * This method returns the damage the character's projectile does.
     * @return the damage the character's projectile does
     */   
    public double getExplosionDamage(){
    	return explosionDamage;
    }
    /**
     * This method returns the size of the character's explosion.
     * @return the size of the character's explosion
     */
    public int getExplosionSize(){
    	return explosionSize;
    }
    /**
     * This method returns the distance that the enemies can see the character from.
     * @return the distance that the enemies can see the character from
     */    
    public Rectangle getVision(){
    	return vision;
    }
    /**
     * This method returns whether the player is flying or not
     * @return whether the player is flying or not
     */
    public boolean getFly(){
        return fly;
    }
    /**
     * This method returns how much experience the character has.
     * @return how much experience the character has.
     */
    public int getExpierence(){
    	return expirence;
    }
    /**
     * This method returns the time of the last time the enemy got hit.
     * @return how much experience the character has.
     */
    public long getHitTime()
    {
          return hitTime;
    }
     /**
      * This method manages the animation of the Character moving right.  Depending on the 
      * computer's time, the Character will have a different sprite.
      * @return true if the animation cycle is still running
      */
    public boolean right()
     {
         if(System.currentTimeMillis() <= getSavedTime() + 180)
         {
             setSprite(right.get(0));
             return true;             
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 360)
         {
            setSprite(right.get(1));
             return true;           
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 440)
         {
             setSprite(right.get(2));
             return true;             
         }
         else{
             setSavedTime(System.currentTimeMillis());
             return false;
         }
     }
     /**
      * This method manages the animation of the Character moving left.  Depending on the 
      * computer's time, the Character will have a different sprite.
      * @return true if the animation cycle is still running
      */
     public boolean left()
     {
         if(System.currentTimeMillis() <= getSavedTime() + 180)
         {
             setSprite(left.get(0));
             return true;             
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 360)
         {
            setSprite(left.get(1));
             return true;           
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 440)
         {
             setSprite(left.get(2));
             return true;             
         }
         else{
             setSavedTime(System.currentTimeMillis());
             return false;
         }
     }
    /**
     * This method calculates and returns the value any one melee attack will do.
     * @return the value a melee attack will do
     */
    public int melee(){
        int melee = (int)Math.ceil(Math.random() * hitDamage);
        return melee;
    }
    /**
     * This method calculates and returns the value any one projectile attack will do.
     * @return the value a projectile attack will do
     */
    public int fire(){
        int fire = (int)Math.ceil(Math.random() * projectileDamage);
        return fire;
    }
}