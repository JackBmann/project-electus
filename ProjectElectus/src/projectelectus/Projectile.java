package projectElectus;

/**
 * This class creates and manages any Projectiles in the game.  The Character's attacks are projectiles.
 * @author Jack Baumann and Micheal Peterson
 */
public class Projectile extends Entity
{
    private double ogXSpeed, ogYSpeed;
    /**
     * This constructor creates a Projectile at a given location, with a specific 
     * given height and width, names the Projectile object, and sets the Projectile's speed,
     * @param x - coordinate of the Projectile
     * @param y - y-coordinate of the Projectile
     * @param w - width of the Projectile
     * @param h - height of the Projectile
     * @param xS - the horizontal speed of the Projectile
     * @param yS - the vertical speed of the Projectile
     * @param f - name of the file where the Projectile's sprite is stored
     * @param n - name of the Projectile
     */
    public Projectile(double x, double y, double w, double h, int xS, int yS, String f, String n){
	super(x, y, w, h, xS, yS, f, n);
        ogXSpeed = xS;
        ogYSpeed = yS;
    }
    /**
     * This method will set the speed at which the Projectile moves horizontally.
     * @param newXSpeed - the speed the entity moves horizontally expressed as a double
     */
    public void setogXSpeed(double newXSpeed){
    	ogXSpeed = newXSpeed;
    }
    /**
     * This method will set the speed at which the Projectile moves vertically.
     * @param newYSpeed - the speed the entity moves vertically expressed as a double
     */
    public void setogYSpeed(double newYSpeed){
    	ogYSpeed = newYSpeed;
    }
    /**
     * This method will return the Projectile's stored horizontal speed.
     * @return the double ogXSpeed for the Projectile
     */
    public double getogXSpeed(){
    	return ogXSpeed;
    }
    /**
     * This method will return the Projectile's stored vertical speed.
     * @return the double ogYSpeed for the Projectile
     */
    public double getogYSpeed(){
    	return ogYSpeed;
    }
}