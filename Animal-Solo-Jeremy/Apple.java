import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The food our elephant eats.
 * 
 * @author (Jeremy) 
 * @version (April 2026)
 */
public class Apple extends Actor
{
    int speed = 1;
    public void act() 
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        //setLocation(getX(), getY() + 2);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
