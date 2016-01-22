package projectElectus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static projectElectus.ErrorLog.writeTo;
import static projectElectus.Game.bwFile;

public class Game extends JComponent implements KeyListener, MouseListener, Runnable
{
   public static BufferedWriter bwFile;
   //public Map<String, String> LogIn = new TreeMap<String, String>(){};
   private boolean[] key;
   private boolean mouse;
   private BufferedImage back;
   private MouseEvent mouseE;
   private Character test;
   public boolean collide = true;
   public int level;
   
   private Entity plat1, plat2, plat3, plat4, plat5, plat6, plat7, plat8, plat9, plat10, 
           plat11, plat12, plat13, plat14, plat15, plat16, plat17, plat18, plat19,
           plat20, plat21, plat22, background;

   
   private Enemy enemy, enemy1, enemyX;

   private ArrayList<Entity> backgrounds = new ArrayList<>();
   private ArrayList<Entity> entityList = new ArrayList<>();
   private ArrayList<Enemy> enemyList = new ArrayList<>();
   private ArrayList<Projectile> projectiles = new ArrayList<>();
   private ArrayList<Projectile> enemyProjectiles = new ArrayList<>();
   private ArrayList<Explosion> explosions = new ArrayList<>();
   
   private ArrayList<Entity> trashEntity = new ArrayList<>();
   private ArrayList<Enemy> trashEnemy = new ArrayList<>();
   private ArrayList<Projectile> trashProjectiles = new ArrayList<>();
   private ArrayList<Projectile> trashEnemyProjectiles = new ArrayList<>(); 
   private ArrayList<Explosion> trashExplosions = new ArrayList<>();
   
    /**
     * Constructs an object of the Game class. Initiates the key array, sets the
     * background color, adds the Key Listener, adds and instantiates all entities,
     * characters, and the background.
     */
   public Game()
   {
		key = new boolean[8];

                setBackground(Color.BLACK);
		setVisible(true);
		
                this.addMouseListener(this);
		new Thread(this).start();
		addKeyListener(this);
                
                background = new Entity(0, 0, 3200, 1200, "ElectriCo1.gif", "background");
                
                test = new Character(350, 250, 68, 60, "Character\\Hero 1.png", "Main");
                
                enemy = new Enemy(200, 440, 50, 63, 100, "RobotBlue.gif", "enemy");
                enemy1 = new Enemy(300, 440, 50, 63, 100, "Range", "RobotBlue.gif", "enemy1");
                enemyX = new Enemy(500, 440, 50, 63, 100, "Explosive", "RobotYellow.gif", "enemyX");
                
                plat1 = new Entity(0, 810, 3200, 15, "", "plat1");
                plat2 = new Entity(162, 702, 50, 15, "", "plat2");
                plat3 = new Entity(255, 590, 50, 15, "", "plat3");
                plat4 = new Entity(378, 658, 50, 15, "", "plat4");
                plat5 = new Entity(484, 759, 50, 15, "", "plat5");
                plat6 = new Entity(634, 682, 50, 15, "", "plat6");
                plat7 = new Entity(802, 598, 50, 15, "", "plat7");
                plat8 = new Entity(903, 719, 50, 15, "", "plat8");
                plat9 = new Entity(1050, 631, 50, 15, "", "plat9");
                plat10 = new Entity(1163, 737, 50, 15, "", "plat10");
                plat11 = new Entity(1409, 646, 50, 15, "", "plat11");
                plat12 = new Entity(1711, 736, 50, 15, "", "plat12");
                plat13 = new Entity(1843, 603, 50, 15, "", "plat13");
                plat14 = new Entity(2030, 590, 50, 15, "", "plat14");
                plat15 = new Entity(2060, 712, 50, 15, "", "plat15");
                plat16 = new Entity(2236, 636, 50, 15, "", "plat16");
                plat17 = new Entity(2357, 732, 50, 15, "", "plat17");
                plat18 = new Entity(2530, 634, 50, 15, "", "plat18");
                plat19 = new Entity(2693, 714, 50, 15, "", "plat19");
                plat20 = new Entity(2873, 640, 50, 15, "", "plat20");
                plat21 = new Entity(2971, 698, 50, 15, "", "plat22");
                
                backgrounds.add(background);
                
                entityList.add(plat1);
                entityList.add(plat2);
                entityList.add(plat3);
                entityList.add(plat4);
                entityList.add(plat5);
                entityList.add(plat6);
                entityList.add(plat7);
                entityList.add(plat8);
                entityList.add(plat9);
                entityList.add(plat10);
                entityList.add(plat11);
                entityList.add(plat12);
                entityList.add(plat13);
                entityList.add(plat14);
                entityList.add(plat15);
                entityList.add(plat16);
                entityList.add(plat17);
                entityList.add(plat18);
                entityList.add(plat19);
                entityList.add(plat20);
                entityList.add(plat21);
                
                enemyList.add(enemy);
                enemyList.add(enemy1);
                enemyList.add(enemyX);
                
                level = 0;
   }
   
