import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author Demitre Beltran 
 * @version (a version number or a date)
 */
public class RobotWorld extends World
{

    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        addObject (new Robot() ,90,30);
        
        addObject (new Wall() ,50,150);
        addObject (new Wall() ,150,150);
        addObject (new Wall() ,250,150);
        addObject (new Wall() ,750,150);
        addObject (new Wall() ,650,150);
        addObject (new Wall() ,580,150);
        
        addObject (new Block() ,415,150);
        
        addObject (new Home() ,750,550);
        
        addObject (new ScorePanel() ,75,550);
        
        addObject (new Pizza() ,400,390);
        addObject (new Pizza() ,740,270);
        addObject (new Pizza() ,80,280);
        addObject (new Pizza() ,415,50);
        addObject (new Pizza() ,705,70);
    }
}
