import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage Robotimage1= new GreenfootImage("man01.png");
    private GreenfootImage Robotimage2= new GreenfootImage("man02.png");
    private GreenfootImage Robotimage3= new GreenfootImage("gameover.png");
    private int lives = 3;
    private int score = 0;
    private int pizzaEaten = 0;
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        robotMove();
        
        detectWallCollision();
        
        detectBlockCollision();
        
        detectHome();
        
        eatPizza();
        
        
    }    
    
    public void robotMove()
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() -3);
            animate();
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() +3);
            animate();
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() -3, getY());
            animate();
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() +3, getY());
            animate();
        }
    }
    
    public void detectWallCollision()
    {
        if (isTouching(Wall.class))
        {
           setLocation(90, 30);
           Greenfoot.playSound("hurt.wav");
           removeLife();
        }
    }
    
    public void detectBlockCollision()
    {
        if (isTouching(Block.class))
        {
            Greenfoot.playSound("hurt.wav");
            setLocation(90, 30);
            removeLife();
        }
    }
    
    public void detectHome()
    {
        if (isTouching(Home.class))
        {
            Greenfoot.playSound("yipee.wav");
            setLocation(90, 30);
            increaseScore();
            if (pizzaEaten == 5)
            {
                Greenfoot.stop();
            }
        }
    }
    
    public void eatPizza()
    {
        if (isTouching(Pizza.class))
        {
            Greenfoot.playSound("eat.wav");
            removeTouching(Pizza.class);
            pizzaEaten = pizzaEaten +1;
        }
    }
    
    public void animate()
    {
        if (getImage()== Robotimage1)
        {
            setImage (Robotimage2);
        }
        else
        {
            setImage (Robotimage1);
        }
    }
    
    public void removeLife()
    {
        lives = lives -1;
        testEndGame();
    }
    
    public void testEndGame()
    {
        if (lives == 0)
        {
            setImage (Robotimage3);
            Greenfoot.stop();
        }
    }
    
    public void increaseScore()
    {
            score = score +1;
    }
}