    /**
     * Constructs an object of the Game class. Initiates the key array, sets the
     * background color, adds the Key Listener, adds and instantiates all entities,
     * characters, and the background based on the file last saved.
     */
    public Game(Scanner fileIn)
    {
                key = new boolean[8];

                setBackground(Color.BLACK);
		setVisible(true);
		
                this.addMouseListener(this);
		new Thread(this).start();
		addKeyListener(this);
                
                //loads in info for loading
                try
    	        {
                    boolean enemyCheck = true;
                    
                    background = new Entity(0, 0, 3200, 1200, "ElectriCo1.gif", "background");
                    backgrounds.add(background);
                    
                    double x = Double.parseDouble(fileIn.nextLine());
                    double y = Double.parseDouble(fileIn.nextLine());
                    double health = Double.parseDouble(fileIn.nextLine());
                    boolean fly = Boolean.parseBoolean(fileIn.nextLine());
                    test = new Character((int)x, (int)y, (int)50, (int)93, (int)health, fly, "Character\\Hero 1.png", "Main");
                    //fileIn.nextLine();
                    while(fileIn.hasNext() && enemyCheck){
                        String a = fileIn.nextLine();
                        if(a.equals(";"))
                        {
                            enemyCheck = false;
                        }
                        else
                        {
                            double Ex = Double.parseDouble(a);
                            double Ey = Double.parseDouble(fileIn.nextLine());
                            double Eh = Double.parseDouble(fileIn.nextLine()); 
                            double Ew = Double.parseDouble(fileIn.nextLine()); 
                            Entity plat = new Entity((int)Ex, (int)Ey, (int)Eh, (int)Ew, "", "plat");
                            entityList.add(plat);
                        }
                    }
                    while(fileIn.hasNext()){
                            double EnX = Double.parseDouble(fileIn.nextLine());
                            double EnY = Double.parseDouble(fileIn.nextLine());
                            double EnH = Double.parseDouble(fileIn.nextLine()); 
                            Enemy enemy = new Enemy((int)EnX, (int)EnY, 50, 93, (int)EnH, "RobotBlue.gif", "plat");
                            enemyList.add(enemy);
                    }
                }
                catch(Exception e)
                {
                        JOptionPane.showMessageDialog(null, "Unable to load in Game.java  " + e);
                        writeTo("Unable to load in Game.java  " + e);
                }
                
                backgrounds.add(background);
    }
   
   /**
     * Updates the JComponent which allows the game to run.
     * @param - window
     */
   @Override
   public void update(Graphics window)
   {
	   paint(window);
   }
   
   /**
     * Paints the JComponent. Creates a DoubleBuffered Image and runs the game Method.
     * @param - window
     */  
   @Override
   public void paintComponent(Graphics window)
   {
       
	//set up the double buffering to make the game animation nice and smooth
	Graphics2D twoDGraph = (Graphics2D)window;

	//take a snap shop of the current screen and same it as an image
	//that is the exact same width and height as the current screen
	if(back==null)
            back = (BufferedImage)(createImage((int)background.getWidth(),(int)background.getHeight()));

	//create a graphics reference to the back ground image
	//we will draw all changes on the background image
	Graphics graphToBack = back.createGraphics();
                
               game(graphToBack);
                                
               window.setColor(Color.BLUE);
                
               //makes the screen follow the player
	       twoDGraph.drawImage(back, (int)(getWidth()/2 - (test.getX() + test.getWidth()/2)), 
                       (int)(getHeight()/2 - (test.getY() + test.getHeight()/2)), null);
               
               
               //creates the HUD
               window.setColor(Color.DARK_GRAY);
               window.fillRect(0, 550, 800, 50);
               window.setColor(Color.WHITE);
               window.drawString("Enemies Left: " + enemyList.size() + " Health:",10, 560);
               window.setColor(Color.RED);
               window.fillRect(150, 555, test.getHealth() * 5, 10);
               window.setColor(new Color(150, 0, 0));
               window.fillRect(150 + (test.getHealth() * 5), 555,
                               (500 - (test.getHealth() * 5)), 10);
   }
  
