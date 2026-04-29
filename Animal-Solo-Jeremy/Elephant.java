import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elehant our hero.
 * 
 * @author (Jeremy) 
 * @version (April 2026)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("Elephant sound");
    GreenfootImage idle = new GreenfootImage("elephant_1");
    public Elephant()
    {
        //for(int i=0; i<idle.length;i++)
        {
            //idle[i] = new GreenfootImage["elephant_1"+i];
            
        }
        //setImage(idle[0]);
    }
    public void act() 
    {
        if(Greenfoot.isKeyDown("left")){
            move(-5);
        }
        else if(Greenfoot.isKeyDown("right")){
            move(5);
        }
        
        eat();
        
        
    }
    public void eat()
    {
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
