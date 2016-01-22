/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectElectus;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 0001049959
 */
public class Explosion extends Entity{
     private ArrayList<Image> explode = new ArrayList<Image>();
     private int size, damage;
     /**
      * This constructor creates an Explosion at a given location, with a specific given height and width, and names the Explosion object.
      * It also adds the sprites of the Explosion into an animation and saves the time the Explosion was created at.
      * @param x - x-coordinate of the Explosion
      * @param y - y-coordinate of the Explosion
      * @param w - width of the Explosion
      * @param h - height of the Explosion
      * @param s - the size of the Explosion
      * @param n - name of the Explosion
      */
     public Explosion(int x, int y, int w, int h, int s, int d, String n){
         super(x, y, w, h, n);
         try
         {
            explode.add(new ImageIcon("Graphics\\Explosion1.gif").getImage());
            explode.add(new ImageIcon("Graphics\\Explosion2.gif").getImage());
            explode.add(new ImageIcon("Graphics\\Explosion3.gif").getImage());
            explode.add(new ImageIcon("Graphics\\Explosion4.gif").getImage());
            explode.add(new ImageIcon("Graphics\\Explosion5.gif").getImage());
         }
         catch(Exception e)
         {
            JOptionPane.showMessageDialog(null, "Unable to load explosion Images" + e); 
            ErrorLog.writeTo("Unable to load explosion Images" + e);
         }
         size = s;
         setSavedTime(System.currentTimeMillis());
     }
     /**
      * This method manages the animation of the Explosion.  Depending on the 
      * computer's time, the Explosion will have a different sprite.
      * @param size - the size of the Explosion or stage that the Explosion is in the animating process.
      * @return true if the explosion still exists or false if it should be removed because the animation is complete
      */
     public boolean explode(int size)
     {
         if(System.currentTimeMillis() <= getSavedTime() + 60)
         {
             setSprite(explode.get(0));
             return true;             
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 120 && size > 1)
         {
            setSprite(explode.get(1));
             return true;           
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 180 && size > 2)
         {
             setSprite(explode.get(2));
             return true;             
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 240 && size > 3)
         {
             setSprite(explode.get(3));
             return true;
         }
         else if(System.currentTimeMillis() <= getSavedTime() + 300 && size > 4)
         {
             setSprite(explode.get(4));
             return true;
         }
         else{
             return false;
         }
     }
     
    /**
     * This method calculates and returns the value any one explosion attack will do.
     * @return the value an explosion attack will do
     */
    public int explosion(){
        int ex = (int)Math.ceil(Math.random() * damage);
        return ex;
    }
     /**
      * This method sets the size of the Explosion.
      * @param s  - the size of the Explosion
      */
     public void setSize(int s)
     {
         size = s;
     }
     /**
      * This method sets the damage of the Explosion.
      * @param s  - the damage of the Explosion
      */
     public void setDamage(int d)
     {
         damage = d;    
     }
     /**
      * This method returns the size of the Explosion.
      * @return the size of the Explosion
      */
     public int getSize()
     {
         return size;
     }
     /**
      * This method returns the damage of the Explosion.
      * @return the size of the Explosion
      */
     public int getDamage()
     {
         return damage;    
     }
}