  /**
     * Runs the movement and attack actions of the player and enemies, based on user input.
     * @param - graphToBack
     */
   public void game(Graphics graphToBack)
   {
              if(key[5] == true)
                    save();
              if(key[6] == true)
                    test.setFly(!test.getFly());
              if(test.getFly())
                    fly(key[1], key[3], key[0], key[2]);
              else
               move(key[1], key[3], key[0]);
              //melee
              if(key[4] == true)
              {
                  for(Enemy e: enemyList)
                  {
                    if(test.contact(e.getRect()) == true)
                    {
                        e.setHealth(e.getHealth() - test.melee());
                        //e.setXSpeed((int)(Math.copySign(6, (e.getX() - test.getX()))));
                    }
                  }
                  key[4] = false;
              }
              //explosion
              if(key[7] == true)
              {
                  Explosion exp = new Explosion((int)test.getX(),
                            (int)test.getY(), test.getExplosionSize()*20, 
                            test.getExplosionSize()*20, test.getExplosionSize(), (int)test.getExplosionDamage(), "exp");
                  explosions.add(exp);
                  key[7] = false;
              }


              background.moveAndDrawI(graphToBack);
                            
              for(Entity e: entityList)
              {
                      e.moveAndDrawI(graphToBack);
              }  
                              
              trashProjectiles.clear();
              for(Projectile p: projectiles)
              {
                      p.moveAndDrawI(graphToBack);
                      for(Enemy e: enemyList)
                      {
                           if(p.contact(e.getRect()) == true)
                           {
                               trashProjectiles.add(p);
                               e.setHealth(e.getHealth() - test.fire());
                           }
                       
                      }
              }
              
              trashEnemyProjectiles.clear();
              for(Projectile p: enemyProjectiles)
              {
                      p.moveAndDrawI(graphToBack);
                      if(p.contact(test.getRect()) == true)
                      {
                               trashProjectiles.add(p);
                               test.setHealth(test.getHealth() - 5);
                      }

              }
              trashExplosions.clear();
              for(Explosion x: explosions)
              {
                  if(!x.explode(test.getExplosionSize()))
                      trashExplosions.add(x);
                  else
                  {
                        x.explode(test.getExplosionSize());
                        for(Enemy e: enemyList)
                        {
                           if(x.contact(e.getRect()) == true)
                           {
                               trashExplosions.add(x);
                               e.setHealth(e.getHealth() - x.explosion());
                           }
                       
                        }
                        if(x.contact(test.getRect()) == true)
                            test.setHealth(test.getHealth() - 1);
                        x.moveAndDrawI(graphToBack);
                  }
              }
               
              trashEnemy.clear();
              for(Enemy e: enemyList)
              {
                      graphToBack.setColor(Color.RED);
                      graphToBack.fillRect((int)e.getX(), (int)e.getY() + 20, e.getHealth()/2, 10);
                      graphToBack.setColor(new Color(150, 0, 0));
                      graphToBack.fillRect((int)e.getX() + e.getHealth()/2, (int)e.getY() + 20,
                               (e.getMaxHealth() - e.getHealth())/2, 10);
                      if(e.contact(test.getVision()))
                      {
                             e.setXSpeed((int)(Math.copySign(e.getWalkSpeed(), (-test.getX() + e.getX()))));
                             if(e.getEnemyType().equals("Range"))
                             {
                                     if(test.getHitTime() + 1000 <  System.currentTimeMillis())
                                     {
                                            
                                                 double x = e.getX() - test.getX();
                                                 double y = e.getY() - test.getY();
                                                 double c = 5/Math.hypot(x, y);
       
                                                 Projectile proj = new Projectile(e.getX() + e.getWidth()/2, e.getY() + e.getHeight()/2, 
                                                    10, 10, (int)(x*c), (int)(y*c), "Dark Purple Engery Ball.gif", "shot");
                                                enemyProjectiles.add(proj);
                                                test.setHitTime(System.currentTimeMillis());
                                     }
                             }
                             else
                             {
                                if(e.contact(test.getRect()))
                                {
                                    if(e.getEnemyType().equals("Explosive"))
                                    {
                                      Explosion exp = new Explosion((int)test.getX(),
                                        (int)test.getY(), test.getExplosionSize()*20, 
                                        test.getExplosionSize()*20, test.getExplosionSize(), (int)test.getExplosionDamage(), "exp");
                                        explosions.add(exp);
                                        e.setHealth(0);
                                    }  
                                    else
                                    {
                                            if(test.getHitTime() + 480 <  System.currentTimeMillis())
                                            {
                                                test.setHealth(test.getHealth() - 10);
                                                test.setHitTime(System.currentTimeMillis());
                                            }
                                    } 
                                }
                             }
                      }
                      else
                          e.setXSpeed(0);
                      
                      if(e.getHealth() <= 0)
                      {
                           trashEnemy.add(e);
                           test.setExpierence(test.getExpierence() + 10);
                      }
                      e.setYSpeed(e.getYSpeed() - .5); 
                      if(e.contactAnyDown(entityList))
                           e.setYSpeed(0);
                      e.moveAndDrawI(graphToBack);
               }  
              
               enemyList.removeAll(trashEnemy);
               projectiles.removeAll(trashProjectiles);
               explosions.removeAll(trashExplosions);
               
               if(test.getHealth() <= 0)
               {
                        SwingUtilities.getWindowAncestor(this).dispose();
                        GameOver killscreen = new GameOver();
               }
               //if(enemyList.get(0) == null)
                   
               test.moveAndDrawI(graphToBack);
   }
   /**
     * Takes in the key movements and moves the character based on these inputs. Also handles gravity
     * @param - keyA - key input for left movement
     * @param - keyW - key input for jumping
     * @param - keyD - key input for right movement
     */               
   public void move(boolean keyA, boolean keyD, boolean keyW)
   {
       test.setYSpeed(test.getYSpeed() - .5); 
       if(test.contactAnyDown(entityList))
             test.setYSpeed(0);
        
       if(keyA)
       {
             test.setXSpeed(8);
             test.left();
       }
       if(keyD)
       {
             test.setXSpeed(-8);
             test.right();
       }
       if(keyW  && test.contactAnyDown(entityList))
             test.setYSpeed(16);
       
       if(!keyA && !keyD)
       {
             test.setXSpeed(0);
             test.setSprite("Character\\Hero 1.png");
       }
       
       test.setVision(new Rectangle((int)test.getX() -400, (int)test.getY() - 400,800,800));
   }
   /**
     * Takes in the key movements and moves the character based on these inputs without gravity
     * @param - keyA - key input for left movement
     * @param - keyW - key input for up movement
     * @param - keyD - key input for right movement
     * @param - keyS - key input for down movement
     */  
    public void fly(boolean keyA, boolean keyD, boolean keyW, boolean keyS){
       if(keyA)
             test.setXSpeed(10);
       if(keyD)
             test.setXSpeed(-10);
       if(keyW)
             test.setYSpeed(10);
       if(keyS)
             test.setYSpeed(-10);
       
       if(!keyA && !keyD)
             test.setXSpeed(0);
        if(!keyW && !keyS)
             test.setYSpeed(0);
        
        test.setVision(new Rectangle((int)test.getX() - 200, (int)test.getY() - 200,400,400));
    }  
   /**
     * Writes to a save file so info about character location, health, expierence, 
     * fly status, enemy location, and health
     */  
    public void save()
    {
       	try
    	{
            //writes info for the character
    		bwFile = new BufferedWriter(new FileWriter("Saves\\Saves.txt"));
    		bwFile.write("" + test.getX());
                bwFile.newLine();
                bwFile.write("" + test.getY());
                bwFile.newLine();
                bwFile.write("" + test.getHealth());
                bwFile.newLine();
                bwFile.write("" + test.getFly());
                bwFile.newLine();
            //writes info for entities
                for(Entity e: entityList)
                {
                    bwFile.write("" + e.getX());
                    bwFile.newLine();
                    bwFile.write("" + e.getY());
                    bwFile.newLine();
                    bwFile.write("" + e.getWidth());
                    bwFile.newLine();
                    bwFile.write("" + e.getHeight());
                    bwFile.newLine();
                }
            //writes info for enemies
                bwFile.write(";");
                bwFile.newLine();
                for(Enemy e: enemyList)
                {
                    bwFile.write("" + e.getX());
                    bwFile.newLine();
                    bwFile.write("" + e.getY());
                    bwFile.newLine();
                    bwFile.write("" + e.getHealth());
                    bwFile.newLine();
                }
                bwFile.close();
    	}
    	catch(Exception e)
    	{
            JOptionPane.showMessageDialog(null, "Unable to create save file" + e);
            writeTo("Unable to create save file " + e);
     	}
    }
   /**
     * Overrides the keyPressed method so that key input can be taken in
     * @param - e - takes in key inputs
     */ 
   @Override
    public void keyPressed(KeyEvent e)
    {
    		switch(toUpperCase(e.getKeyChar()))
		{
                        //jump   
			case 'W' : key[0]=true; break;
                        //left
			case 'A' : key[1]=true; break;
                        //fly down
			case 'S' : key[2]=true; break;
                        //right
			case 'D' : key[3]=true;; break;
                        //melee
                        case 'Q' : key[4]=true; break;
                        //save
                        case 'G' : key[5]=true; break;   
                        //fly
                        case 'F' : key[6]=true; break;
                        //explosion
                        case 'X' : key[7]=true; break;
		}
    }
   /**
     * Overrides the keyReleased method so that key input can be taken in
     * @param - e - takes in key inputs
     */ 	
   @Override
    public void keyReleased(KeyEvent e)
    {
    		switch(toUpperCase(e.getKeyChar()))
		{
                        //jump   
			case 'W' : key[0]=false; break;
                        //left
			case 'A' : key[1]=false; break;
                        //fly down
			case 'S' : key[2]=false; break;
                        //right
			case 'D' : key[3]=false; break;
                        //melee
                        case 'Q' : key[4]=false; break;
                        //save
                        case 'G' : key[5]=false; break;   
                        //fly
                        case 'F' : key[6]=false; break;
                        //explosion
                        case 'X' : key[7]=false; break;
		}
    }
   /**
     * Overrides the keyPressed method so that key input can be taken in
     * @param - e - takes in key inputs
     */ 
   @Override
    public void keyTyped(KeyEvent e){}
   
