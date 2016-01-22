package projectElectus;

/**
 * This class creates and manages the enemies in the game.
 * @author Jack Baumann
 */
public class Enemy extends Entity 
{
    private int maxHealth, health, hitDamage, walkSpeed; 
    private long hitTime;
    private String enemyType;
    
    /**
     * This constructor creates an enemy at a given location, with a specific 
     * given height, width, speed, and damage, and names the enemy object.
     * @param x - x-coordinate of the enemy
     * @param y - y-coordinate of the enemy
     * @param w - width of the enemy
     * @param h - height of the enemy
     * @param n - name of the enemy
     */
    public Enemy(int x, int y, int w, int h, String n){
	super(x, y, w, h, n);
	health = 100;
        maxHealth = 100;
	hitDamage = 5;
	walkSpeed = 5;
    }    
    /**
     * This constructor creates an enemy at a given location, with a specific given 
     * height, width, speed, and damage, and names the enemy object as well as its location.
     * @param x - x-coordinate of the enemy
     * @param y - y-coordinate of the enemy
     * @param w - width of the enemy
     * @param h - height of the enemy
     * @param f - name of the file where the entity's sprite is stored
     * @param n - name of the enemy
     */
    public Enemy(int x, int y, int w, int h, String f, String n){
	super(x, y, w, h, f, n);
	health = 100;
        maxHealth = 100;
	hitDamage = 5;
	walkSpeed = 5;
        enemyType = "Basic";
    }
    /**
     * This constructor creates an enemy at a given location, with a specific given 
     * height, width, speed, and damage, and names the enemy object as well as its location.
     * @param x - x-coordinate of the enemy
     * @param y - y-coordinate of the enemy
     * @param w - width of the enemy
     * @param h - height of the enemy
     * @param life - health of the enemy
     * @param f - name of the file where the entity's sprite is stored
     * @param n - name of the enemy
     */
    public Enemy(int x, int y, int w, int h, int life, String f, String n){
	super(x, y, w, h, f, n);
	health = life;
        maxHealth = 100;
	hitDamage = 5;
	walkSpeed = 5;
        enemyType = "Basic";
    }
    /**
     * This constructor creates an enemy at a given location, with a specific given 
     * height, width, speed, and damage, and names the enemy object as well as its location.
     * @param x - x-coordinate of the enemy
     * @param y - y-coordinate of the enemy
     * @param w - width of the enemy
     * @param h - height of the enemy
     * @param life - health of the enemy
     * @param t - type of enemy
     * @param f - name of the file where the entity's sprite is stored
     * @param n - name of the enemy
     */
    public Enemy(int x, int y, int w, int h, int life, String t, String f, String n){
	super(x, y, w, h, f, n);
	health = life;
        maxHealth = 100;
	hitDamage = 5;
	walkSpeed = 5;
        enemyType = t;
    }
    /**
     * This method sets the health of the enemy to the given value.
     * @param newHealth - the health value to be assigned
     */
    public void setHealth(int newHealth){
    	health = newHealth;
    } 
    /**
     * This method sets the enemy's original health value.
     * @param mH - the enemy's original health value
     */
    public void setMaxHealth(int mH){
    	maxHealth = mH;
    }
    /**
     * This method sets the damage the enemy's attack does.
     * @param newHitDamage - the damage value to be assigned
     */
    public void setHitDamage(int newHitDamage){
    	hitDamage = newHitDamage;
    }
    /**
     * This method sets the speed that the enemy travels at.
     * @param newWalkSpeed - the speed that the enemy will travel at
     */
    public void setWalkSpeed(int newWalkSpeed){
    	walkSpeed = newWalkSpeed;
    }
    /**
     * This method sets the time of the last instance the enemy got hit.
     * @param time - the time of the last instance the enemy got hit.
     */
    public void setHitTime(long time)
    {
         hitTime = time;
    }
    /**
     * This method sets the type of enemy this instance is
     * @param type - String of the type of enemy
     */
    public void setEnemyType(String type)
    {
         enemyType = type;
    }
    /**
     * This method returns the enemy's current health value.
     * @return the enemy's current  health value
     */
    public int getHealth(){
    	return health;
    }
    /**
     * This method returns the enemy's original health value.
     * @return the enemy's original health value
     */
    public int getMaxHealth(){
    	return maxHealth;
    }
    /**
     * This method returns the amount of damage the enemy does.
     * @return the amount of damage a character does
     */
    public int getHitDamage(){
    	return hitDamage;
    }
    /**
     * This method returns the speed the enemy walks at.
     * @return the speed the character walks at
     */
    public int getWalkSpeed(){
    	return walkSpeed;
    }
    /**
     * This method returns the time of the last instance the enemy got hit.
     * @return the speed the character walks at
     */
    public long getHitTime()
    {
          return hitTime;
    }
    /**
     * This method returns the type of enemy
     * @return the speed the character walks at
     */
    public String getEnemyType()
    {
         return enemyType;
    }

}