   /**
     * Overrides the mouseClicked method so mouse input can be taken in. 
     * Creates a projectile and for in the direction of the characters mouse.
     * @param - e - takes in mouse inputs
     */ 
   @Override
   public void mouseClicked(MouseEvent e)
   {
       
       double x = 370 - e.getX();
       double y = 260 - e.getY();
       double c = test.getProjectileSpeed()/Math.hypot(x, y);
       
       Projectile proj = new Projectile(test.getX() + test.getWidth()/2, test.getY() + test.getHeight()/2, 
               10, 10, (int)(x*c), (int)(y*c), "green energy ball.gif", "shot");
       projectiles.add(proj);
   }
   /**
     * Overrides the mousePressed method so that key input can be taken in
     * @param - e - takes in mouse inputs
     */ 
   @Override
   public void mousePressed(MouseEvent e)
   {
       mouse = true;
   }
   /**
     * Overrides the mouseReleased method so that mouse input can be taken in
     * @param - e - takes in key inputs
     */ 
   @Override
   public void mouseReleased(MouseEvent e)
   {
       mouse = false;
   }
   /**
     * Overrides the mouseEntered method so that mouse input can be taken in
     * @param - e - takes in key inputs
     */ 
   @Override
   public void mouseEntered(MouseEvent e){}
   /**
     * Overrides the mouseExited method so that mouse input can be taken in
     * @param - e - takes in key inputs
     */ 
   @Override
   public void mouseExited(MouseEvent e){}
   /**
     * Overrides the run method so the Runnable will implement
     */ 
   @Override
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, "Unable to run game " + e); 
          ErrorLog.writeTo("Unable to run game " + e);
      }
    }
}